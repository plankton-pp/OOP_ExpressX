package EXPRESS;

public class Box {
    private int id;
    private String size;
    private int weight = 0;
    private String volume;
    private String status ="Picked up";
    private String transporting;
    public String[] detail;

    public Box(int id,String size,int weight,String volume,String transport){
        setId(id);
        setSize(size);
        setWeight(weight);
        setVolume(volume);
        setTransporting(transport);
        detail= new String[]{String.format("%d", id), size, String.format("%d", weight), volume,status,transport};
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

    public void setTransporting(String transporting) {
        this.transporting = transporting;
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

    public String getTransporting() {
        return transporting;
    }
}
