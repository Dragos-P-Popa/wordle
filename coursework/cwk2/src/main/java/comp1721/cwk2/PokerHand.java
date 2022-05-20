package comp1721.cwk2;

import java.util.*;


/**
 * Representation of a poker hand.
 *
 * @author Dragos Popa
 */

public class PokerHand {
    public static int FULL_SIZE = 52;
    public String[] handString;


    /**
     * Creates an empty poker hand object
     */
    public PokerHand(){
        handString = new String[]{null, null, null, null, null};
    }

    /**
     * Creates a poker hand using the given string to populate it
     * @param hand
     */
    public PokerHand(String hand){
        String[] splitHand = hand.split("\\s+");
        if (splitHand.length > 5){
            throw new CardException("Too many cards.");
        }

        handString = new String[]{null, null, null, null, null};
        System.arraycopy(splitHand, 0, handString, 0, splitHand.length);
    }

    /**
     * Adds a card to the poker hand
     * @param card
     */
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

    /**
     * Returns the poker hand in string format
     * @return
     */
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

    /**
     * Returns the amount of card held in the hand currently
     * @return
     */
    public int size(){
        return (int) Arrays.stream(handString).filter(Objects::nonNull).count();
    }

    /**
     * Discards all cards from the hand
     */
    public void discard(){
        if ((int) Arrays.stream(handString).filter(Objects::nonNull).count() != 0){
            Arrays.fill(handString, null);
        } else {
            throw new CardException("Hand is empty");
        }
    }

    /**
     * Discards the card from the hand and adds it back into the deck
     * @param deck
     */
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
