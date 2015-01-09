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
	
	
	
	//@Test
	public void testSaveUserInfo() {
		logger.info("in...testDao...");
		UserInfoDao userInfoDao = new UserInfoDao();
		UserInfo userInfo = new UserInfo();
		userInfo.setAccount("abc");
		System.out.println(userInfoDao.saveUserInfo(userInfo));
		
	}
	
	//@Test
	public void testUpdate() {
		UserInfoDao userInfoDao = new UserInfoDao();
		UserInfo userInfo = new UserInfo();
		userInfo.setUid(1);;
		userInfoDao.updateUserInfo(userInfo);
	}
	@Test
	public void testQuery() {
		UserInfoDao userInfoDao = new UserInfoDao();
		UserInfo userInfo = new UserInfo();
		List<UserInfo> list = userInfoDao.getUserInfoByParam(userInfo);
		System.out.println("size:"+list.size());
		System.out.println("id:"+list.get(0).getUid());
	}
	
	
}
