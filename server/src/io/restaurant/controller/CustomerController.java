package io.restaurant.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import io.restaurant.exception.AppException;
import io.restaurant.dao.CustomerDAO;
import io.restaurant.model.Customer;

@Path("/customers")
public class CustomerController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> findAll(){
		List<Customer> customers = null;

		try{
			CustomerDAO dao = new CustomerDAO();
			customers = dao.findAll();
		}catch(AppException e){
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return customers;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer findOne(@PathParam ("id") int id){
		Customer customer = null;
		try {
			CustomerDAO dao = new CustomerDAO();
			customer = dao.findOne(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return customer;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Customer create(Customer customer){
		try {
			CustomerDAO dao = new CustomerDAO();
			customer = dao.create(customer);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return customer;
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Customer update(@PathParam ("id") int id, Customer customer){
		try {
			CustomerDAO dao = new CustomerDAO();
			customer = dao.update(id,customer);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return customer;
	}

	/*@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer delete(@PathParam ("id") int id){
		Customer customer = null;
		try {
			CustomerDAO dao = new CustomerDAO();
			customer = dao.delete(id);
			if(customer == null)
				System.out.println("Cannot delete this customer as there is one reservation for this customer.");
			else
				System.out.println("Success.");
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return customer;
	}*/
}
