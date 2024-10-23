package business;
import java.util.ArrayList;
import entities.Training;
import entities.Format;

public interface IBusiness {	
	
	public void addToCart(Training training);		
	
	public void rmFromCart(int IdTraining);		
	
	public ArrayList<Training> getCart();	

	public int order(int IdUser);		
	
	public ArrayList<Training> readTrainings();	

	public Training readOneTraining(int IdTraining);	

	public ArrayList<Format> readFormat();
	
	public ArrayList<Training> readTrainingsByFormat(String IdFormat);

	ArrayList<Training> readTrainingByFormId(int IdFormat);

	ArrayList<Training> readTraining();

	ArrayList<Training> getFormat();
}