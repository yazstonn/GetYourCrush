
public class Main {
	public static void main(String[] args) {
		Tableau.afficheTableau();
		//System.out.println("nb possibilitées: "+ Possibilitees(Tableau.bonbons));
		System.out.println("Destruction verticale: " + new bonbonSpecifique(true,5));
		System.out.println("Destruction horizontale : " + new bonbonSpecifique(false,6));
	}
	public static int Possibilitees(Bonbons[][] bbs){
		return 42;
	}
	public static boolean blocage(Bonbons[][] bbs){
		return false;
	}
}
