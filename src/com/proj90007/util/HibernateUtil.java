package com.proj90007.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory	sessionFactory;
	private static ServiceRegistry serviceRegistry;

	static
		{
			try
				{
					Configuration configuration = new Configuration();
					configuration.configure();
					serviceRegistry = new ServiceRegistryBuilder().applySettings(
			            configuration.getProperties()). buildServiceRegistry();
					sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//					Hibernate 4.X new sessionFactory Build method
//					sessionFactory = new Configuration().configure()
//						.buildSessionFactory();
				}
			catch (Exception ex)
				{
					ex.printStackTrace();
				}

		}

	public static Session openSession()
		{
			Session session = sessionFactory.openSession();
			return session;
		}

	public static void closeSession(Session session)
		{
			if (null != session)
				{
					session.close();
				}
		}
	
}
