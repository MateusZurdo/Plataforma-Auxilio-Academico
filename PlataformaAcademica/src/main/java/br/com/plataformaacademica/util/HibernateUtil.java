package br.com.plataformaacademica.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory = criarSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	private static SessionFactory criarSessionFactory() {
		try {
			Configuration configuration = new Configuration().configure();

			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
					.build();

			SessionFactory factory = configuration.buildSessionFactory(registry);

			return factory;
		} catch (Throwable ex) {
			System.err.println("A SessionFactory não pode ser criada. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

}