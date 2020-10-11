package EXPRESS;

public class EvaType {
    double tprice = 0;

    public EvaType(String type){
        if(type.equals("N")){
            tprice = 20;
        }
        else{
            tprice = 50;
        }


    }

    public double evaT(){
        return tprice;
    }
}
