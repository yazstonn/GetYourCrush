
public class bonbonSpecifique extends Bonbons {

	private boolean orientation; // true = verticale ou  false = horizontale 
	
	
	public bonbonSpecifique(boolean orientation, int id){
		//id = 5 Verticale | id=6 Horizontale
		super(id, "", true);
		if(orientation){
			super.setSymbol("\u04E8");
		}else
			super.setSymbol("\u0298");
		
		this.orientation = orientation;
	}


	public boolean isVerticale() {
		return orientation;
	}
	
	public String toString(){
		return super.toString();
	}
	
	
}