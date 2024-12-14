import java.util.ArrayList;
import java.util.List;

public class CountryMap {
    private ArrayList<City> cityList;
    public CountryMap(){
        this.cityList = new ArrayList<>();
    }
    public void setCityList(int size){
        this.cityList = new ArrayList<>(size);
    }public void addCity(City city){
        this.cityList.add(city);
    }
    public ArrayList<City> getCityList() {
        return this.cityList;
    }
}
