package com.kent.common.domain;


import java.util.Date;

import com.kent.board.domain.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AttachFile {
	private Integer ano;
	private String fileName;
	private String uploadPath;
	private String uuid;
	private Boolean img;
	private Integer bno;
}
