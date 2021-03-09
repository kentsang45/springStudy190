package org.vertigo.common.dto;

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

    // 음수가 나오면 안된다.
    // validation 처리를 할 수도 있다.
    // 알아서 해보자
    public int getSkip(){
        return (page - 1) * perSheet < 0 ? 0 :  (page - 1) * perSheet ;
    }



}
