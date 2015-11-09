package e.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {

			Configuration cfg = new Configuration().addClass(e.dominio.entity.Clientes.class).addClass(e.dominio.entity.Clientes.class).
					setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect").
					setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver").					
					setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/NicoleJeniffer").
					setProperty("hibernate.connection.username", "root").
					setProperty("hibernate.connection.password", "154122954");

			// Create the SessionFactory from hibernate.cfg.xml
			// return cfg.configure().buildSessionFactory(new
			// StandardServiceRegistryBuilder().build());			

			return cfg.configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
