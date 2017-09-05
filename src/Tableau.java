
public class Tableau {
	protected static char lebonbon='O';
	protected static String uneligne="+-----";
	protected static String unecolonne="|  "+lebonbon+"  ";
	
	public static void main(String[] args) {
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
						System.out.print("|  "+lebonbon+"  |");
					}else{
						System.out.print(unecolonne);
					}
				}
			}
			System.out.println();
		}
	}
}
