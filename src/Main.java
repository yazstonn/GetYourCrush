import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tableau.remplissageBonbons();
		Tableau.afficheTableau();
		//System.out.println("nb possibilitées: "+ Possibilitees(Tableau.bonbons));
		//System.out.println("Destruction verticale: " + new bonbonSpecifique(true,5));
		//System.out.println("Destruction horizontale : " + new bonbonSpecifique(false,6));
		System.out.println("(horizontale:verticale");
		System.out.println("Entrez une coordonnées de départ: ");
		String repCordDeb = sc.nextLine();
		System.out.println("Entrez une coordonnées de fin:");
		String repCordFin = sc.nextLine();
		System.out.println(Possible(Tableau.bonbons,repCordDeb,repCordFin));
	}
	public static boolean Possible(Bonbons[][] bbs,String CDeb,String CFin){
		int Hdeb=0,Hfin=0,Vdeb=0,Vfin=0,cpt;
		char c;
		boolean endDeb = false;
		boolean endFin = false;
		cpt=0;
		while(!endDeb && !endFin){
			if(!endDeb){
				c = CDeb.charAt(cpt);
				if(c == ':'){
					Hdeb = Integer.valueOf(CDeb.substring(0,cpt));
					Vdeb = Integer.valueOf(CDeb.substring(cpt+1, CDeb.length()));
					endDeb = true;
				}
			}
			if(!endFin){
				c = CFin.charAt(cpt);
				if(c == ':'){
					Hfin = Integer.valueOf(CFin.substring(0,cpt));
					Vfin = Integer.valueOf(CFin.substring(cpt+1, CFin.length()));
					endDeb = true;
				}
			}
			cpt++;
		}
		//speration cord OK
		//check si coup is ok
		boolean isOk = false;
		if(Hdeb == Hfin || Vdeb == Vfin){
			isOk = true;
		}
		/*boolean result = true;
		if(isV){
			for(int i=0;i<length-1;i++){
				if(!bbs[Hdeb][Vdeb+i].compare(bbs[Hdeb][Vdeb+i+1])){
					result = false;
				}
			}
		}
		else{
			for(int i=0;i<length-1;i++){
				if(!bbs[Hdeb+i][Vdeb].compare(bbs[Hdeb+i+1][Vdeb])){
					result = false;
				}
			}
		}*/
		return isOk;
	}
	public static boolean blocage(Bonbons[][] bbs){
		return false;
	}
}
