/** ComputerPlayer  models a computerized card player  */
public class ComputerPlayer extends CardPlayer implements Blank
{ /** ComputerPlayer builds the player
    * @param max_cards - the maximum cards the player can hold.  */
  
	boolean is_hit = true;
	boolean is_win = false;
	private String blankinfo;
	public ComputerPlayer(int max_cards, int money)
  { super(max_cards, money); }  // invoke constructor in superclass
	public String showCards() {
		String info = "";
		String blank = "";
	    for ( int i = 0;  i < card_count;  i = i+1 ) {
	        
	    	if (i < 2) {
	        	 blank = blank + my_hand[i].suitOf() + my_hand[i].countOf() + "        ";
	        	 info = info + "???        ";
	         }
	         else
	         	info = info + my_hand[i].suitOf() + my_hand[i].countOf()+"        ";
	    }
	    blankinfo = blank;
	    return info;
	}
	public String showBlank() {
		return "dealer's hidden card: " + blankinfo;
	}
	public void resetBlank() {
		blankinfo = "";
	}
  
  
}