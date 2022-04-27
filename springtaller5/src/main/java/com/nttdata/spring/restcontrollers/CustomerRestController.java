package com.nttdata.spring.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.services.CustomerManagementServiceI;

/**
 * Formación - Spring - Taller 5
 * 
 * Controlador REST.
 * 
 * @author NTT Data Sevilla
 *
 */
@RestController
@RequestMapping("/customers")
public class CustomerRestController {

	/** Servicio: gestión de clientes */
	@Autowired
	private CustomerManagementServiceI customerService;

	/**
	 * Retorna todos los clientes.
	 * 
	 * @return List<Customer>
	 */
	@GetMapping
	public List<Customer> showCustomers() {

		// Obtención de los clientes.
		return customerService.searchAllCustomers();
	}

	/**
	 * Añade un nuevo cliente.
	 * 
	 * @param newCustomer
	 */
	@PostMapping
	public void addCustomer(final @RequestBody Customer newCustomer) {
		customerService.insertNewCustomer(newCustomer);
	}

	/**
	 * Elimina un cliente.
	 * 
	 * @param id
	 */
	@DeleteMapping(value = "/{id}")
	public void deleteCustomer(final @PathVariable Long id) {
		customerService.deleteById(id);
	}

	/**
	 * Método para buscar a través de parámetro dado.
	 * 
	 * @param customer
	 * @return List<Customer>
	 */
	@RequestMapping(path = "/customer", method = RequestMethod.POST, consumes = "application/json")
	public List<Customer> searchBy(@RequestBody Customer customer) {

		// Posibilidad de múltiples resultados.
		List<Customer> customersList = new ArrayList<Customer>();

		// Búsqueda por nombre o nombre completo.
		if (customer != null) {

			// Obtención de filtro de búsqueda.
			final String name = customer.getName();
			final String surName1 = customer.getSurName1();
			final String surName2 = customer.getSurName2();
			final String identityDocNumber = customer.getIdentityDocNumber();

			if (StringUtils.hasText(identityDocNumber)) {

				// Búsqueda de cliente único por documento de identidad.
				customer = customerService.searchByIdentityDocNumber(identityDocNumber);
				customersList.add(customer);

			} else if (StringUtils.hasText(name) && (!StringUtils.hasText(surName1) || !StringUtils.hasText(surName2))) {

				// Búsqueda por nombre.
				customersList = customerService.searchByName(name);

			} else if (StringUtils.hasText(name) && StringUtils.hasText(surName1) && StringUtils.hasText(surName2)) {

				// Búsqueda por nombre completo.
				customersList = customerService.searchByFullName(name, surName1, surName2);
			}
		}

		return customersList;
	}

}
