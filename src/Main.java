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
		String repCordDeb;
		String repCordFin;
		while(!finDuGame){
			tab.afficheTableau();
			System.out.println("Coups restants: "+ (nbCoup-coupActu));
			System.out.println("(Colonne:Ligne)");
			boolean scanOk = true;
			do{
				System.out.println("Entrez une coordonnées de départ: ");
				repCordDeb = sc.nextLine();
				//controle de la saisie:
				scanOk = controleSaisie(repCordDeb);
				if(!scanOk){
					System.out.println("Mauvaise saisie ! (format : Colonne:Ligne)");
				}
			}while(!scanOk);
			do{
				scanOk = true;
				System.out.println("Entrez une coordonnées de fin:");
				repCordFin = sc.nextLine();
				//controle de la saisie:
				scanOk = controleSaisie(repCordFin);
				if(!scanOk){
					System.out.println("Mauvaise saisie ! (format : Colonne:Ligne)");
				}
			}while(!scanOk);
			//effectuer modif du coup
			
			if(Possible(tab.getTab(),repCordDeb,repCordFin)){
				//compteur bonbon spec
				int compteur = 0;
				//modifier tableau
				coupActu++;
				//Colonne
				if((Integer.parseInt(repCordFin.substring(0, 1))-(Integer.parseInt(repCordDeb.substring(0, 1)))==0)){
					for(int i=(Integer.parseInt(repCordDeb.substring(2, 3))); i<=(Integer.parseInt(repCordDeb.substring(2, 3)))+(Integer.parseInt(repCordFin.substring(2, 3))-(Integer.parseInt(repCordDeb.substring(2, 3)))); i++){
						tab.disparitionBonbon(i, Integer.parseInt(repCordDeb.substring(0, 1)));
						compteur++;
					}
				}else{
				//Ligne
					for(int i=(Integer.parseInt(repCordDeb.substring(0, 1))); i<=(Integer.parseInt(repCordDeb.substring(0, 1)))+(Integer.parseInt(repCordFin.substring(0, 1))-(Integer.parseInt(repCordDeb.substring(0, 1)))); i++){
						tab.disparitionBonbon(Integer.parseInt(repCordDeb.substring(2, 3)), i);
						compteur++;
					}
					
				}
				if(compteur >= 5)
					activationBonbonSpec = true;
				
				tab.detectionVide();

				
			}
			if(coupActu == 10){
				finDuGame = true;
			}
			System.out.flush();
			
		}
	}
	public static boolean controleSaisie(String CDeb){
		char c;
		boolean result = true;
		boolean milieu = false;
		for(int i=0;i<CDeb.length();i++){
			c = CDeb.charAt(i);
			if(!Character.isDigit(c) && c!=':'){
				result = false;
			}
			if(c == ':' && !milieu){
				milieu = true;
			}
			else if(c == ':' && milieu){
				result = false;
			}
			
		}
		return result;
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
				if(!Character.isDigit(c) && c!=':'){
				}
				if(c == ':'){
					Hdeb = Integer.valueOf(CDeb.substring(0,cpt));
					Vdeb = Integer.valueOf(CDeb.substring(cpt+1, CDeb.length()));
					endDeb = true;
				}
			}
			if(!endFin){
				c = CFin.charAt(cpt);
				if(!Character.isDigit(c) && c!=':'){
				}
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
		//check si cord dans tab
		boolean result = true;
		if(Hfin > bbs[1].length || Hdeb > bbs[1].length || Vdeb > bbs[0].length || Vfin > bbs[0].length){
			result = false;
		}
		else{
			boolean isV = Hdeb==Hfin;
			if(!isV){
				for(int i=0;i<Hfin;i++){
					if(Hdeb+i < 6){
						if(!bbs[Vdeb][Hdeb].compare(bbs[Vdeb][Hdeb+i])){
							result = false;
							//System.out.println("id1:"+bbs[Vdeb][Hdeb+i]+"\nid2:"+bbs[Vdeb][Hdeb+1]);
							//System.out.println("isV:"+isV+"\ntour n:"+i+"\nresult:"+result+"\nvdeb+i+1:"+Vdeb+i+1);
						}
					}
				}
			}
			else{
				for(int i=0;i<Vfin;i++){
					if(Vdeb+i < 6){
						if(!bbs[Vdeb][Hdeb].compare(bbs[Vdeb+i][Hdeb])){
							result = false;
							//System.out.println("id1:"+bbs[Vdeb+i][Hdeb]+"\nid2:"+bbs[Vdeb+1][Hdeb]);
							//System.out.println("isV:"+isV+"\ntour n:"+i+"\nresult:"+result+"\nhdeb+i+1:"+Hdeb+i+1);
						}
					}
				}
			}
		}
		
		return result;
	}
}
