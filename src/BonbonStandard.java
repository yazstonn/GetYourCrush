public class BonbonStandard{
    private Bonbons[] typeBonbons = new Bonbons[4];
    public BonbonStandard(){
        typeBonbons[0] = new Bonbons(1,"\u001B[31m\u00A4\u001B[0m",false,20);
        typeBonbons[1] = new Bonbons(2,"\u001B[32m\u01A2\u001B[0m",false,20);
        typeBonbons[2] = new Bonbons(3,"\u001B[33m\u0277\u001B[0m",false,20);
        typeBonbons[3] = new Bonbons(4,"\u001B[36m\u047A\u001B[0m",false,20);
    }
    public Bonbons getBb(int id){
        return typeBonbons[id-1];
    }
    public boolean compare(Bonbons bb1,Bonbons bb2){
        if(bb1.getId() == bb2.getId()){
            return true;
        }
        else{
            return false;
        }
    }
}