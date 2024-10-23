package fr.fms;
import java.util.Scanner;
import authentification.Authenticate;
import business.IBusinessImpl;
import entities.Training;
import entities.Format;
import entities.User;

public class FormaAPP {
	private static Scanner scan = new Scanner(System.in); 
	private static IBusinessImpl business = new IBusinessImpl();
	private static Authenticate authenticate = new Authenticate();
	
	public static final String TEXT_BLUE = "\u001B[36m";
	public static final String TEXT_RESET = "\u001B[0m";	
	private static final String COLUMN_ID = "IDENTIFIANT";
	private static final String COLUMN_DESCRIPTION = "DESCRIPTION";
	private static final String COLUMN_DURATIOND = "DURATIOND";
	private static final String COLUMN_PRICE = "PRIX";
	private static final String COLUMN_NAME = "NAME";
	private static final String COLUMN_FORMAT= "FORMAT";
	private static int IdUser = 0;
	private static String Name = null; 
	
	public static void main(String[] args) {
		System.out.println("Bonjour, voici la liste complète des formations en stock\n");
		displayTraining();
		int choice = 0;
		while(choice != 8) {
			displayMenu();
			choice = scanInt();
			switch(choice) {
				case 1 : addTraining();				
					break;					
				case 2 : removeTraining();
					break;					
				case 3 : displayBasket(true);
					break;					
				case 4 : displayTraining();
					break;						
				case 5 : displayFormat();
					break;
				case 6 : displayTrainingByFormatId();
					break;
				case 7 : connection(IdUser);
					break;
				case 8 : System.out.println("à bientôt :)");
					break;					
				default : System.out.println("veuillez saisir une valeur entre 1 et 8");
			}
		}
	}

	/**
	 * Méthode qui affiche le menu principale
	 */
	public static void displayMenu() {	
		if(Name != null)	System.out.print(TEXT_BLUE + "Compte : " + Name);
		System.out.println("\n" + "Pour réaliser une action, tapez le code correspondant");
		System.out.println("1 : Ajouter une formation au panier");
		System.out.println("2 : Retirer une formation du panier");
		System.out.println("3 : Afficher mon panier + total pour passer commande");
		System.out.println("4 : Afficher toutes les formation en stock");
		System.out.println("5 : Afficher tous les forma en base");
		System.out.println("6 : Afficher tous les formations avec un forma spécifique");
		System.out.println("7 : Connexion(Deconnexion) à votre compte");
		System.out.println("8 : sortir de l'application");
	}
	
	/**
	 * Méthode qui affiche tous les articles en base en centrant le texte 
	 */
	public static void displayTraining() { 				
		System.out.printf("-----------------------------------------------------------------------------------------%n");
		System.out.printf("%-25s | %-25s | %-25s | %-25s %n",COLUMN_ID,COLUMN_DESCRIPTION,COLUMN_DURATIOND,COLUMN_PRICE);
		System.out.printf("-----------------------------------------------------------------------------------------%n");
		business.readTraining().forEach( a -> System.out.printf("%-25s | %-25s | %-25s | %-25s%n",a.getId(),a.getdescription(),a.getdurationD(), Training.getprice()));
	}
	
	/**
	 * Méthode qui affiche tous les articles par catégorie en utilisant printf
	 */
	private static void displayTrainingByFormatId() {
		System.out.println("saisissez l'id de la catégorie ");
		int id = scanInt();
		Format format = business.readOneCategory(id);
		if(format != null) {
			System.out.printf("AFFICHAGE PAR CATEGORIE : %s   %n", format.getformat());
			System.out.printf("------------------------------------------------------------%n");
			System.out.printf("%-15s | %-15s | %-15s | %-15s %n",COLUMN_ID,COLUMN_DESCRIPTION,COLUMN_DURATIOND,COLUMN_PRICE);
			System.out.printf("------------------------------------------------------------%n");
			business.readTrainingByFormId(id).forEach( a -> System.out.printf("%-15s | %-15s | %-15s | %-15s%n",a.getId(),a.getdescription(),a.getdurationD(), Training.getprice()));
		}
		else System.out.println("cette catégorie n'existe pas !");
	}

	/**
	 * Méthode qui affiche toutes les catégories
	 */
	private static void displayFormat() {
		System.out.printf("---------------------------------------------------------------------------------------------------%n");
		System.out.printf("%-25s | %-25s | %-25s %n",COLUMN_ID,COLUMN_NAME,COLUMN_DESCRIPTION);
		System.out.printf("---------------------------------------------------------------------------------------------------%n");
		business.readFormat().forEach( c -> System.out.printf("%-25s | %-25s | %-25s %n",c.getformat(),c.getName(),c.getDescription()));		
	}
	
	/**
	 * Méthode qui supprime un article du panier
	 */
	public static void removeTraining() {
		System.out.println("Selectionner l'id de l'article à supprimer du panier");
		int id = scanInt();
		business.rmFromBasket(id);
		displayBasket(false);
	}

	/**
	 * Méthode qui ajoute un article au panier
	 */
	public static void addTraining() {
		System.out.println("Selectionner l'id de l'article à ajouter au panier");
		int id = scanInt();
		Training training = business.readOneTraining(id);
		if(training != null) {
			business.addToBasket(training);
			displayBasket(false);
		}
		else System.out.println("l'article que vous souhaitez ajouter n'existe pas, pb de saisi id");
	} 
	
	/**
	 * Méthode qui affiche le contenu du panier + total de la commande + propose de passer commande
	 */
	private static void displayBasket(boolean flag) {
		if(business.isBasketEmpty()) 	System.out.println("PANIER VIDE");
		else {
			System.out.println("CONTENU DU PANIER :");
			System.out.printf("------------------------------------------------------------------------------------------------------------------------%n");
			System.out.printf("%-25s | %-25s | %-25s | %-25s | %-25s %n",COLUMN_ID,COLUMN_DESCRIPTION,COLUMN_DURATIOND,COLUMN_PRICE,COLUMN_FORMAT);
			System.out.printf("------------------------------------------------------------------------------------------------------------------------%n");
			business.getCart().forEach( a -> System.out.printf("%-25s | %-25s | %-25s | %-25s | %-25s%n",a.getId(),a.getdescription(),a.getdurationD(), Training.getprice(), a.getformat()));
			if(flag) {
				System.out.println("MONTANT TOTAL : " + business.getTotal());
				System.out.println("Souhaitez vous passer commande ? Oui/Non :");
				if(scan.next().equalsIgnoreCase("Oui")) {
					nextStep();
				}
			}
		}
	}
	
	/**
	 * Méthode qui passe la commande, l'utilisateur doit être connecté
	 * si c'est le cas, l'utilisateur sera invité à associé un client à sa commande
	 * si le client n'existe pas, il devra le créer
	 * puis une commande associée au client sera ajoutée en base
	 * De même, des commandes minifiées seront associées à la commande
	 * une fois toutes les opérations terminées correctement, le panier sera vidé et un numéro de commande attribué
	 */
	private static void nextStep() {
		if(Name == null)	{ 
			System.out.println("Vous devez être connecté pour continuer");
			connection(IdUser);
		}
		if(Name != null) {
			int IdCustomer = newUser(IdUser);	
			if(IdCustomer != 0) {
				int idBasket = business.order(IdCustomer);	
				if(idBasket == 0)	System.out.println("pb lors du passage de commande");
				else {
					System.out.println("Votre commande a bien été validé, voici son numéro : " + idBasket);
					business.clearCart();
				}
			}
		}
	}

	/**
	 * Méthode qui ajoute un client en base s'il n'existe pas déjà 
	 * @return id du client afin de l'associer à la commande en cours
	 */
	private static int newUser(int idUser) {
		System.out.println("Avez vous déjà un compte client ? Saisissez une adresse email valide :");
		String email = scan.next();		
		if(isValidEmail(email)) {	
			User user = authenticate.existUserByEmail(email);
			if(user == null) {
				System.out.println("Nous n'avons pas de compte client associé, nous allons le créer ");
				scan.nextLine();	
				System.out.println("saisissez votre nom :");
				String name = scan.nextLine();
				System.out.println("saisissez votre prénom :");
				String fName = scan.next();					
				System.out.println("saisissez votre tel :");
				String tel = scan.next();		
				scan.nextLine(); 
				System.out.println("saisissez votre adresse :");
				String address = scan.nextLine();
				System.out.println("saisissez votre mot de pass :");
				String password = scan.nextLine();
				new User(idUser, name, fName, email, tel, address, password); 
				if(authenticate.addUser(user))	
					return authenticate.existUserByEmail(email).getIdUser();
			}
			else {
				System.out.println("Nous allons associer la commande en cours avec le compte client : " + user);
				return user.getIdUser();
			}
		}
		else System.out.println("vous n'avez pas saisi un email valide");	
		return 0;
	}

	/**
	 * Méthode qui réalise la connexion/deconnexion d'un utilisateur
	 * si l'utilisateur n'existe pas, il lui est proposé d'en créer un
	 * @param IdUser 
	 */
	private static void connection(int IdUser) {
		if(Name != null) {
			System.out.println("Souhaitez vous vous déconnecter ? Oui/Non");
			String response = scan.next();
			if(response.equalsIgnoreCase("Oui")) {
				System.out.println("A bientôt " + Name + TEXT_RESET);
				Name = null;
				IdUser = 0;
			}				
		}
		else {
			System.out.println("saisissez votre login : ");
			String name = scan.next();
			System.out.println("saisissez votre password : ");
			String password = scan.next();
			
			int id = authenticate.existUser(name,password);
			if(id > 0)	{
				Name = name;
				IdUser = id;
				System.out.print(TEXT_BLUE);
			}
			else {
				System.out.println("login ou password incorrect");
				System.out.println("Nouvel utilisateur, pour créer un compte, tapez ok");
				String ok = scan.next();
				if(ok.equalsIgnoreCase("ok")) {
					newUser();
				}
			}
		}
	}
	
	/**
	 * Méthode qui ajoute un nouvel utilisateur en base
	 */
	public static void newUser() {
		System.out.println("saisissez un login :");
		String Name = scan.next();			
		int id = authenticate.existUser(Name);	
		if(id == 0) { 
			System.out.println("saisissez votre password :");
			String password = scan.next();
			authenticate.addUser(Name, password);		
			System.out.println("Ne perdez pas ces infos de connexion...");
			stop(2);
			System.out.println("création de l'utilisateur terminé, merci de vous connecter");
		}
		else	System.out.println("Login déjà existant en base, veuillez vous connecter");
	}
	
	public static void stop(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static int scanInt() {
		while(!scan.hasNextInt()) {
			System.out.println("saisissez une valeur entière svp");
			scan.next();
		}
		return scan.nextInt();
	}
	
	public static boolean isValidEmail(String email) {
		String regExp = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z][a-z]+$";	
		return email.matches(regExp);
	}
}