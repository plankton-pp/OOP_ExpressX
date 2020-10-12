package B6123338_B6122997_B6121921;

public class EvaluateSize {
    int mini = 7;
    int s = 10;
    int m = 17;
    int l = 25;
    int xl =30;

    double priceOfSize = 0;
    public EvaluateSize(String size){
        if(size.equals("mini")){
            priceOfSize = mini;
        }
        else if(size.equals("S")){
            priceOfSize = s;
        }
        else if(size.equals("M")){
            priceOfSize = m;
        }
        else if(size.equals("L")){
            priceOfSize = l;
        }
        else {
            priceOfSize = xl;
        }


    }

    public double getPrice(){
        return priceOfSize;
    }
}
