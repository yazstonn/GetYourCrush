
public class Tableau {
	protected static char lebonbon=' ';
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.println("+-----");
				if(j==4){
					System.out.println("+\n");
				}
			}
			for (int k = 0; k < 5; k++) {
				System.out.println("|  "+lebonbon+"  |");
				if(k==4){
					System.out.println("+\n");
				}
				
			}
			for (int l = 0; l < 5; l++) {
				System.out.println("+-----");
				if(l==4){
					System.out.println("+\n");
				}
			}
		}
	}
	/*protected static String unecase=" ____\n | "+lebonbon;
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			if(i==5){
				unecase=" ____\n | "+lebonbon+" |\n |___|";
			}
			for (int j = 0; j < 5; j++) {
				System.out.println(unecase);
			}
		}
	}*/
}


