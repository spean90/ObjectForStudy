package com.spean90.hibernate4.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
	
	public int updateUserInfo(UserInfo userInfo) {
		Session session = UserInfoDao.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		userInfo = (UserInfo) session.get(UserInfo.class, userInfo.getUid());
		userInfo.setAddMan("dba");
		System.out.println(userInfo.getRealName());
		int i = (int) session.save(userInfo);
		tr.commit();
		return i;
	}
	
	public List<UserInfo> getUserInfoByParam(UserInfo userInfo) {
		List<UserInfo> list = null;
		Session session = UserInfoDao.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(UserInfo.class);
		criteria.add(Restrictions.gt("uid", 0)).addOrder(Order.asc("uid")).setFirstResult(0).setMaxResults(10);
		criteria.setCacheable(true);
		list = criteria.list();
		return list;
	}
}
