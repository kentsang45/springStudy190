package com.kent.common.mapper;

import java.util.List;

import com.kent.common.domain.AttachFile;

public interface AttachFileMapper {


	void insert(AttachFile vo);
	
	List<AttachFile> getFiles(Integer bno);

	AttachFile getOneFile(Integer ano);
}
