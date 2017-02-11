package ar.com.clothes;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import ar.com.clothes.configuration.AppConfig;
import ar.com.clothes.model.Empresa;
import ar.com.clothes.model.Usuario;
import ar.com.clothes.service.EmpresaService;
import ar.com.clothes.service.UsuarioService;

/**
 * 
 * @author MostroBook
 *
 */
public class AppMain {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UsuarioService service = (UsuarioService) context.getBean("usuarioService");
        EmpresaService empService = (EmpresaService) context.getBean("empresaService");
        
        /*
         * Obtbener todos los usuarios 
         */
        List<Usuario> employeeList = service.findAllUsuarios();
        for (Usuario emp : employeeList) {
            System.out.println(emp);
        }
        
        List<Empresa> empList = empService.findAllEmpresa();
        for (Empresa emp : empList) {
            System.out.println(emp);
        }
 
        context.close();
	}
}
