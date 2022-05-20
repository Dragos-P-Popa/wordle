package comp1721.cwk2;

import java.lang.reflect.Array;
import java.util.*;

public class Deck {
    public String[] deckString;

    public Deck(){
        /**
         "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC", "AC",
         "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH", "AH",
         "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD", "AD",
         "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS", "AS"
         */
        deckString = new String[]{"AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
                "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "TH", "JH", "QH", "KH",
                "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD",
                "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "TS", "JS", "QS", "KS"};

        /**
         *  for (int i = 0; i < 52; i++) {
         *             if (i <= 12){
         *                 deck[i] = "C";
         *             }
         *             if (13 <= i && i <= 25){
         *                 deck[i] = "H";
         *             }
         *             if (26 <= i && i <= 38){
         *                 deck[i] = "D";
         *             }
         *             if (39 <= i && i <= 52){
         *                 deck[i] = "S";
         *             }
         *
         *         }
         */
    }

    public int size(){
        return (int) Arrays.stream(deckString).filter(Objects::nonNull).count();
    }

    public boolean isEmpty(){
        if (deckString.length > 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean contains(Card card){
        return Arrays.asList(deckString).contains(card.toString());
    }

    public void add(Card card){
        if (deckString.length < 52) {
            for (int i = 0; i < 52; i++) {
                if (deckString[i] == null){
                    deckString[i] = "" + card.getRank() + card.getSuit();
                    break;
                }
            }
        }
    }

    public void discard(){
        Arrays.fill(deckString, null);
    }

    public Card deal(){
        for (int i = 0; i < 52; i++) {
            if (deckString[i] != null){
                Card card = new Card(deckString[i]);
                deckString[i] = null;
                return card;
            }
        }

        throw new CardException("The deck is empty");
    }

    public void shuffle(){
        Random rand = new Random();

        for (int i = 0; i < deckString.length; i++) {
            int randomIndexToSwap = rand.nextInt(deckString.length);
            String temp = deckString[randomIndexToSwap];
            deckString[randomIndexToSwap] = deckString[i];
            deckString[i] = temp;
        }

        System.out.println(Arrays.toString(deckString));
    }
}

