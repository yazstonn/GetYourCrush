import java.util.Random;

public class Tableau {
	protected static Bonbons[][] bonbons = new Bonbons[6][6];
	protected static String uneligne="+-----";
	protected static String unecolonne="";
	
	public static void remplissageBonbons(){
		Random rnd = new Random();
		BonbonStandard bb = new BonbonStandard();
		for(int i=0;i<6;i++){
			for (int j = 0; j < 6; j++) {
				bonbons[i][j]=bb.getBb(rnd.nextInt(4)+1);
			}
		}
	}
	public static void changerBonbon(int ordonnee, int abscisse, Bonbons valeur){
		bonbons[ordonnee][abscisse]=valeur;
	}
	public static void afficheTableau(){
		Random rnd = new Random();
		BonbonStandard bb = new BonbonStandard();
		int k=0;
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 6; j++) {
				if(i%2==0){
					if(j==5){
						System.out.print("+-----+");
					}else{
						System.out.print(uneligne);
					}
				}else{
					if(j==5){
						System.out.print("|  "+bonbons[i/2][j]+"  |");
					}else{
						unecolonne="|  "+bonbons[i/2][j]+"  ";
						System.out.print(unecolonne);
					}
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		remplissageBonbons();
		afficheTableau();
	}
}
