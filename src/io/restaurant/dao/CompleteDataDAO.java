package io.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.restaurant.exception.AppException;
import io.restaurant.model.CompleteData;
import io.restaurant.util.DBUtil;

public class CompleteDataDAO {

	public CompleteData create(CompleteData completeData)throws AppException {
		Connection con = DBUtil.connect();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		PreparedStatement ps4 =null;
		ResultSet rs4 = null;
		
		try {
			ps1 = con.prepareStatement("SELECT * FROM fonduefun_reservation_system.customers WHERE EMAIL=?");
			ps1.setString(1,completeData.getEmail());
			
			rs1 = ps1.executeQuery();
			
			
			if(rs1.next()){
				completeData.setCID(rs1.getInt("CID"));
			}else{
				ps = con.prepareStatement("INSERT INTO fonduefun_reservation_system.customers "
						+ "(FIRST_NAME, LAST_NAME, EMAIL, ADDRESS1, ADDRESS2, CITY, ZIP, STATE, PHONE) "
						+ "VALUES (?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				//ps.setInt(1,completeData.getId());
				ps.setString(1,completeData.getFirstname());
				ps.setString(2,completeData.getLastname());
				ps.setString(3,completeData.getEmail());
				ps.setString(4,completeData.getAddress1());
				ps.setString(5,completeData.getAddress2());
				ps.setString(6,completeData.getCity());
				ps.setInt(7,completeData.getZip());
				ps.setString(8,completeData.getState());
				ps.setString(9,completeData.getPhone());
				
				ps.executeUpdate();
				
				rs=ps.getGeneratedKeys();
				
				if(rs.next())
					completeData.setCID(rs.getInt(1));
			}
			
			ps2 = con.prepareStatement("INSERT INTO fonduefun_reservation_system.reservations (Reservation_ID, "
					+ "Reservation_Date, Reservation_Time, Reservation_Size, Table_Type, Reservation_Status, "
					+ "CID)"
					+ "VALUES (concat('FF',FLOOR( 1000 + ( RAND( ) *8999 ))),?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			
			ps2.setString(1,completeData.getReservation_Date());
			ps2.setString(2,completeData.getReservation_Time());
			ps2.setInt(3,completeData.getReservation_Size());
			ps2.setString(4,completeData.getTable_Type());
			ps2.setString(5, completeData.getReservation_Status());
			ps2.setInt(6,completeData.getCID());
			
			ps2.executeUpdate();
			
			//rs2 = ps2.getGeneratedKeys();
			
			//if(rs2.next())
				//System.out.println(rs2.getInt(1));
			
			ps4 = con.prepareStatement("SELECT * FROM fonduefun_reservation_system.reservations ORDER BY "
					+ "Reservation_Creation_Date DESC LIMIT 1");
			
			rs4 = ps4.executeQuery();
			
			if(rs4.next()){
				completeData.setReservation_ID(rs4.getString("Reservation_ID"));
			}
			//completeData.setReservation_ID(rs2.getString(1));
			//setId(rs.getInt(1));
			
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
					ps1.close();
				}
				if(ps2 != null){
					ps2.close();
				}
				if(ps4 != null){
					ps4.close();
				}
				if(rs4 != null){
					rs4.close();
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return completeData;
	}

}
