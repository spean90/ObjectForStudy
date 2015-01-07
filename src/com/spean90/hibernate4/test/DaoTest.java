package com.spean90.hibernate4.test;

import java.util.List;

import org.junit.Test;

import com.spean90.hibernate4.dao.UserInfoDao;
import com.spean90.hibernate4.modal.UserInfo;

public class DaoTest {

	
	
	@Test
	public void testUserInfoDaoList() {
		UserInfoDao userInfoDao = new UserInfoDao();
		List<UserInfo> list = userInfoDao.getUserInfoList();
		System.out.println(list.size());
	}
}
