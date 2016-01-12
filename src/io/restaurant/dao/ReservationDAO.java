package io.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import io.restaurant.exception.AppException;
import io.restaurant.model.Reservation;
import io.restaurant.util.DBUtil;

public class ReservationDAO {

	public List<Reservation> findAll()throws AppException{

		List<Reservation> reservations = new ArrayList<Reservation>();
		Connection con = DBUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = con.prepareStatement("SELECT * from fonduefun_reservation_system.reservations");
			rs = ps.executeQuery();

			while(rs.next()){
				Reservation reservation = new Reservation();

				reservation.setReservation_ID(rs.getString("Reservation_ID"));
				reservation.setReservation_Date(rs.getString("Reservation_Date"));
				reservation.setReservation_Time(rs.getString("Reservation_Time"));
				reservation.setReservation_Size(rs.getInt("Reservation_Size"));
				reservation.setTable_Type(rs.getString("Table_Type"));
				reservation.setReservation_Status(rs.getString("Reservation_Status"));
				reservation.setCID(rs.getInt("CID"));

				reservations.add(reservation);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		finally{
			try{
				if(ps != null){
					ps.close();
				}
				if(rs != null){
					rs.close();
				}
				if(con != null){
					con.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return reservations;
	}

	public Reservation findOne(String id) throws AppException{
		Reservation reservation = null;
		Connection con = DBUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM fonduefun_reservation_system.reservations WHERE "
					+ "Reservation_ID=?");
			ps.setString(1,id);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				reservation = new Reservation();
				reservation.setReservation_ID(rs.getString("Reservation_ID"));
				reservation.setReservation_Date(rs.getString("Reservation_Date"));
				reservation.setReservation_Time(rs.getString("Reservation_Time"));
				reservation.setReservation_Size(rs.getInt("Reservation_Size"));
				reservation.setTable_Type(rs.getString("Table_Type"));
				reservation.setReservation_Status(rs.getString("Reservation_Status"));
				reservation.setCID(rs.getInt("CID"));

			}
			else{
				throw new NotFoundException("Reservation not found");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		finally{
			try{
				if(ps != null){
					ps.close();
				}
				if(rs != null){
					rs.close();
				}
				if(con != null){
					con.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return reservation;
	}

	public Reservation update(String id, Reservation res) throws AppException{
		Connection con = DBUtil.connect();
		PreparedStatement ps1 = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;	
		ResultSet rs = null;
		
		try {
			
			ps1 = con.prepareStatement("SELECT CID FROM fonduefun_reservation_system.reservations "
					+ "WHERE Reservation_ID=?");
			ps1.setString(1,id);
			
			rs1 = ps1.executeQuery();
			
			if(rs1.next()){
				ps = con.prepareStatement("UPDATE fonduefun_reservation_system.reservations SET Reservation_Date=?, Reservation_Time=?, "
						+ "Reservation_Size=?, Table_Type=?, Reservation_Status=?,CID=?, "
					+ "Reservation_Modification_Date= current_timestamp WHERE Reservation_ID=?");
				
				ps.setString(1,res.getReservation_Date());
				ps.setString(2,res.getReservation_Time());
				ps.setInt(3,res.getReservation_Size());
				ps.setString(4,res.getTable_Type());
				ps.setString(5, res.getReservation_Status());
				ps.setInt(6,rs1.getInt("CID"));
				ps.setString(7, id);
				
				ps.executeUpdate();
				res.setReservation_ID(id);
				res.setCID(rs1.getInt("CID"));
			}
			else{
				throw new NotFoundException("Customer with this ID is not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}
		finally{
			try{
				if(ps != null){
					ps.close();
				}
				if(rs != null){
					rs.close();
				}
				if(ps1 != null){
					ps1.close();
				}
				if(rs1 != null){
					rs1.close();
				}
				if(con != null){
					con.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return res;
	}
	
	
}
