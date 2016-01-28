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
import io.restaurant.dao.ReservationDAO;
import io.restaurant.model.Reservation;

@Path("/reservations")
public class ReservationController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> findAll(){
		List<Reservation> reservations= null;
		try{
			ReservationDAO dao = new ReservationDAO();
			reservations = dao.findAll();
		}catch(AppException e){
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return reservations;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reservation findOne(@PathParam ("id") String id){
		Reservation reservation = new Reservation();
		try {
			ReservationDAO dao = new ReservationDAO();
			reservation = dao.findOne(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return reservation;
	}

	@POST
	public Reservation create(){
		Reservation reservation = new Reservation();
		return reservation;
	}

	/*@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Reservation update(@PathParam ("id") String id, Reservation res){
		try {
			ReservationDAO dao = new ReservationDAO();
			res = dao.update(id,res);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		
		return res;
	}*/
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String update(@PathParam ("id") String id){
		String rid="";
		try {
			ReservationDAO dao = new ReservationDAO();
			rid = dao.cancelR(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
		return rid;
	}
	
}

