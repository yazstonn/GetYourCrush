import java.util.ArrayList;
import java.util.Random;

public class Tableau {
	protected int n=8;
	private Bonbons[][] bonbons = new Bonbons[n][n];
	protected String uneligne = "+-----";
	protected String unecolonne = "";

	//localisationVide sous forme Ligne/Colonne
		protected static ArrayList<Integer> localisationVide = new ArrayList<Integer>();
	public Tableau() {
		remplissageBonbons();
	}

	public Bonbons[][] getTab() {
		return bonbons;
	}
	public void detectionVide(){
		for(int ligne=0; ligne<bonbons.length; ligne++){
			for(int colonne=0; colonne<bonbons[1].length; colonne++){
				if(bonbons[ligne][colonne].id == 0){
					localisationVide.add(ligne);
					localisationVide.add(colonne);
				}
			}
		}
		pluie();
	}
	public void pluie(){
		System.out.println(localisationVide.get(1));
		while(!localisationVide.isEmpty()){
			for(int i=localisationVide.get(0); i>=0; i--){
				if(i>0)
					bonbons[i][localisationVide.get(1)] = bonbons[i-1][localisationVide.get(1)];
				if(i==0)
					bonbons[i][localisationVide.get(1)] = new BonbonStandard().getBb(new Random().nextInt(4)+1);
				System.out.println(localisationVide.get(0));
			}
			localisationVide.remove(0);//Ligne
			localisationVide.remove(0);//Colonne			
		}		
	}
	public void disparitionBonbon(int ordonnee, int abscisse){
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bonbons[ordonnee][abscisse]=new Bonbons(0, " "); //O identifiant NULL
	}
	public void remplissageBonbons() {
		Random rnd = new Random();
		BonbonStandard bb = new BonbonStandard();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bonbons[i][j] = bb.getBb(rnd.nextInt(4) + 1);
			}
		}
	}

	public void setBonbon(int ordonnee, int abscisse, Bonbons valeur) {
		bonbons[ordonnee][abscisse] = valeur;
	}

	public void afficheTableau() {
		Random rnd = new Random();
		BonbonStandard bb = new BonbonStandard();
		int k = 0;
		for (int i = 0; i < n*2+1; i++) {
			for (int j = 0; j < n; j++) {
				if (i % 2 == 0) {
					if (j == n-1) {
						System.out.print("+-----+");
					} else {
						System.out.print(uneligne);
					}
				} else {
					if (j == n-1) {
						System.out.print("|  " + bonbons[i / 2][j] + "  |");
					} else {
						unecolonne = "|  " + bonbons[i / 2][j] + "  ";
						System.out.print(unecolonne);
					}
				}
			}
			System.out.println();
		}
	}

	public Bonbons getBonbons(int ordonnee, int abscisse) {
		return bonbons[ordonnee][abscisse];
	}
	
	private boolean verifHorizontal() {
		Bonbons tmp = null;
		boolean verif = false;
		int cpt = 1;

		for (int i = 0; i < bonbons.length; i++) {
			cpt = 1;
			for (int j = 1; j < bonbons[0].length; j++) {
				tmp = bonbons[i][j - 1];
				if (tmp.getId() == bonbons[i][j].getId()) {
					cpt++;
				} else {
					cpt = 1;
				}
				if (cpt >= 3) {
					verif = true;
				}
			}
		}
		return verif;
	}

	private boolean verifVertical() {
		Bonbons tmp = null;
		boolean verif = false;
		int cpt = 1;

		for (int j = 0; j < bonbons.length; j++) {
			cpt = 1;
			for (int i = 1; i < bonbons[0].length; i++) {
				tmp = bonbons[i - 1][j];
				if (tmp.getId() == bonbons[i][j].getId()) {
					cpt++;
				} else {
					cpt = 1;
				}
				if (cpt >= 3) {
					verif = true;
				}
			}
		}
		return verif;
	}

	public boolean decomptePossibilite() {
		if (verifHorizontal() && verifVertical()) {
			return true;
		} else {
			return false;
		}

	}

	public void siBlocage() {
		while (!decomptePossibilite()) {
			remplissageBonbons();
		}
	}

	public void main() {
		remplissageBonbons();
		afficheTableau();
	}
	
	public void setN(int taille){
		this.n = taille;
	}
	public int getN(){
		return this.n;
	}
}
