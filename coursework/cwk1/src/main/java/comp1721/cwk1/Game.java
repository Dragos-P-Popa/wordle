package comp1721.cwk1;


import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {
  public String word;
  public WordList list;
  public LocalDateTime initialDate, currentDate;
  public DateTimeFormatter formatForDate;

  // TODO: Implement constructor with String parameter
  public Game(String location) throws IOException {
    formatForDate = DateTimeFormatter.ofPattern("dd MM yyyy");
    initialDate = LocalDateTime.from(LocalDate.parse("19 06 2021", formatForDate));
    currentDate = LocalDateTime.from(LocalDate.parse("10 02 2022", formatForDate));
    long daysBetween = Duration.between(initialDate, currentDate).toDays();

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
