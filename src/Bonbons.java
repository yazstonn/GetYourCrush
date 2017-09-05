
public class Bonbons {
	protected int id;
	protected String symbol;
	protected boolean spec;
	public Bonbons(int id){
		this.id = id;
	}
	public Bonbons(int id,String symb){
		this.id = id;
		this.symbol = symb;
	}
	public Bonbons(int id,String symb,boolean spe){
		this.id = id;
		this.symbol = symb;
		this.spec = spe;
	}
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
