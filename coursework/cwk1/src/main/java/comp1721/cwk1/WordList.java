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
    //Finding file, reading it and storing it in the list 'words'
    Path path = Paths.get(location);
    words = Files.readAllLines(path);
  }

  // TODO: Implement size() method, returning an int
  public int size(){
    //Using built in function "size()" to return the size of the list e.g. number of words
    return words.size();
  }

  // TODO: Implement getWord() with an int parameter, returning a String
  public String getWord(int i){
    //Try to get a certain word by index
    try{
      return words.get(i);
    }catch (IndexOutOfBoundsException e){
      //Throw error if the index is out of bounds
      throw new GameException("Error: " + e.getMessage());
    }

  }
}
