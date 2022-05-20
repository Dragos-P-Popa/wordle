package comp1721.cwk2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PokerHand {
    public static int FULL_SIZE = 52;
    public String[] handString;


    public PokerHand(){
        handString = new String[]{null, null, null, null, null};
    }

    public PokerHand(String hand){
        String[] splitHand = hand.split("\\s+");
        if (splitHand.length > 5){
            throw new CardException("Too many cards.");
        }
        handString = new String[]{null, null, null, null, null};
        System.arraycopy(splitHand, 0, handString, 0, splitHand.length);
    }

    public void add(Card card){
        if (this.size() == 5){
            throw new CardException("Hand is full");
        }
        for (int i = 0; i < 5; i++) {
            if (handString[i] ==  "" + card.getRank() + card.getSuit()){
                throw new CardException("Duplicate card");
            }
        }
        for (int i = 0; i < 5; i++) {
            if (handString[i] == null){
                handString[i] = "" + card.getRank() + card.getSuit();
                break;
            }
        }
    }

    public String toString(){
        String retString = "";
        for (int i = 0; i < handString.length; i++) {
            if (handString[i] == null){
                continue;
            }
            retString = retString + handString[i] + " ";
        }
        if (retString.length() >= 3){
            StringBuilder withoutSpace = new StringBuilder(retString);
            withoutSpace.deleteCharAt(retString.length()-1);
            return String.valueOf(withoutSpace);
        }
        return retString;
    }

    public int size(){
        return (int) Arrays.stream(handString).filter(Objects::nonNull).count();
    }

    public void discard(){
        Arrays.fill(handString, null);
    }

    public void discardTo(Deck deck){

    }

    public boolean isPair(){
        return false;
    }

    public boolean isFullHouse(){
        return false;
    }

    public boolean isTwoPairs(){
        return false;
    }

    public boolean isFlush(){
        return false;
    }

    public boolean isThreeOfAKind(){
        return false;
    }

    public boolean isStraight(){
        return false;
    }

    public boolean isFourOfAKind(){
        return false;
    }
}
