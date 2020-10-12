package B6123338_B6122997_B6121921;

public class EvaluateType {
    double priceOfType = 0;

    public EvaluateType(int type){
        if(type==0){
            priceOfType = 20;
        }
        else{
            priceOfType = 50;
        }


    }

    public double getPriceOfType(){
        return priceOfType;
    }
}
