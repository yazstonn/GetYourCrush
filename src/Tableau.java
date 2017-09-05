import java.util.Random;

public class Tableau {
	private Bonbons[][] bonbons = new Bonbons[6][6];
	protected String uneligne = "+-----";
	protected String unecolonne = "";

	public Tableau() {
		remplissageBonbons();
	}

	public Bonbons[][] getTab() {
		return bonbons;
	}

	public void remplissageBonbons() {
		Random rnd = new Random();
		BonbonStandard bb = new BonbonStandard();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
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
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 6; j++) {
				if (i % 2 == 0) {
					if (j == 5) {
						System.out.print("+-----+");
					} else {
						System.out.print(uneligne);
					}
				} else {
					if (j == 5) {
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
}
