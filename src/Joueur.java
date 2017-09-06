
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Joueur{
	static boolean initialisation = false;
	static ArrayList<String> liste = new ArrayList<>();
	
	public static void ecritureJoueur() throws FileNotFoundException{
		String pseudo = "";
		String score = "";
		System.out.println("entrez votre pseudo :\n");
		Scanner sc = new Scanner(System.in);
		pseudo = sc.nextLine();
		System.out.println("score : \n");
		score = sc.nextLine();
		
		PrintStream l_out = new PrintStream(new FileOutputStream("src/classement/ClassementJoueurs.csv", true));
		l_out.print(pseudo+","); 
		l_out.print(score+"\n"); 
		l_out.flush(); 
		l_out.close(); 
		l_out=null;
	}
	public static void main(String[] arguments) {
		FileReader monFichier = null;
		BufferedReader tampon = null;
		
		try {
			monFichier = new FileReader("src/classement/ClassementJoueurs.csv");
			tampon = new BufferedReader(monFichier);
			
			while (true) {
				// Lit une ligne de test.csv
				String ligne = tampon.readLine();
				liste.add(ligne);
				// Vérifie la fin de fichier
				if (ligne == null){
					break;
					}
				System.out.println(ligne);
				} // Fin du while
				//ecritureJoueur();
				for(String affichage : liste){
					System.out.println(affichage);
					int meilleur = 0;
					
				}
				
			} catch (IOException exception) {
				exception.printStackTrace();
				} finally {
				try {
				tampon.close();
				monFichier.close();
				} catch(IOException exception1) {
				exception1.printStackTrace();
			}
		}
	}
}