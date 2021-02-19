package com.fazil.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtility {
	private static SessionFactory sessionFactory;
	
	private HibernateUtility() {
		
	}
	static {
		Configuration cfg=new Configuration().configure();
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		sessionFactory=cfg.buildSessionFactory(reg);
	}
	
	private static ThreadLocal<Session> tlocal=new ThreadLocal<Session>();
	public synchronized static Session getSession() {
		Session session=tlocal.get();
		if(session==null) {
			session=sessionFactory.openSession();
			tlocal.set(session);
			session.beginTransaction();
		}
		return session;
	}
	public synchronized static void closeSession(Exception e) {
		Session session=tlocal.get();
		if(session!=null) {
			if(e==null) {
				session.getTransaction().commit();
				session.close();
				tlocal.remove();
			}else {
				session.getTransaction().rollback();
				session.close();
				tlocal.remove();
			}
		}
	}
}
