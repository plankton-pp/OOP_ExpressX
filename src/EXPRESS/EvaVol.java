package EXPRESS;

public class EvaVol {
    double vol,price = 0;


    public EvaVol(double vol){
        this.vol =vol;

        if(this.vol <= 1000){
            price = 30;
        }
        else if(this.vol <= 5000){
            price = 65;
        }
        else if(this.vol <= 10000){
            price = 100;
        }
        else if(this.vol <= 15000){
            price = 140;
        }else if(this.vol <= 20000){
            price = 290;
        }else {
            price = 380;
        }


    }
    public double evaV(){
        return price;
    }
}
