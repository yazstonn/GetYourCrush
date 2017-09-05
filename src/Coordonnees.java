
public class Coordonnees {
	private int x;
	private int y;
	
	public Coordonnees(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean equals(Coordonnees a){
		if(this.x == a.x){
			if(this.y==a.y){
				return true;
			}
		}
		return false;
	}

}
