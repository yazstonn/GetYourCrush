import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tableau tab = new Tableau();
		tab.remplissageBonbons();
		boolean finDuGame = false;
		boolean activationBonbonSpec = false;
		int nbCoup = 10;
		int coupActu = 0;
		Score score = new Score();
		int n = 0;
		String repCordDeb, repCordFin, tailleTab;
		boolean tailleOk;
		do {
			tailleOk = true;
			System.out.println("Taille du tableau: (6,7 ou 8)");
			tailleTab = sc.nextLine();
			try {
				n = Integer.parseInt(tailleTab);
			} catch (NumberFormatException e) {
				System.out.println("Erreur de saisie !");
				tailleOk = false;
			}
			tailleOk = n >= 6 && n <= 8;
		} while (!tailleOk);

		tab.setN(n);
		while (!finDuGame) {
			tab.siBlocage();
			tab.afficheTableau();
			score.afficheScore();
			System.out.println("Coups restants: " + (nbCoup - coupActu));
			System.out.println("(Colonne:Ligne)");
			boolean scanOk = true;
			do {
				System.out.println("Entrez une coordonnées de départ: ");
				repCordDeb = sc.nextLine();
				// controle de la saisie:
				scanOk = controleSaisie(repCordDeb);
				if (!scanOk) {
					System.out.println("Mauvaise saisie ! (format : Colonne:Ligne)");
				}
			} while (!scanOk);
			do {
				scanOk = true;
				System.out.println("Entrez une coordonnées de fin:");
				repCordFin = sc.nextLine();
				// controle de la saisie:
				scanOk = controleSaisie(repCordFin);
				if (!scanOk) {
					System.out.println("Mauvaise saisie ! (format : Colonne:Ligne)");
				}
			} while (!scanOk);
			// effectuer modif du coup

			if (Possible(tab, repCordDeb, repCordFin)) {

				String[] coupDeb = repCordDeb.split(":");
				String[] coupFin = repCordFin.split(":");

				// compteur bonbon spec + score
				int compteur = 0;
				// modifier tableau
				coupActu++;
				// Colonne
				if ((Integer.parseInt(coupFin[0]) - (Integer.parseInt(coupDeb[0])) == 0)) {
					for (int i = (Integer.parseInt(coupDeb[1])); i <= (Integer.parseInt(coupDeb[1]))
							+ (Integer.parseInt(coupFin[1]) - (Integer.parseInt(coupDeb[1]))); i++) {

						tab.disparitionBonbon(i, Integer.parseInt(repCordDeb.substring(0, 1)));
						compteur++;

					}
				} else {
					// Ligne
					for (int i = (Integer.parseInt(coupDeb[0])); i <= (Integer.parseInt(coupDeb[0]))
							+ (Integer.parseInt(coupFin[0]) - (Integer.parseInt(coupDeb[0]))); i++) {

						tab.disparitionBonbon(Integer.parseInt(repCordDeb.substring(2, 3)), i);
						compteur++;

					}

				}
				if (compteur >= 3) {
					score.incr(compteur, new BonbonStandard().getBb(1));
				}
				if (compteur >= 5) {
					Random r = new Random();
					bonbonSpecifique bbSpec = new bonbonSpecifique(r.nextBoolean(), 5);

					tab.setBonbon(Integer.parseInt(coupDeb[1]),
							Integer.parseInt(coupDeb[0]), bbSpec);
				}

				tab.afficheTableau();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tab.detectionVide();

			}
			if (coupActu == 10) {
				finDuGame = true;
			}
			System.out.flush();

		}
	}

	public static boolean controleSaisie(String CDeb) {
		char c;
		boolean result = true;
		boolean milieu = false;
		for (int i = 0; i < CDeb.length(); i++) {
			c = CDeb.charAt(i);
			if (!Character.isDigit(c) && c != ':') {
				result = false;
			}
			if (c == ':' && !milieu) {
				milieu = true;
			} else if (c == ':' && milieu) {
				result = false;
			}

		}
		return result;
	}

	public static boolean Possible(Tableau tab, String CDeb, String CFin) {
		int Hdeb = 0, Hfin = 0, Vdeb = 0, Vfin = 0, cpt;
		char c;
		boolean endDeb = false;
		boolean endFin = false;
		cpt = 0;
		while (!endDeb && !endFin) {
			if (!endDeb) {
				c = CDeb.charAt(cpt);
				if (!Character.isDigit(c) && c != ':') {
				}
				if (c == ':') {
					Hdeb = Integer.valueOf(CDeb.substring(0, cpt));
					Vdeb = Integer.valueOf(CDeb.substring(cpt + 1, CDeb.length()));
					endDeb = true;
				}
			}
			if (!endFin) {
				c = CFin.charAt(cpt);
				if (!Character.isDigit(c) && c != ':') {
				}
				if (c == ':') {
					Hfin = Integer.valueOf(CFin.substring(0, cpt));
					Vfin = Integer.valueOf(CFin.substring(cpt + 1, CFin.length()));
					endDeb = true;
				}
			}
			cpt++;
		}
		// speration cord OK
		// check si coup is ok
		// check si cord dans tab
		boolean result = true;
		int n = tab.getN();
		Bonbons[][] bbs = tab.getTab();
		if (Hfin > n || Hdeb > n || Vdeb > n || Vfin > n) {
			result = false;
			System.out.println("Coordonnées invalides !");
		} else {
			boolean isV = Hdeb == Hfin;
			if (!isV) {
				for (int i = 0; i < Hfin; i++) {
					if (Hdeb + i < 6) {
						if (!bbs[Vdeb][Hdeb].compare(bbs[Vdeb][Hdeb + i])) {
							result = false;
							// System.out.println("id1:"+bbs[Vdeb][Hdeb+i]+"\nid2:"+bbs[Vdeb][Hdeb+1]);
							// System.out.println("isV:"+isV+"\ntour
							// n:"+i+"\nresult:"+result+"\nvdeb+i+1:"+Vdeb+i+1);
						}
					}
				}
			} else {
				for (int i = 0; i < Vfin; i++) {
					if (Vdeb + i < 6) {
						if (!bbs[Vdeb][Hdeb].compare(bbs[Vdeb + i][Hdeb])) {
							result = false;
							// System.out.println("id1:"+bbs[Vdeb+i][Hdeb]+"\nid2:"+bbs[Vdeb+1][Hdeb]);
							// System.out.println("isV:"+isV+"\ntour
							// n:"+i+"\nresult:"+result+"\nhdeb+i+1:"+Hdeb+i+1);
						}
					}
				}
			}
		}

		return result;
	}
}
