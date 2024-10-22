package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Training;
import entities.User;
import fr.fms.entities.Article;

public class TrainingDao implements Dao<Training>{

	public boolean create(Training obj) {
		String str = "INSERT INTO T_Training (idTraining, nameT, description, durationD, format, price) VALUES (?,?,?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, obj.getidTraining());
			ps.setString(2, obj.getNameT());
			ps.setString(3, obj.getdescription());	
			ps.setInt(4, obj.getdurationD());
			ps.setString(5, obj.getformat());
			ps.setInt(6, obj.getprice());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("problème lors de la création d'un article " + e.getMessage());
		} 	
		return false;
	}

	public Training read(int id) {
		try (Statement statement = connection.createStatement()){
			String str = "SELECT * FROM T_Training where idTraining=" + id + ";";									
			ResultSet rs = statement.executeQuery(str);
			if(rs.next()) return new Training(rs.getInt(1) , rs.getString(2) , rs.getString(3) , rs.getInt(4) , rs.getString(5) , rs.getInt(6));
		} catch (SQLException e) {
			logger.severe("problème de lecture d'un article " + e.getMessage());
		} 	
		return null;
	}


	public boolean delete(Training obj) {
		try (Statement statement = connection.createStatement()){
			String str = "DELETE FROM T_Training where idTraining=" + obj.getidTraining() + ";";									
			statement.executeUpdate(str);		
			return true;
		} catch (SQLException e) {
			logger.severe("problème lors de la suppression d'un article " + e.getMessage());
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
			ps.setInt(5, obj.getprice());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("problème lors de la mise à jour d'un article " + e.getMessage());
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
			logger.severe("pb sql sur revoi de tous articles " + e.getMessage());
		}	
		return articles;
	}
	
	/**Méthode qui renvoi tous les articles d'une catégorie*/
	public ArrayList<Article> readAllByCat(int id) {
		ArrayList<Article> articles = new ArrayList<Article>();
		String strSql = "SELECT * FROM T_Articles where idCategory=" + id;		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);		
					articles.add((new Article(rsId,rsDescription,rsBrand,rsPrice)));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("pb sql sur renvoir des articles d'une catégorie " + e.getMessage());
		}			
		return articles;
	}

}