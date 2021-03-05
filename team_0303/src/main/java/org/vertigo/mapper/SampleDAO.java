package org.vertigo.mapper;

import org.vertigo.domain.SampleDTO;

public interface SampleDAO {

	// string 을 가져오는게 아니고 SampleDTO를 가져올것이다.
	SampleDTO getOne(int index);
	
	// tbl_sample 의 여러줄 = list다. 
	// List<SampleDTO> getAll(int index);
}
