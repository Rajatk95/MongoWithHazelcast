package com.architecture.prod.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.architecture.prod.model.Customer;
import com.architecture.prod.service.CustomerService;

/**
 * Rest Endpoints are exposed here to add, remove, get customer information
 */
@Path("/customer")
public class CustomerController {

	private final CustomerService customerService;

	/**
	 * Use to test is Web Service is working.
	 */
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "its working.....";
	}

	@Inject
	public CustomerController(final CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * Get customer data on the basis of customer id, if the data is not present in
	 * cache, data is fetched from database.
	 * 
	 * @param customerId
	 * @return Customer
	 */
	@GET
	@Path("/{customerId}")
	@Produces(APPLICATION_JSON)
	public Customer getCustomer(@PathParam("customerId") final String customerId) {
		return this.customerService.getCustomerById(customerId);
	}

	/**
	 * Add Customer, The Customer and its data is inserted in the cache and the
	 * database
	 * 
	 * @param customer
	 */
	@POST
	@Produces(APPLICATION_JSON)
	public void addCustomer(final Customer customer) {
		customerService.addCustomer(customer);
	}

	/**
	 * Update Customer Data, Data for the customer is updated in the cache as well
	 * as database.
	 * 
	 * @param Customer
	 * @return Customer
	 */
	@PUT
	@Produces(APPLICATION_JSON)
	public Customer updateCustomer(final Customer customer) {
		return customerService.updateCustomer(customer);
	}

	/**
	 * Delete Customer
	 * @param customerId
	 */
	@DELETE
	@Path("/{customerId}")
	@Produces(APPLICATION_JSON)
	public void deleteCustomer(@PathParam("customerId") final String customerId) {
		customerService.deleteCustomer(customerId);
	}

	@GET
	@Path("/code/{customerCode}")
	@Produces(APPLICATION_JSON)
	public Customer getCustomerByCode(@PathParam("customerCode") final String customerCode) throws Exception {
		return this.customerService.getCustomerByCode(customerCode);
	}

	@GET
	@Path("/phoneNumber/{phoneNumber}")
	@Produces(APPLICATION_JSON)
	public List<Customer> getCustomerByPhoneNumber(@PathParam("phoneNumber") final int phoneNumber) throws Exception {
		return this.customerService.getCustomerByPhoneNumber(phoneNumber);
	}

	@GET
	@Path("/address/{customerCode}")
	@Produces(APPLICATION_JSON)
	public String getCustomerAddress(@PathParam("customerCode") final String customerCode) throws Exception {
		return this.customerService.getCustomerAddressByCode(customerCode);
	}
}
