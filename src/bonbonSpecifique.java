
public class bonbonSpecifique extends Bonbons {

	private boolean orientation; // true = verticale ou  false = horizontale 
	
	
	public bonbonSpecifique(boolean orientation, int id){
		super(id, "", true);
		if(orientation){
			super.setSymbol("U+0298");
		}else
			super.setSymbol("U+04E8");
		
		this.orientation = orientation;
	}


	public boolean isOrientation() {
		return orientation;
	}
	
	public String toString(){
		return super.toString();
	}
	
	
}