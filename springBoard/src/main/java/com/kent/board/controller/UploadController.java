package com.kent.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kent.common.dto.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@RestController
@RequestMapping("/board")
@Log4j
public class UploadController {
	
	// 파일 이름을 받으면 저장해둔 폴더에 가서 그 파일을 다시 보내준다.
	@GetMapping("/display")
	public ResponseEntity<byte[]> viewFile(String file){
		log.info("============ VIEW FILE ===========");
		byte[] result = null;
		ResponseEntity<byte[]> re = null;
		
		try {
			String deStr = URLDecoder.decode(file, "UTF-8").replace("#", ".");
			log.info(deStr);
			
			// 대상 파일
			File targetFile = new File("C:\\upload\\" + deStr);
			
			// MIME TYPE
			String mimeType = Files.probeContentType(targetFile.toPath());
			
			// HEADER
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", mimeType);
			
			re = new ResponseEntity<byte[]>(
						FileCopyUtils.copyToByteArray(targetFile), header, HttpStatus.OK
					);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return re;
	}
	
	@PostMapping("/upload")
	public ResponseEntity<Map<String, Object>> postUpload(MultipartFile[] files) {
		log.info("================= UPLOAD ===============");

		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<AttachFileDTO> list = new ArrayList<AttachFileDTO>();
		// 0. null, size 체크
		if(null == files || 0 >= files.length) {
			log.info("================= UPLOAD FAIL ===============");
			resultMap.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
		}
		
		// 1. 파일 이름 설정
		String datePath = getDateFolder();
		String parentPath = "C:\\upload";
		File basePath = new File(parentPath, datePath);
		// 없으면 생성
		if(false == basePath.exists()) {
			basePath.mkdirs();
		}
		
		// 2. 가져온 파일 리스트를 저장!
		for(int i = 0; i < files.length; ++i) {
			MultipartFile multiFile = files[i];
			
			// 2-1. 가져온 파일 이름
			String fileName = multiFile.getOriginalFilename();
			String uuid = UUID.randomUUID().toString();
			String fileFullName = uuid +"_"+ fileName;
			// 이 파일이 image 인가?
			Boolean isImage = multiFile.getContentType().startsWith("image");
			
			// 3. 파일 이름으로 저장(basePath에 fileFullName이라는 이름으로 저장)
			File saveFile = new File(basePath, fileFullName);
			
			// 4. 생성한 파일에 데이터를 채우기
			try {
				multiFile.transferTo(saveFile);
				
				// 4-1. type이 image라면 썸네일 저장
				if(true == isImage) {
					try (FileOutputStream fos = new FileOutputStream(new File(basePath, "s_"+fileFullName))){
						Thumbnailator.createThumbnail(multiFile.getInputStream(), fos, 100, 100);
					} catch(Exception e) {
						e.printStackTrace();
					}
				// end of if	
				}
				
				// 5. AttackFileDTO 생성 후 전송
				AttachFileDTO dto = new AttachFileDTO(fileName, datePath, uuid, isImage);
				list.add(dto);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			// end of for
		}
		
		resultMap.put("message", "success");
		resultMap.put("list", list);
		
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	// 폴더 생성, 경로 반환
	private String getDateFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String result = sdf.format(new Date()); // 시스템 시간
		return result.replace("-", File.separator);
	}
}
