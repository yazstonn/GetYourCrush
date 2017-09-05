
public class Bonbons {
	protected int id;
	protected String symbol;
	protected boolean spec;
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setSymbol(String symb){
		this.symbol = symb;
	}
	public void setSpec(boolean sp){
		this.spec = sp;
	}
	public boolean getSpec(){
		return spec;
	}
	public String toString(){
		if(symbol != null){
			return symbol;	
		}
		else{
			return "ERROR SYMBOL NOT SETTED !";
		}
	}
}
