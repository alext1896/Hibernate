package es.profesor.utiles;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Utilidades {
	// Factoria de sesion para crear objeto sesion a partir de XML
		private static SessionFactory sessionFactory;

		private static SessionFactory buildSessionFactory() {

			try {

				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
						.configure("hibernate.cfg.xml").build();
				Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
				return metadata.getSessionFactoryBuilder().build();

			} catch (HibernateException he) {
				System.out.println("Session Factory creation failure");
				throw he;
			}
		}

		/*
		 * M�todo estatico (Fachada) para crear la factoria de sesiones
		 */
		public static SessionFactory getSessionFactory() {
			if (sessionFactory == null)
				sessionFactory = buildSessionFactory();
			return sessionFactory;
		}

}
