import javax.swing.JOptionPane;

/** HumanPlayer models a human who plays cards */
public class HumanPlayer extends CardPlayer
{/** HumanPlayer builds the player
    * @param max_cards - the maximum cards the player can hold  */
  boolean is_bet = true;
  boolean is_hit = false;
  boolean is_stop = false;
  boolean is_win = false;
  int lucky_number;
  public HumanPlayer(int max_cards, int money)
  { super(max_cards, money); }   // invoke constructor in superclass
  public String showCards()
  {String info = "";
    for ( int i = 0;  i < card_count;  i = i+1 ) 
    	{
         info = info + my_hand[i].suitOf() + my_hand[i].countOf()+"        ";
        }
    return info;
  }
  
}