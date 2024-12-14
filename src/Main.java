import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> datas = Files.readAllLines(Paths.get("map1.txt"));
            for(int i =0;i<datas.size();i++){
                String lines = datas.get(i);
                String[] data = lines.split(" ");
                //System.out.println(Arrays.toString(data));
                if(i==2 && data.length > 2){
                    System.out.println(data[2]);
                }
            }

        } catch (Exception e) {

        }
    }
}
