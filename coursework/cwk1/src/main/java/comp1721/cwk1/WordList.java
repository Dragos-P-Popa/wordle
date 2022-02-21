package comp1721.cwk1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WordList {
  public List<String> words;

  // TODO: Implement constructor with a String parameter
  public WordList(String location)throws IOException {
    Path path = Paths.get(location);
    words = Files.readAllLines(path);
  }

  // TODO: Implement size() method, returning an int
  public int size(){
    return words.size();
  }

  // TODO: Implement getWord() with an int parameter, returning a String
  public String getWord(int i){
    try{
      return words.get(i);
    }catch (IndexOutOfBoundsException e){
      throw new GameException("Error: " + e.getMessage());
    }

  }
}
