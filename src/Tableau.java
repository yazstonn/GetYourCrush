
public class Tableau {
	protected static Bonbons[][] bonbons = new Bonbons[6][6];
	protected static String uneligne="+-----";
	
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
						System.out.print("|  "+bonbons[i][j]+"  |");
					}else{
						System.out.print("|  "+bonbons[i][j]+"  ");
					}
				}
			}
			System.out.println();
		}
	}
}
