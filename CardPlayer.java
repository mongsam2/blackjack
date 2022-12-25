/** CardPlayer models an abstract form of card player */
public abstract class CardPlayer implements CardPlayerBehavior
{ protected Card[] my_hand;  // the player's cards
  protected int card_count;  // how many cards are held in the hand
  protected int my_money;
  protected int score;
  protected int max_cards;
  /** CardPlayer builds the player
    * @param max_cards - the maximum cards the player can hold.  */
  public CardPlayer(int max_cards, int money)
  { my_hand = new Card[max_cards];
  this.max_cards = max_cards;
  	my_money = money;
    card_count = 0;
  }

  /** wantsACard replies whether the player wants one more new card
    * @return whether a card is wanted */
  // method will be written later
  
  public void updatescore() {
	int new_score = 0;
	  for(int i=0; i<card_count; i++) {
		  if (my_hand[i].countOf() > 10) {
			  new_score += 10;
		  }
		  else
			  new_score += my_hand[i].countOf();
	  }
	score = new_score;
  }
  public void receiveCard(Card c)
  { my_hand[card_count] = c;
    card_count = card_count + 1;
  }

  /** showCards displays the player's hand
    * @return an array holding the cards in the hand  */
  public abstract String showCards();
 
  public void reset_hand() {
	  my_hand = new Card[max_cards];
	  card_count = 0;
	  score = 0;
  }
}