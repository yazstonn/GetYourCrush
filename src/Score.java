
public class Score {
	
	private double score;
	
	public Score(){
		score = 0;
	}
	
	public double getScore(){
		return score;
	}
	
	public void incr(int nbbonbon,Bonbons bb){
		if (nbbonbon == 3) {
			score+=bb.getScore()*3;
		}else if(nbbonbon>3){
			//C-C-C-C-COMBO
			double scTmp = bb.getScore()*3;
			for(int i=nbbonbon;i>3;i--){
				scTmp = scTmp*1.42;
			}
			//FATALITY
			score+=scTmp;
		}
		
	}
	public void incr(int nbbonbon,Bonbons bb,bonbonSpecifique bbs){
	
		
	}
}
