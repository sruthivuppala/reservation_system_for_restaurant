package io.restaurant.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import io.restaurant.dao.CompleteDataDAO;
import io.restaurant.exception.AppException;
import io.restaurant.model.CompleteData;

@Path("/datainsert")
public class DataController {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CompleteData insertData(CompleteData completeData){
		try {
			CompleteDataDAO dao = new CompleteDataDAO();
			completeData = dao.create(completeData);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return completeData;
	}
}
