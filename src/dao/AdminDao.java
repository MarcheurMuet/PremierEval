package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Admin;

public class AdminDao implements Dao<Admin> {
	public boolean create(Admin obj) {
		String str = "INSERT INTO T_Admin (IdAdmin, NickName, passwordA) VALUES (?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
				ps.setInt(1, obj.getIdAdmin());
				ps.setString(2, obj.getNickName());
				ps.setString(3, obj.getpasswordA());
				if( ps.executeUpdate() == 1)	return true;				
		} catch (SQLException e) {
			logger.severe("problème sur la création d'un admin");
		} 				
		return false;
	}
	
	public Admin read(int IdAdmin) {
		try (Statement statement = connection.createStatement()){
				String str = "SELECT * FROM T_Admin where IdAdmin=" + IdAdmin + ";";									
				ResultSet rs = statement.executeQuery(str);
				if(rs.next()) 
					return new Admin(IdAdmin, str, str);
		} catch (SQLException e) {
			logger.severe("problème lors de la lecture d'un user " + e.getMessage());
		} 	
		return null;
	}
	
	public boolean update(Admin obj) {
		try (Statement statement = connection.createStatement()){
				String str = "UPDATE T_Users set Name='" + obj.getNickName() +"' , " +
							"password='" 		+ obj.getpasswordA() +"'" + " where IdAdmin=" + obj.getIdAdmin() + ";";			
				if(statement.executeUpdate(str) == 1) return true;
		} catch (SQLException e) {
			logger.severe("problème lors de la mise à jour d'un Admin " + e.getMessage());
		} 	
		return false;
	}
	
	public boolean delete(Admin obj) {
		try (Statement statement = connection.createStatement()){
				String str = "DELETE FROM T_Admin where IdAdmin=" + obj.getIdAdmin() + ";";									
				if(statement.executeUpdate(str) == 1) return true;		
		} catch (SQLException e) {
			logger.severe("problème lors de la suppression d'un Admin ");
		}
		return false;
	}

	public ArrayList<Admin> readAll() {
		ArrayList<Admin> admin = new ArrayList<Admin>();
		String strSql = "SELECT * FROM T_Admin";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsIdAdmin = resultSet.getInt(1);	
					String rsNickName = resultSet.getString(2);
					String rspasswordA = resultSet.getString(3);
					admin.add((new Admin(rsIdAdmin,rsNickName,rspasswordA)));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("problème sur le renvoi de la liste des Admin");
		}			
		return admin;
	}
	
	public Admin findAdminByCredentials(String NickName, String passwordA) {
		String str = "SELECT * FROM T_Admin where NickName=? and passwordA=?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, NickName);									
			ps.setString(2, passwordA);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
				return new Admin(0, str, str);
		} catch (SQLException e) {
			logger.severe("problème de renvoi d'un ou de plusieurs Admins à partir des credentials ");
		} 	
		return null;
	}
	
	public Admin findAdminByNickName(String NickName) {
		String str = "SELECT * FROM T_Admin where NickName=?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, NickName);							
			try (ResultSet rs = ps.executeQuery()){
				if(rs.next()) 
					return new Admin(0, rs.getString(1), str);
				}
		} catch (SQLException e) {
			logger.severe("problème d'un Admin à partir de son pseudo ");
		} 	
		return null;
	}
}
