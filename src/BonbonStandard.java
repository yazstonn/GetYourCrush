
public class BonbonStandard{
	private Bonbons[] typeBonbons = new Bonbons[4];
	public BonbonStandard(){
		typeBonbons[0] = new Bonbons(1,"A",false,0);
		typeBonbons[1] = new Bonbons(2,"B",false,0);
		typeBonbons[2] = new Bonbons(3,"C",false,0);
		typeBonbons[3] = new Bonbons(4,"D",false,0);
	}
	public Bonbons getBb(int id){
		return typeBonbons[id-1];
	}
}
