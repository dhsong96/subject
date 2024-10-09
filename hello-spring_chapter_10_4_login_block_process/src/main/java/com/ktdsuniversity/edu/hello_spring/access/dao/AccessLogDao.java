package com.ktdsuniversity.edu.hello_spring.access.dao;

import com.ktdsuniversity.edu.hello_spring.access.vo.AccessLogVO;

public interface AccessLogDao {

	public String NAMESPACE = "com.ktdsuniversity.edu.hello_spring.access.dao.AccessLogDao";
	
	public int insertNewAccessLog(AccessLogVO accessLogVO);
	
	/**
	 * ip로 조회. 최근 몇번 실패했느냐
	 * @param ip
	 * @return
	 */
	public int selectLoginFailCount(String ip);
}
