
public class BonbonStandard{
	private Bonbons[] typeBonbons = new Bonbons[4];
	public BonbonStandard(){
		typeBonbons[0] = new Bonbons(1,"\u00A4",false,0);
		typeBonbons[1] = new Bonbons(2,"\u01A2",false,0);
		typeBonbons[2] = new Bonbons(3,"\u0277",false,0);
		typeBonbons[3] = new Bonbons(4,"\u03E5",false,0);
	}
	public Bonbons getBb(int id){
		return typeBonbons[id-1];
	}
}
