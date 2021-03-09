package org.kent.common.config;

import org.kent.board.config.BoardConfig;
import org.kent.time.config.TimeConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig 
	extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// 1번재 방법. commonConfig를 넣어준다.
		// 2번째 방법. timeConfig만 넣어준다.
		return new Class[] {
				CommonConfig.class
				, TimeConfig.class
				, BoardConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// /가 들어가면 dispathServlet을 호출한다는 뜻이다!
		return new String[] {"/"};
	}
	
}
