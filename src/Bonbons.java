
public class Bonbons {
	protected int id;
	protected int score;
	protected String symbol;
	protected boolean spec;
	protected Coordonnees cord;
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
	public Bonbons(int id,String symb,boolean spe,int sc){
		this.id = id;
		this.symbol = symb;
		this.spec = spe;
		this.score = sc;
	}
	public void setCord(Coordonnees coord){
		this.cord = coord;
	}
	public Coordonnees getCord(){
		return this.cord;
	}
	public void setScore(int sc){
		this.score = sc;
	}
	public int getScore(){
		return this.score;
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
	public boolean compare(Bonbons bb){
		return this.id == bb.getId();
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
