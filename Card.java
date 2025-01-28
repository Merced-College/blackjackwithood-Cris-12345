// Cristopher gomez 
// 
//
public class Card{
    
    //Data Variables
    private String suit;
    private String rank;
    private int value;
    private String picture;

    //default constructor
    public Card(){
        suit = "heart";
        rank = "One";
        value = 1;
        picture = "pic.gif";
    }

    //initialized constructor
    public Card(String suit, String rank, int value, String picture){
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.picture = picture;
    }

    //Setters
    public void setSuit(String suit){
        this.suit = suit;
    }

    public void setRank(String rank){
        this.rank = rank;
    }

    public void setValue(int value){
        this.value = value;
    }

    public void setPicture(String picture){
        this.picture = picture;
    }

    //Getters
    public String getSuit(){
        return suit;
    }

    public String getRank(){
        return rank;
    }

    public int getValue(){
        return value;
    }

    public String getPicture(){
        return picture;
    }
    public boolean equals(Card other){
        return rank.equals(other.rank) && value== other.value; 
    }

    //toString - Returns all varaibles
    public String toString(){
        return "suit = " + suit + "; rank = " + rank + "; value = " + value + "; picture = " + picture + ";";
    }
}