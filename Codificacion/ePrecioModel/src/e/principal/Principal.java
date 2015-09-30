package e.principal;

import e.servicio.ServicioPrecio;
import e.util.SpringUtil;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// HibernateUtil.getSessionFactory();
			Class.forName("com.mysql.jdbc.Driver");
			SpringUtil.obtenerContextoSpring();
			ServicioPrecio servicioGeneral = (ServicioPrecio) SpringUtil.obtenerBeanSpring("servicioPrecio");
			System.out.println(servicioGeneral.iniciarSesion("usuario", "clave"));

			/*
			 * Connection connection =
			 * DriverManager.getConnection("jdbc:mysql://192.168.56.101:3306/precio"
			 * , "precio", "precio"); Statement stmt =
			 * connection.createStatement(); stmt.executeUpdate(
			 * "CREATE TABLE a (id int not null primary key, value varchar(20))"
			 * ); stmt.close(); connection.close();
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
