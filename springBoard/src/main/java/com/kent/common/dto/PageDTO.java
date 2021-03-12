package com.kent.common.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageDTO {

    @Builder.Default
    private int page = 1;
    @Builder.Default
    private int perSheet = 10;

    // 검색할 타입과 키워드 추가
    private String type;
    
    private String keyword;
    
    // t c w => tcw
    // "t" "c" "w" 
    public String[] getArr() {
    	if(null == keyword || 0 == keyword.trim().length()) {
    		return null;
    	}
    	if(null == type || type.equals("None") || 0 == type.trim().length()) {
    		return null;
    	}
    	
    	return type.split("");
    }
    // (1P) 0번부터
    // (2p) (-20 - 1 ) * 10 = 10, 10
    // limit 0, 10
    
    // 음수가 나오면 안된다.
    // validation 처리를 할 수도 있다.
    // 알아서 해보자
    public int getSkip(){
        return (page - 1) * perSheet < 0 ? 0 : (page - 1) * perSheet;
    }

}
