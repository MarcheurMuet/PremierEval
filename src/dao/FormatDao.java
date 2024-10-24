package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entities.Format;

public class FormatDao implements Dao<Format> {

	@Override
	public boolean create(Format obj) {
		String str = "INSERT INTO T_Format (IdFormat, format) VALUES (?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setInt(1, obj.getIdFormat());
			ps.setString(2, obj.getformat());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			logger.severe("problème lors de la création d'un forma" + e.getMessage());
		} 	
		return false;
	}

	@Override
	public Format read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Format obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Format obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Format> readAll() {
		ArrayList<Format> format = new ArrayList<Format>();
		String strSQL = "SELECT * FROM T_Format";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSQL)){ 			
				while(resultSet.next()) {
					int rsIdFormat = resultSet.getInt(1);	
					String rsformat = resultSet.getString(2);
					format.add((new Format(rsIdFormat,rsformat)));						
				}	
			}
		} catch (SQLException e) {
			logger.severe("problème de renvoi de toute les formations " + e.getMessage());
		}	
		return format;
	}

}
