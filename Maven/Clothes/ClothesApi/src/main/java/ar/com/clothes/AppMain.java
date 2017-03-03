package ar.com.clothes;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import ar.com.clothes.configuration.AppConfig;
import ar.com.clothes.model.Cliente;
import ar.com.clothes.model.Empresa;
import ar.com.clothes.model.Medida;
import ar.com.clothes.model.Modelo;
import ar.com.clothes.model.Usuario;
import ar.com.clothes.service.ClienteService;
import ar.com.clothes.service.EmpresaService;
import ar.com.clothes.service.MedidaService;
import ar.com.clothes.service.ModeloService;
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
		ClienteService clienteService = (ClienteService) context.getBean("clienteService");
		MedidaService medidaService = (MedidaService) context.getBean("medidaService");
		ModeloService modeloService = (ModeloService) context.getBean("modeloService");

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

		List<Cliente> listaCli = clienteService.findByEmpresa(Integer.valueOf("1"));
		for (Cliente cli : listaCli) {
			System.out.print(cli);
		}

		List<Medida> listaMedidas = medidaService.findAllMedida();
		for (Medida med : listaMedidas) {
			System.out.println(med);
		}

		List<Modelo> listaModelo = modeloService.findAllModelo();
		for (Modelo med : listaModelo) {
			System.out.println(med);
		}

		context.close();
	}
}
