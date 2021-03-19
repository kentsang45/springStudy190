package org.kent.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.kent.dto.AttachFileDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@RestController
@Log4j
public class UploadController {
	
	String basePath = "C:\\upload\\";
	
	// 415 에러... 
	// 삭제
	@DeleteMapping("/removeFile")
	public ResponseEntity<String> removeFile(@RequestBody AttachFileDTO dto){
		
		log.info("================== REMOVE FILE ==================");
		log.info(dto);
		
		String filePath = basePath + dto.getUploadPath();
		String fileFullPath = dto.getUuid() + "_" + dto.getFileName();
		
		if(dto.getIsImage()) {
			File thumb = new File(filePath + File.separator + "s_" + fileFullPath);
			thumb.delete();
		}
		
		File target = new File(filePath + File.separator + fileFullPath);
		target.delete();		
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	
	
	// 파일 이름을 받으면 저장해둔 폴더에 가서 그 파일을 다시 보내준다.
	@GetMapping("/view")
	public ResponseEntity<byte[]> viewFile(String file){
		log.info("================= VIEW FILE ===================");
		byte[] result = null;
		ResponseEntity<byte[]> res = null;
		
		try {
			String deStr = URLDecoder.decode(file, "UTF-8").replace("#", ".");
			log.info(deStr);
			
			File targetFile = new File("C:\\upload\\" + deStr);
			
			// header 메시지 필요
			// MIME TYPE
			String mimeType = Files.probeContentType(targetFile.toPath());
			
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", mimeType);
			
			res = new ResponseEntity<byte[]>(
					FileCopyUtils.copyToByteArray(targetFile), header, HttpStatus.OK
					);
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		return res;
	}
	
	@PostMapping("/upload")
	// formData를 body에 담아서 보냈다.
	// 들어오면 MultipartFile[] 로 바뀐다.
	public ResponseEntity<List<AttachFileDTO>> upload(MultipartFile[] files){
		log.info("================ UPLOAD ================");
		log.info(files);
		
		List<AttachFileDTO> list = new ArrayList<AttachFileDTO>();
		
		// null, size 체크
		if(null == files || 0 >= files.length) {
			return new ResponseEntity<List<AttachFileDTO>>(list, HttpStatus.OK);
		}
		
		// 파일은 DB로 보내지 않고 HardDisk에 저장한다.
		// DB에는? 경로 또는 이름만 저장한다.
		String folderPath = getFolder(); // 2021/03/17
		// 파일 저장 경로
		String uploadFolder = "C:\\upload";
		File uploadPath = new File(uploadFolder, folderPath); // 경로를 설정... (부모 경로), (자식 경로) C:\\upload\\2021\\03\\17
		
		// 있으면 null이 아니다. 없으면 null이다.
		if(false == uploadPath.exists()) {
			// 실제 폴더를 생성
			uploadPath.mkdirs();
		}
		
		// AJAX를 통해서 가져온 files들...
		for(int i = 0; i < files.length; ++i) {
			MultipartFile mfile = files[i];
			
			// 1. 파일 이름 생성
			String fileName = mfile.getOriginalFilename();
			String uuid = UUID.randomUUID().toString(); // 굉장히 unique한 ID(숫자)입니다.
			String fileFullName = uuid + "_" + fileName; // 파일이름에 UUID를 삽입			
			// 유저가 업로드한 파일이 이미지인지 확인
			// MimeType
			Boolean isImage = mfile.getContentType().startsWith("image");
			
			// 2. 파일 저장
			// 파일 저장
			File saveFile = new File(uploadPath, fileFullName);
			
			// 파일 전송
			try {
				// c:\\upload 에 실제로 저장
				mfile.transferTo(saveFile);
				
				// 3. 썸네일 저장
				// Type이 image라면... Thumbnail 생성
				if(true == isImage) {
					try(FileOutputStream fos = new FileOutputStream(new File(uploadPath, "s_" + fileFullName))){
						Thumbnailator.createThumbnail(mfile.getInputStream(), fos, 100, 100);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				// 4. AttachFileDTO 생성
				// upload가 끝나고... fileDTO 보내기
				// 어디로 간다? Browser, then으로 간다.
				AttachFileDTO dto = new AttachFileDTO(fileName, folderPath, uuid, isImage);
				list.add(dto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// for ends here...!
		}
		
		// 5. 다시 Browser로 보내기
		return new ResponseEntity<List<AttachFileDTO>>(list, HttpStatus.OK);
	}
	
	
	// 폴더 생성, 경로 반환
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String result = sdf.format(new Date()); // 시스템 시간
		return result.replace("-", File.separator);
	}
}
