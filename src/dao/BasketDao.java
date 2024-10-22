package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Basket;

public class BasketDao implements Dao<Basket> {

	public boolean create(Basket obj) {
		String str = "INSERT INTO T_Users (id , FormaList, idUser) VALUES (?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str,Statement.RETURN_GENERATED_KEYS)){	
			ps.setDouble(1, obj.id());
			ps.setString(2, obj.getFormaList());
			ps.setInt(3, obj.idUser());
			ps.executeUpdate();
			try(ResultSet generatedKeySet = ps.getGeneratedKeys()){
				if(generatedKeySet.next()) {
					obj.setid(generatedKeySet.getInt(1));
					return true;
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Basket read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Basket obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Basket obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Basket> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
