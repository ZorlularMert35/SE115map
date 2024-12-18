public class City{
    private String name;
    private String time;
    public City(String cityName, String time){
        this.name = cityName;
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }public String getName(){
        return this.name;
    }
}