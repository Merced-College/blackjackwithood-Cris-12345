//package cardGame;
//Abraham Gonzalez, Anthony Madrigal-Murillo, Cristopher Gomez 
//1/28/2025
//package cardGame;
//Abraham Gonzalez, Anthony Madrigal-Murillo, Cristopher Gomez 
//1/28/2025
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CardGame {

    private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
    private static ArrayList<Card> playerCards = new ArrayList<Card>();

    public static void main(String[] args) {

        Scanner input = null;
        try {
            input = new Scanner(new File("cards.txt"));
        } catch (FileNotFoundException e) {
            // error
            System.out.println("error");
            e.printStackTrace();
        }

        while (input.hasNext()) {
            String[] fields = input.nextLine().split(",");
            // public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
            Card newCard = new Card(fields[0], fields[1].trim(),
                    Integer.parseInt(fields[2].trim()), fields[3]);
            deckOfCards.add(newCard);
        }

        shuffle();
        shuffle();
        shuffle();
        shuffle();
        shuffle();
        shuffle();
        shuffle();
        shuffle();

        int k = 0;
        for (Card c : deckOfCards) {
            // System.out.println(k + " " + c);
            k++;
        }

        // deal the player 5 cards
        for (int i = 0; i < 5; i++) {
            playerCards.add(deckOfCards.get(i));
        }

        // remove the dealt cards from the deck
        for (int i = 0; i < 5; i++) {
            deckOfCards.remove(0);
        }

        System.out.println("players cards");
        for (Card c : playerCards)
            System.out.println(c);
        System.out.println("Three suits of a kind is " + threeSuitsOfAKind());
        System.out.println("pairs is " + checkFor2Kind());

    }// end main

    public static void shuffle() {

        // shuffling the cards by deleting and reinserting
        for (int i = 0; i < deckOfCards.size(); i++) {
            int index = (int) (Math.random() * deckOfCards.size());
            Card c = deckOfCards.remove(index);
            // System.out.println("c is " + c + ", index is " + index);
            deckOfCards.add(c);
        }
    }

    // check for 2 of a kind in the players hand
    public static boolean checkFor2Kind() {
        int count = 0;
        for (int i = 0; i < playerCards.size() - 1; i++) {
            Card current = playerCards.get(i);
            for (int j = i + 1; j < playerCards.size(); j++) {
                Card next = playerCards.get(j);
                //System.out.println(" comparing " + current);
                //System.out.println(" to " + next);
                if (current.equal(next))
                    count++;
            } // end of inner for
            if (count == 1)
                return true;
        } // end outer for
        return false;
    }

    // check for three of a kind based on suits in the player's hand
    public static boolean threeSuitsOfAKind() {
        for (int i = 0; i < playerCards.size(); i++) {
            int count = 0;
            String suit = playerCards.get(i).getSuit();
            for (int j = 0; j < playerCards.size(); j++) {
                if (playerCards.get(j).getSuit().equals(suit)) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

}// end class