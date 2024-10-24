package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.BasketItem;

public class BasketItemsDao implements Dao<BasketItem> {

	@Override
	public boolean create(BasketItem obj) {
		String str = "INSERT INTO T_Order_Items (IdTraining, Quantity, UnitaryPrice, IdBasket) VALUES (?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){	
			ps.setInt(1, (int) obj.getIdTraining());
			ps.setInt(2, obj.getQuantity());
			ps.setDouble(3, obj.getUnitaryPrice());
			ps.setInt(4, obj.getIdBasket());
			
			ps.executeUpdate();			
			return true;
		} catch (SQLException e) {
			logger.severe("problème lors de la création d'un orderItem : " + e.getMessage());
		}
		return false;
	}

	@Override
	public BasketItem read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(BasketItem obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(BasketItem obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<BasketItem> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}