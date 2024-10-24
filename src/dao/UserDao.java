package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entities.User;

public class UserDao implements Dao<User>{

	public boolean create(User obj) {
		String str = "INSERT INTO T_Users (idUser, Name, FirstName, password, email, adress, phoneNumber) VALUES ( ?,?,?,?,?,?,?);";
		try (PreparedStatement ps = connection.prepareStatement(str)){
				ps.setInt(1, obj.getIdUser());
				ps.setString(2, obj.getName());
				ps.setString(3, obj.getFirstName());
				ps.setString(4, obj.getpassword());
				ps.setString(5, obj.getemail());
				ps.setString(6, obj.getadress());
				ps.setInt(7, obj.getphoneNumber());
				if( ps.executeUpdate() == 1)	return true;				
		} catch (SQLException e) {
			logger.severe("problème sur la création d'un utilisateur");
		} 				
		return false;
	}

	public User read(int idUser) {
		try (Statement statement = connection.createStatement()){
				String str = "SELECT * FROM T_Users where IdUser=" + idUser + ";";									
				ResultSet rs = statement.executeQuery(str);
				if(rs.next()) 
					return new User(0 , str , str, str, str, str, idUser);
		} catch (SQLException e) {
			logger.severe("problème lors de la lecture d'un user " + e.getMessage());
		} 	
		return null;
	}
	
	public boolean update(User obj) {
		try (Statement statement = connection.createStatement()){
				String str = "UPDATE T_Users set Name='" + obj.getName() +"' , " +
							"FirstName='" 		+ obj.getFirstName() +"'" + " where idUser=" + obj.getIdUser() + ";";			
				if(statement.executeUpdate(str) == 1) return true;
		} catch (SQLException e) {
			logger.severe("problème lors de la mise à jour d'un utilisateur " + e.getMessage());
		} 	
		return false;
	}
	
	public boolean delete(User obj) {
		try (Statement statement = connection.createStatement()){
				String str = "DELETE FROM T_Users where IdUser=" + obj.getIdUser() + ";";									
				if(statement.executeUpdate(str) == 1) return true;		
		} catch (SQLException e) {
			logger.severe("problème lors de la suppression d'un utilisateur ");
		}
		return false;
	}

	public ArrayList<User> readAll() {
		ArrayList<User> users = new ArrayList<User>();
		String strSql = "SELECT * FROM T_Users";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsidUser = resultSet.getInt(1);	
					String rsName = resultSet.getString(2);
					String rsFirstName = resultSet.getString(3);
					String rspassword = resultSet.getString(4);
					String rsemail = resultSet.getString(5);
					String rsadress = resultSet.getString(6);
					int rsphoneNumber = resultSet.getInt(7);
					users.add((new User(rsidUser,rsName,rsFirstName,rspassword,rsemail,rsadress,rsphoneNumber)));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("problème sur le renvoi de la liste des utilisateurs");
		}			
		return users;
	}
	
	public User findUserByCredentials(String Name, String FirstName) {
		String str = "SELECT * FROM T_Users where Name=? and FirstName=?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, Name);									
			ps.setString(2, FirstName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) 
				return new User(0, rs.getString(1) , rs.getString(2), str, str, str, 0);
		} catch (SQLException e) {
			logger.severe("problème de renvoi d'un utilisateur à partir des credentials ");
		} 	
		return null;
	}
	
	public User findUserByName(String Name) {
		String str = "SELECT * FROM T_Users where Name=?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, Name);							
			try (ResultSet rs = ps.executeQuery()){
				if(rs.next()) 
					return new User(0, rs.getString(1) , str, str, str, str, 0);
				}
		} catch (SQLException e) {
			logger.severe("problème d'un utilisateur à partir de son login ");
		} 	
		return null;
	}

}
