package comp1721.cwk1;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Game {
  public String word;
  public WordList list;
  public LocalDate initialDate;
  public LocalDate currentDate;
  public DateFormatter df;

  // TODO: Implement constructor with String parameter
  public Game(String location) throws IOException {

    DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MM yyyy");
    initialDate = LocalDate.parse("19 06 2021", df);
    currentDate = LocalDate.parse("10 02 2022", df);
    long daysBetween = ChronoUnit.DAYS.between(initialDate, currentDate);

    list = new WordList(location);
    word = list.getWord((int) daysBetween);
  }

  // TODO: Implement constructor with int and String parameters
  public Game(int i, String location) throws IOException {
    list = new WordList(location);
    word = list.getWord(i);
  }

  // TODO: Implement play() method
  public void play(){

  }

  // TODO: Implement save() method, with a String parameter
  public void save(String s){

  }
}
