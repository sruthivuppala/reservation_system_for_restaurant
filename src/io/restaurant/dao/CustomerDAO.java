package io.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import io.restaurant.exception.AppException;
import io.restaurant.model.Customer;
import io.restaurant.util.DBUtil;

public class CustomerDAO {
	
	public List<Customer> findAll() throws AppException{
		List<Customer> customers = new ArrayList<Customer>();
		Connection con = DBUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * from fonduefun_reservation_system.customers");
			rs = ps.executeQuery();
			
			while(rs.next()){
				Customer customer = new Customer();
				
				customer.setId(rs.getInt("CID"));
				customer.setFirstname(rs.getString("FIRST_NAME"));
				customer.setLastname(rs.getString("LAST_NAME"));
				customer.setEmail(rs.getString("EMAIL"));
				customer.setAddress1(rs.getString("ADDRESS1"));
				customer.setAddress2(rs.getString("ADDRESS2"));
				customer.setCity(rs.getString("CITY"));
				customer.setZip(rs.getInt("ZIP"));
				customer.setState(rs.getString("STATE"));
				customer.setPhone(rs.getString("PHONE"));
				
				customers.add(customer);
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
		return customers;
	}

	public Customer findOne(int id) throws AppException {
		Customer customer = null;
		Connection con = DBUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM fonduefun_reservation_system.customers WHERE CID=?");
			ps.setInt(1,id);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				customer = new Customer();
				customer.setId(rs.getInt("CID"));
				customer.setFirstname(rs.getString("FIRST_NAME"));
				customer.setLastname(rs.getString("LAST_NAME"));
				customer.setEmail(rs.getString("EMAIL"));
				customer.setAddress1(rs.getString("ADDRESS1"));
				customer.setAddress2(rs.getString("ADDRESS2"));
				customer.setCity(rs.getString("CITY"));
				customer.setZip(rs.getInt("ZIP"));
				customer.setState(rs.getString("STATE"));
				customer.setPhone(rs.getString("PHONE"));
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
				if(con != null){
					con.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return customer;
	}

	public Customer create(Customer customer) throws AppException {
		Connection con = DBUtil.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("INSERT INTO fonduefun_reservation_system.customers  "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,customer.getId());
			ps.setString(2,customer.getFirstname());
			ps.setString(3,customer.getLastname());
			ps.setString(4,customer.getEmail());
			ps.setString(5,customer.getAddress1());
			ps.setString(6, customer.getAddress2());
			ps.setString(7,customer.getCity());
			ps.setInt(8, customer.getZip());
			ps.setString(9, customer.getPhone());
			ps.setString(10,customer.getState());
			
			ps.executeUpdate();
			
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
		return customer;
	}

	public Customer update(int id, Customer customer) throws AppException {
		Connection con = DBUtil.connect();
		PreparedStatement ps1 = null;
		PreparedStatement ps = null;
		ResultSet rs1 = null;	
		ResultSet rs = null;
		
		try {
			
			ps1 = con.prepareStatement("SELECT * FROM fonduefun_reservation_system.customers WHERE CID=?");
			ps1.setInt(1,id);
			rs1 = ps1.executeQuery();
			
			if(rs1.next()){
				ps = con.prepareStatement("UPDATE fonduefun_reservation_system.customers "
						+ "SET FIRST_NAME=?, LAST_NAME=?, EMAIL=?, ADDRESS1=?, ADDRESS2=?, "
						+ "CITY=?, ZIP=?, PHONE=?, STATE=? WHERE CID=?;");
				ps.setString(1,customer.getFirstname());
				ps.setString(2,customer.getLastname());
				ps.setString(3,customer.getEmail());
				ps.setString(4,customer.getAddress1());
				ps.setString(5, customer.getAddress2());
				ps.setString(6,customer.getCity());
				ps.setInt(7, customer.getZip());
				ps.setString(8, customer.getPhone());
				ps.setString(9,customer.getState());
				ps.setInt(10,id);
				
				ps.executeUpdate();
				
				customer.setId(id);
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
				if(con != null){
					con.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return customer;
	}

	/*public Customer delete(int id) throws AppException {
		Customer customer = null;
		Connection con = DBUtil.connect();
		PreparedStatement ps1 =null;
		PreparedStatement ps = null;
		PreparedStatement ps2 =null;
		ResultSet rs1 =null;
		ResultSet rs = null;
		
		try {
			
			ps1 = con.prepareStatement("SELECT Reservation_ID FROM "
					+ "fonduefun_reservation_system.reservations WHERE CID = ?");
			ps1.setInt(1, id);
			rs1 = ps1.executeQuery();
			
			if(rs1.next()){
				System.out.println("Cannot delete this customer as there is one reservation for this customer.");
				return customer;
			}
			else{
				ps = con.prepareStatement("SELECT * FROM customers WHERE CID=?");
				ps.setInt(1,id);

				rs = ps.executeQuery();

				if(rs.next()){
					customer = new Customer();
					customer.setId(rs.getInt("CID"));
					customer.setFirstname(rs.getString("FIRST_NAME"));
					customer.setLastname(rs.getString("LAST_NAME"));
					customer.setEmail(rs.getString("EMAIL"));
					customer.setAddress1(rs.getString("ADDRESS1"));
					customer.setAddress2(rs.getString("ADDRESS2"));
					customer.setCity(rs.getString("CITY"));
					customer.setZip(rs.getInt("ZIP"));
					customer.setState(rs.getString("STATE"));
					customer.setPhone(rs.getString("PHONE"));
				}
				else{
					throw new NotFoundException("Customer with this ID is not found");
				}
			}
			
			ps.close();
			rs.close();
			
			ps2 = con.prepareStatement("DELETE FROM customers WHERE CID=?");
			ps2.setInt(1,id);
			ps2.executeUpdate();
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
				if(ps1 != null){
					ps.close();
				}
				if(rs1 != null){
					rs.close();
				}
				if(ps2 != null){
					rs.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return customer;
	}*/
}
