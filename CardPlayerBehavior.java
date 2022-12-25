/** CardPlayerBehavior defines expected behaviors of card players */
public interface CardPlayerBehavior
{ 
  /** wantsACard replies whether the player wants one more new card
    * @return whether a card is wanted */

  /** receiveCard accepts a card and adds it to the player's hand 
    * @param c - the card  */
  public void receiveCard(Card c);
  
  public void updatescore();
 
  public String showCards();
  
  public void reset_hand();
}