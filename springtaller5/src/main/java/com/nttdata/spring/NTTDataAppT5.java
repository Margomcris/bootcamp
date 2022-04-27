package com.nttdata.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.services.CustomerManagementServiceI;

/**
 * Formación - Spring - Taller 5
 * 
 * Clase principal
 * 
 * @author NTT Data Sevilla
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class NTTDataAppT5 implements CommandLineRunner {

	/** Servicio de gestión de clientes */
	@Autowired
	private CustomerManagementServiceI customerService;

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataAppT5.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("----- NTT DATA SYS - INI -----");

		// Nuevos clientes.
		final Customer newCustomer1 = new Customer();
		newCustomer1.setName("Alejandro");
		newCustomer1.setSurName1("Téllez");
		newCustomer1.setSurName2("Rubio");
		newCustomer1.setIdentityDocNumber("28999666A");
		customerService.insertNewCustomer(newCustomer1);

		final Customer newCustomer2 = new Customer();
		newCustomer2.setName("Alejandro");
		newCustomer2.setSurName1("Brazo");
		newCustomer2.setSurName2("Luque");
		newCustomer2.setIdentityDocNumber("30111555B");
		customerService.insertNewCustomer(newCustomer2);

		final Customer newCustomer3 = new Customer();
		newCustomer3.setName("Estefanía");
		newCustomer3.setSurName1("Cano");
		newCustomer3.setSurName2("Muñiz");
		newCustomer3.setIdentityDocNumber("27000888C");
		customerService.insertNewCustomer(newCustomer3);

		System.out.println("----- NTT DATA SYS - FIN -----");

	}

}
