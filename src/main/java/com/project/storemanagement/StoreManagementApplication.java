package com.project.storemanagement;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class StoreManagementApplication {

	public static void main(String[] args)
	{

				SpringApplication.run(StoreManagementApplication.class, args);
				/*
		//Instaciar clase empleado
		Empleado empleado = new Empleado("hellen Acosta","correo@gmail.com","admin");

		//Instaciar clase empresa
		Empresa empresa = new Empresa("Isa", "Calle1",123,5555);

		//Instaciar clase movimiento
		Movimiento movimiento = new Movimiento();

		//Imprimir lo que contiene cada clase
		System.out.println(empleado.toString());
		System.out.println(empresa.toString());

*/

	}

}
