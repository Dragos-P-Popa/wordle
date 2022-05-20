package comp1721.cwk2;

import java.util.*;

/**
 * Representation of a deck of playing cards.
 *
 * @author Dragos Popa
 */

public class Deck {
    public String[] deckString;

    /**
     * Initialising string array deckString which will hold all the cards currently in the deck.
     */
    public Deck(){
        deckString = new String[]{"AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
                "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "TH", "JH", "QH", "KH",
                "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD", "JD", "QD", "KD",
                "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "TS", "JS", "QS", "KS"};


    }

    /**
     * Returns size of the deck
     * Calculated by filtering out all null items
     * then counting what is left over
     * when removing a card from a deck it is replaced by Null
     */
    public int size(){
        return (int) Arrays.stream(deckString).filter(Objects::nonNull).count();
    }

    /**
     * Simple checker to see whether the array is empty, excluding null items
     */
    public boolean isEmpty(){
        if (this.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Checks if a certain card is present in the deck
     * @param card
     */
    public boolean contains(Card card){
        return Arrays.asList(deckString).contains(card.toString());
    }

    /**
     * Adds a new card to the deck
     * @param card
     */
    public void add(Card card){
        //add new card to the deck
        //iterate 52 times, max possible
        for (int i = 0; i < 52; i++) {
            //until we find a item which is null
            //in which case we replace the null with the new card
            if (deckString[i] == null){
                deckString[i] = "" + card.getRank() + card.getSuit();
                break;
            }
        }
    }

    /**
     * Replaces all items in the array will Null value
     */
    public void discard(){
        Arrays.fill(deckString, null);
    }

    /**
     * Deals a card from the deck
     */
    public Card deal(){
        //iterates throughout the whole array
        for (int i = 0; i < 52; i++) {
            //finds an item which is not null
            if (deckString[i] != null){
                //returns card from deck
                Card card = new Card(deckString[i]);
                //removes the card that will be returned so that it cannot be delt twice
                deckString[i] = null;
                return card;
            }
        }
        //if all items are null (deck is empty), throws error
        throw new CardException("The deck is empty");
    }

    /**
     * Shuffles the deck
     */
    public void shuffle(){
        Random rand = new Random();

        //iterates throughout the deck, excluding null items
        for (int i = 0; i < deckString.length; i++) {
            //picks random index to swap
            int randomIndexToSwap = rand.nextInt(deckString.length);
            String temp = deckString[randomIndexToSwap];
            deckString[randomIndexToSwap] = deckString[i];
            deckString[i] = temp;
        }

        //System.out.println(Arrays.toString(deckString));
    }
}

