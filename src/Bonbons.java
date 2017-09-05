
public abstract class Bonbons {
	protected int id;
	protected String symbol;
	public Bonbons(int id){
		this.id = id;
	}
	public Bonbons(int id,String symb){
		this.id = id;
		this.symbol = symb;
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
	public String toString(){
		if(symbol != null){
			return symbol;	
		}
		else{
			return "ERROR SYMBOL NOT SETTED !";
		}
	}
}
