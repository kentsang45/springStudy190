package org.kent.service;

import org.kent.mapper.SampleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class SampleServiceImpl implements SampleService {

	private final SampleMapper mapper;
	
	@Transactional
	@Override
	public String testTX() {
		String str = "---------------------1\r\n"
				+ "\r\n"
				+ "동해 물과 백두산이 마르고 닳도록\r\n"
				+ "하느님이 보우하사 우리나라 만세.\r\n"
				+ "무궁화 삼천리 화려 강산\r\n"
				+ "대한 사람, 대한으로 길이 보전하세.\r\n"
				+ "2\r\n"
				+ "\r\n"
				+ "남산 위에 저 소나무, 철갑을 두른 듯\r\n"
				+ "바람 서리 불변함은 우리 기상일세.\r\n"
				+ "무궁화 삼천리 화려 강산\r\n"
				+ "대한 사람, 대한으로 길이 보전하세.\r\n"
				+ "3\r\n"
				+ "\r\n"
				+ "가을 하늘 공활한데 높고 구름 없이\r\n"
				+ "밝은 달은 우리 가슴 일편단심일세.\r\n"
				+ "무궁화 삼천리 화려 강산\r\n"
				+ "대한 사람, 대한으로 길이 보전하세.\r\n"
				+ "4\r\n"
				+ "\r\n"
				+ "이 기상과 이 맘으로 충성을 다하여\r\n"
				+ "괴로우나 즐거우나 나라 사랑하세.\r\n"
				+ "무궁화 삼천리 화려 강산\r\n"
				+ "대한 사람, 대한으로 길이 보전하세.";
		mapper.insert1(str);
		mapper.insert2(str);
		
		return "testTX";
	}
	
	@Override
	public String doA() {
		log.info("doA from service..................");
		return "doA";
	}

	@Override
	public String doB() {
		log.info("doB from service..................");
		return "doB";
	}

	@Override
	public String doC() {
		log.info("doC from service..................");
		return "doC";
	}

	@Override
	public String insertBoardTest() {
		// TODO Auto-generated method stub
		mapper.insert3("aaa", "bbb", "ccc");
		log.info("============== insertBoardTest ================");
		log.info("GET LAST : " + mapper.getLastID());
		
		return null;
	}
	
}
