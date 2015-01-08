package com.spean90.hibernate4.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.spean90.hibernate4.modal.UserInfo;

public class UserInfoDao {

	private static  SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure("hibernate4/hibernate.cfg.xml").buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public List<UserInfo> getUserInfoList() {
		List<UserInfo> list = null;
		Session session = UserInfoDao.getSessionFactory().openSession();
		list = session.createQuery("from UserInfo").list();
		return list;
	}
	
	public int saveUserInfo(UserInfo userInfo) {
		Session session = UserInfoDao.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		int i = (int) session.save(userInfo);
		tr.commit();
		return i;
	}
}
