package comp1721.cwk2;

import java.util.*;

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
            if (handString[i] != null) {
                Card tempLocal = new Card(handString[i]);
                if (tempLocal.equals(card)) {
                    throw new CardException("Duplicate card");
                }
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
        if ((int) Arrays.stream(handString).filter(Objects::nonNull).count() != 0){
            Arrays.fill(handString, null);
        } else {
            throw new CardException("Hand is empty");
        }
    }

    public void discardTo(Deck deck){
        if ((int) Arrays.stream(handString).filter(Objects::nonNull).count() != 0){
            for (int i = 0; i < 5; i++) {
                if (handString[i] != null){
                    deck.add(new Card(handString[i]));
                }
            }
            Arrays.fill(handString, null);
        } else {
            throw new CardException("Hand is empty");
        }
    }

    public boolean isPair(){
        List handList = Arrays.asList(handString);
        Set<String> handSet = new HashSet<String>(handList);

        for(String s: handSet){
            if (Collections.frequency(handSet,s) == 1){
                return true;
            }
        }
        return false;
    }

    public boolean isFullHouse(){
        return false;
    }

    public boolean isTwoPairs(){
        List handList = Arrays.asList(handString);
        Set<String> handSet = new HashSet<String>(handList);

        for(String s: handSet){
            if (Collections.frequency(handSet,s) == 2){
                return true;
            }
        }
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
