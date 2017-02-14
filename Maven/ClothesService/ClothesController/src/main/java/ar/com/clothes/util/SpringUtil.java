package ar.com.clothes.util;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ar.com.clothes.configuration.AppConfig;

/**
 * 
 * @author MostroBook
 */
public final class SpringUtil {

	private static final Logger log = Logger.getLogger(SpringUtil.class);
	private static ApplicationContext contextoSpring = null;
	
	/**
	 * 
	 * @return
	 */
	public static ApplicationContext obtenerContextoSpring() {
		if (contextoSpring == null) {
			contextoSpring = new AnnotationConfigApplicationContext(AppConfig.class);
			log.debug("contexto spring recien creado");
		} else {
			log.debug("contexto spring existente");
		}
		log.debug("contextoSpring " + contextoSpring);
		return contextoSpring;
	}

	/**
	 * 
	 * @param nombreDelBeanSpring
	 * @return
	 */
	public static Object obtenerBeanSpring(String nombreDelBeanSpring) {
		try {
			return obtenerContextoSpring().getBean(nombreDelBeanSpring);
		} catch (Exception e) {
			log.error("Error", e);
			return null;
		}
	}

}
