package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entities.Training;

public class TrainingDao implements Dao<Training>{


	    private final Connection connection;

	    public TrainingDao(Connection connection) {
	        this.connection = connection;
	    }
	
	public boolean create(Training obj) {
		String str = "INSERT INTO T_Training (idTraining, nameT, description, durationD, format, price) VALUES (?,?,?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, obj.getidTraining());
			ps.setString(2, obj.getNameT());
			ps.setString(3, obj.getdescription());	
			ps.setInt(4, obj.getdurationD());
			ps.setString(5, obj.getformat());
			ps.setDouble(6, Training.getprice());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("problème lors de la création d'une formation " + e.getMessage());
		} 	
		return false;
	}

	public Training read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Training where idTraining=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Training(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getInt(4) , rs.getString(5) , rs.getInt(6));
		} catch (SQLException e) {
			logger.severe("problème de lecture d'une formation " + e.getMessage());
		} 	
		return null;
	}


	public boolean delete(Training obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Training where idTraining=" + obj.getidTraining() + ";";									
			statement.executeUpdate(str);		
			return true;
		} catch (SQLException e) {
			logger.severe("problème lors de la suppression d'une formation " + e.getMessage());
		} 	
		return false;
	}

	public boolean update(Training obj) {
		String str = "UPDATE T_Training set NameT=? , description=? , durationD=?,  format=?, price=? where idTraining=?;";
		try (PreparedStatement ps = connection.prepareStatement(str)){				
			ps.setString(1, obj.getNameT());
			ps.setString(2, obj.getdescription());	
			ps.setInt(3, obj.getdurationD());
			ps.setString(4, obj.getformat());
			ps.setDouble(5, Training.getprice());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("problème lors de la mise à jour d'une formation " + e.getMessage());
		} 	
		return false;
	}
	
	public ArrayList<Training> readAll() {
		ArrayList<Training> training = new ArrayList<Training>();
		String strSql = "SELECT * FROM T_Training";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsidTraining = resultSet.getInt(1);	
					String rsNameT = resultSet.getString(2);
					String rsdescription = resultSet.getString(3);
					int rsdurationD = resultSet.getInt(4);
					String rsformat = resultSet.getString(5);
					double rsprice = resultSet.getDouble(6);		
					training.add((new Training(rsidTraining,rsNameT,rsdescription,rsdurationD,rsformat,rsprice)));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("problème de renvoi de toute les formations " + e.getMessage());
		}	
		return training;
	}
	
	/**Méthode qui renvoi toutes les formations d'un utilisateur*/
	public ArrayList<Training> readAllByCat(int idUser) {
		ArrayList<Training> training = new ArrayList<Training>();
		String strSql = "SELECT * FROM T_Training where idUser=" + idUser;		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsidTraining = resultSet.getInt(1);	
					String rsNameT = resultSet.getString(2);
					String rsdescription = resultSet.getString(3);
					int rsdurationD = resultSet.getInt(4);
					String rsformat = resultSet.getString(5);
					double rsprice = resultSet.getDouble(6);
					training.add(new Training(rsidTraining, rsNameT, rsdescription, rsdurationD, rsformat, rsprice));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("problème sur le renvoi des formation d'une catégorie " + e.getMessage());
		}			
		return training;
	}

}