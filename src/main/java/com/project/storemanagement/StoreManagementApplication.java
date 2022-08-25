package com.project.storemanagement;

import com.project.storemanagement.Controladores.Empleado;
import com.project.storemanagement.Controladores.Empresa;
import com.project.storemanagement.Controladores.Movimiento;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.project.storemanagement.*;

@SpringBootApplication
public class StoreManagementApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(StoreManagementApplication.class, args);
		//Instaciar clase empleado
		Empleado empleado = new Empleado("hellen Acosta","correo@gmail.com","admin");
		//Instaciar clase empresa
		Empresa empresa = new Empresa();
		//Instaciar clase movimiento
		Movimiento movimiento = new Movimiento();
		System.out.println(empleado.toString());


	}

}
