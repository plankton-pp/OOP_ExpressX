package EXPRESS;

public class Box {
    private int id;
    private String size;
    private int weight = 0;
    private String volume;
    private String status ="Pending";

    public Box(int id,String size,int weight,String volume){
        setId(id);
        setSize(size);
        setWeight(weight);
        setVolume(volume);
        System.out.println("The Box has been created and setted !!!");
    }
//SET Methods


    public void setId(int id) {
        this.id = id;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    //GET Methods
    public int getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public String getVolume() {
        return volume;
    }

    public int getWeight() {
        return weight;
    }

    public String getStatus() {
        return status;
    }
}
