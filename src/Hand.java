import java.util.ArrayList;

public class Hand {
	public static int max;
	ArrayList<card> h = new ArrayList<card>();
	boolean playerCont;
	DeckOfCards d;
	String name;
	String endGame;
	public Hand(DeckOfCards deck, boolean pCont, String n) {
		endGame ="";
		d=deck;
		playerCont = pCont;
		name = n;
		if(this.hValue()>max && this.hValue()<22 && playerCont) max = this.hValue();
	}
	public Hand(Hand hnd,card c) {
		d=hnd.d;
		playerCont = hnd.playerCont;
		name = hnd.name;
		h.add(c);
	}
	public Hand Split() {
		card c = h.remove(1);
		Hand hnd = new Hand(this,c);
		return hnd;
	}
	public String name() {
		return name;
	}
	public card get(int index) {
		if(this.hValue()>max && this.hValue()<22 && playerCont) max = this.hValue();
		if(h.get(index)!= null)
			return h.get(index);
		else
			return null;
	}
	public void draw(int cards) {
		for(int i = 0; i < cards; i++)
		h.add(d.draw());
		if(this.hValue()>max && this.hValue()<22 && playerCont) max = this.hValue();
	}
	public void flip(int index) {
		h.get(index).flip();
	}
	public int numCards() {
		return h.size();
	}
	public void up() {
		for(int i = 0; i < h.size();i++) {
			h.get(i).up();
		}
	}
	public ArrayList<card> getAll(){
		return h;
	}
	public void clear() {
		max = 0;
		h.clear();
	}
	public int hValue() {
		int temp = 0;
		int temp2 = 0;
		for(int i = 0; i < h.size();i++) {
			temp2 =h.get(i).val();
			if(temp2 == 1 && temp < 11)
				temp2 = 11;
			temp += temp2;
		}
		return temp;
	}
	
}
