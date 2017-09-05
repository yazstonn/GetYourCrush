import java.util.Random;
public class Tableau_rnd {
	protected static char lebonbon='O';
	protected static String uneligne="+-----";
	protected static String unecolonne="";
	
	public static void main(String[] args) {
		Random rnd = new Random();
		BonbonStandard bb = new BonbonStandard();
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
						System.out.print("|  "+bb.getBb(rnd.nextInt(4)+1)+"  |");
					}else{
						unecolonne="|  "+bb.getBb(rnd.nextInt(4)+1)+"  ";
						System.out.print(unecolonne);
					}
				}
			}
			System.out.println();
		}
	}
}
