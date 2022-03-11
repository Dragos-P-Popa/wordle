import java.io.Files;

public class Dataset {
    public ArrayList<double> data;

    public Dataset(String filename) throws IOException{
        Path path = Paths.get(filename);
        String text = Files.readString(path);
        data = Files.readAllLines(path);

    }

    public int size(){
        return data.size();
    }

    public double meanValue() {
        int total = 0;
        for (int i = 0; i < data.size()-1; i++) {
            total = total + data.get(i);
        }
        return total/size();
    }
}