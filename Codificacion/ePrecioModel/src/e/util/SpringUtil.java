package e.util;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author egiors
 */
public final class SpringUtil {

    private static final Logger log = Logger.getLogger(SpringUtil.class);
    private static ApplicationContext contextoSpring = null;

    public static ApplicationContext obtenerContextoSpring() {
        if (contextoSpring == null) {
            contextoSpring = new ClassPathXmlApplicationContext(new String[]{"e/configuracion/servicios.xml"});
            log.debug("contexto spring recien creado");
        } else {
            log.debug("contexto spring existente");
        }
        log.debug("contextoSpring " + contextoSpring);
        return contextoSpring;
    }

    public static Object obtenerBeanSpring(String nombreDelBeanSpring) {
        try {
            return obtenerContextoSpring().getBean(nombreDelBeanSpring);
        } catch (Exception e) {
            log.error("Error",e);
            return null;
        }
    }

//    public static ServicioEscritorio obtenerBeanServicioEscritorio() {
//        log.debug("obtenerBeanServicioEscritorio()");
//        Object objeto = obtenerBeanSpring("servicioEscritorio");
//        ServicioEscritorio bean = null;
//        if (objeto != null) {
//            bean = (ServicioEscritorio) objeto;
//        }
//        log.debug(bean);
//        return bean;
//    }
}
