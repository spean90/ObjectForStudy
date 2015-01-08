package com.spean90.hibernate4.test;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spean90.hibernate4.dao.UserInfoDao;
import com.spean90.hibernate4.modal.UserInfo;

public class DaoTest {

	Logger logger = LoggerFactory.getLogger(DaoTest.class);
	
	
	//@Test
	public void testUserInfoDaoList() {
		logger.info("in...testDao...");
		UserInfoDao userInfoDao = new UserInfoDao();
		List<UserInfo> list = userInfoDao.getUserInfoList();
		System.out.println(list.size());
	}
	
	@Test
	public void testSaveUserInfo() {
		logger.info("in...testDao...");
		UserInfoDao userInfoDao = new UserInfoDao();
		UserInfo userInfo = new UserInfo();
		userInfo.setAccount("abc");
		System.out.println(userInfoDao.saveUserInfo(userInfo));
		
	}
}
