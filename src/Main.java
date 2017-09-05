import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tableau tab = new Tableau();
		tab.remplissageBonbons();
		tab.afficheTableau();
		//System.out.println("nb possibilitées: "+ Possibilitees(Tableau.bonbons));
		//System.out.println("Destruction verticale: " + new bonbonSpecifique(true,5));
		//System.out.println("Destruction horizontale : " + new bonbonSpecifique(false,6));
		System.out.println("(horizontale:verticale");
		System.out.println("Entrez une coordonnées de départ: ");
		String repCordDeb = sc.nextLine();
		System.out.println("Entrez une coordonnées de fin:");
		String repCordFin = sc.nextLine();
		System.out.println(Possible(tab.getTab(),repCordDeb,repCordFin));
	}
	public static boolean Possible(Bonbons[][] bbs,String CDeb,String CFin){
		int Hdeb=0,Hfin=0,Vdeb=0,Vfin=0,cpt;
		char c;
		boolean endDeb = false;
		boolean endFin = false;
		boolean fine = true;
		cpt=0;
		while(!endDeb && !endFin){
			if(!endDeb){
				c = CDeb.charAt(cpt);
				if(!Character.isDigit(c) && c!=':'){
					fine = false;
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
					fine = false;
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
		boolean isV = Hdeb==Hfin;
		boolean result = true;
		if(!isV){
			for(int i=0;i<Hfin+1;i++){
				if(Hdeb+i < 6){
					if(!bbs[Vdeb][Hdeb].compare(bbs[Vdeb][Hdeb+i])){
						result = false;
						System.out.println("id1:"+bbs[Vdeb][Hdeb+i]+"\nid2:"+bbs[Vdeb][Hdeb+1]);
						System.out.println("isV:"+isV+"\ntour n:"+i+"\nresult:"+result+"\nvdeb+i+1:"+Vdeb+i+1);
					}
				}
			}
		}
		else{
			for(int i=0;i<Vfin+1;i++){
				if(Vdeb+i < 6){
					if(!bbs[Vdeb][Hdeb].compare(bbs[Vdeb+i][Hdeb])){
						result = false;
						System.out.println("id1:"+bbs[Vdeb+i][Hdeb]+"\nid2:"+bbs[Vdeb+1][Hdeb]);
						System.out.println("isV:"+isV+"\ntour n:"+i+"\nresult:"+result+"\nhdeb+i+1:"+Hdeb+i+1);
					}
				}
			}
		}
		return result;
	}
	public static boolean blocage(Bonbons[][] bbs){
		return false;
	}
}
