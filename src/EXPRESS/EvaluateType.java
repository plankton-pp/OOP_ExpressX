package EXPRESS;

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
