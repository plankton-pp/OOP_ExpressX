package EXPRESS;

public class SumPrice {
    double priceOfType = 0;
    double priceOfVolume = 0;
    double priceOfSize =0;
    double totalPrice = 0;

    public void setPriceOfSize(double priceOfSize){
        this.priceOfSize = priceOfSize;
    }

    public void setPriceWeight(double weight){
        this.priceOfVolume = weight ;
    }
    public void setPriceofType(double tprice){
        this.priceOfType = tprice;
    }

    public double getTotalPrice(){
        totalPrice = this.priceOfSize +this.priceOfVolume +this.priceOfType;
        return totalPrice;
    }
}
