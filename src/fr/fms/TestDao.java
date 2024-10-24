package fr.fms;

import java.util.Scanner;
import java.util.function.Predicate;

import dao.DaoFactory;
import dao.TrainingDao;
import dao.UserDao;
import entities.Training;
import entities.User;
import dao.Dao;

public class TestDao {
	public static void main(String[] args) {
	TrainingDao TrainingDao = new TrainingDao();
	System.out.println(TrainingDao.read(10));
	}
	
	private static void testUserTraining() {
		Scanner scan = new Scanner(System.in);
		UserDao UserDao = new UserDao();		
		System.out.println("saisissez votre identifiant :");
		String FirstName = scan.nextLine();
		System.out.println("saisissez votre password :");
		String password = scan.nextLine();	
		
		User User = UserDao.findUserByCredentials(FirstName, password);
		if(User != null) {
			for(Training training : new TrainingDao().readAll()) {
				System.out.println(training);
			}
		} else System.out.println("Mauvais prénom ou mot de passe recommence!");
			
		scan.close();
	}
	
	private static void testUserDao() {
		UserDao UserDao = new UserDao();
		
		for(User User : UserDao.readAll())
			System.out.println(User);
	}
	
	private static void testTrainingDao() {
		TrainingDao trainingDao = new TrainingDao();
		
		for(Training training : trainingDao.readAll()) {
			System.out.println(training);
		}	
		System.out.println();
		
		Training training = trainingDao.read(5);
		System.out.println(training);
		
		training.setDescription("Formation trop bien pour vous ^^");
		trainingDao.update(training);
		
		if(training != null)		
			trainingDao.delete(training);
		
		if(training != null)		
			trainingDao.create(training);
		
		System.out.println();

		for(Training tra : trainingDao.readAll()) {
			System.out.println(tra);
	}
}
		
		private static void testDaoFactory() {
			Dao<User> UserDao = DaoFactory.getUserDao();
				
			Predicate<Training> traPredicate = a -> a.getidUser() >= 5 && (a.getprice() > 50 && a.getprice() < 100); 
			DaoFactory.getTrainingDao().readAll()
						.stream()
						.filter(traPredicate)
						.forEach(System.out::println);
				
			System.out.println("---------------------------------------------");
			
			UserDao.readAll().forEach(User -> System.out.println(User));
	}
}
