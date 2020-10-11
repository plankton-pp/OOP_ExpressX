package EXPRESS;

public class Set {
    double tprice = 0;
    double vol = 0;
    double size =0;
    double price = 0;

    public void setSize(double size){
        this.size = size;
    }

    public void setVolume(double vol){
        this.vol = vol ;
    }
    public void setType(double tprice){
        this.tprice = tprice;
    }

    public double getPrice(){
        price = this.size+this.vol+this.tprice;
        return price;
    }
}
