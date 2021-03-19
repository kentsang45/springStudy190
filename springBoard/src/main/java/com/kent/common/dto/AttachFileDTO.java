package com.kent.common.dto;

import java.net.URLEncoder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachFileDTO {
	private String fileName;
	private String uploadPath;
	private String uuid;
	private Boolean isImage;
	
	public String getUrl() {
		String str = uploadPath + "/" + uuid + "_" + fileName.replace(".", "#");		
		return decode(str);
	}
	
	public String getThumbUrl() {
		String str = uploadPath + "/s_" + uuid + "_" + fileName.replace(".", "#");		
		return decode(str);
	}
	
	
	
	public String decode(String str) {
		String result = "";
		try {
			result = URLEncoder.encode(str, "UTF-8");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
