package comp1721.cwk1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Game {
  public String word;
  public WordList list;
  public LocalDate initialDate;
  public LocalDate currentDate;
  public Guess guess;

  // TODO: Implement constructor with String parameter
  public Game(String location) throws IOException {

    initialDate = LocalDate.of(2021, 6, 19);
    currentDate = LocalDate.now();
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
    for (int i = 1; i < 6; i++) {
      Scanner input = new Scanner(System.in);  // Create a Scanner object
      System.out.println("Enter guess ("+i+"/6): ");
      String wordGuessed = input.nextLine();
      guess = new Guess(i,wordGuessed);
      System.out.println(guess.compareWith(word));
      if (guess.matches(word)){
        if (i == 1){
          System.out.println("Superb - Got it in one!");
          break;
        }
        if (2<=i && i<=5){
          System.out.println("Well done!");
          break;
        }
        if (i == 6){
          System.out.println("That was a close call!");
          break;
        }
      }
    }


  }

  // TODO: Implement save() method, with a String parameter
  public void save(String s) throws FileNotFoundException {
    PrintWriter writer = null;
    writer = new PrintWriter(new File(s));
    writer.write(guess.getSaveString());
    writer.flush();
    writer.close();
  }
}
