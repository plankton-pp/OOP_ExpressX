package EXPRESS;

public class EvaSize {
    int mini = 7;
    int s = 10;
    int m = 17;
    int l = 25;
    int xl =30;

    double psize = 0;
    public EvaSize(String size){
        if(size.equals("mini")){
            psize = mini;
        }
        else if(size.equals("S")){
            psize = s;
        }
        else if(size.equals("M")){
            psize = m;
        }
        else if(size.equals("L")){
            psize = l;
        }
        else {
            psize = xl;
        }


    }

    public double evaS(){
        return psize;
    }
}
