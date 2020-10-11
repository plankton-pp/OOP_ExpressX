package EXPRESS;

public class EvaluateWeight {
    double weight, priceOfVolume = 0;


    public EvaluateWeight(double weight){
        this.weight =weight;

        if(this.weight <= 1000){
            priceOfVolume = 30;
        }
        else if(this.weight <= 5000){
            priceOfVolume = 65;
        }
        else if(this.weight <= 10000){
            priceOfVolume = 100;
        }
        else if(this.weight <= 15000){
            priceOfVolume = 140;
        }else if(this.weight <= 20000){
            priceOfVolume = 290;
        }else {
            priceOfVolume = 380;
        }


    }
    public double getPriceOfWeight(){
        return priceOfVolume;
    }
}
