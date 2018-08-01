import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DeckOfCards {
private ArrayList<card> deck = new ArrayList<card>();
private ArrayList<card> dg = new ArrayList<card>();
public DeckOfCards(int decks) throws IOException {
	int d = 1;
	Scanner r = new Scanner(new File("CardList.txt"));
	ArrayList<String> cardNames = new ArrayList<String>();
	while(r.hasNext())
		cardNames.add(r.nextLine());
	while(!cardNames.isEmpty())
		deck.add(new card(cardNames.remove(0)));
	while(d<decks) {
		deck.addAll((ArrayList<card>)deck.clone());
		d++;
	}
	Collections.shuffle(deck);
	r.close();
}
public card draw() {
	if(!deck.isEmpty()) {
		return deck.remove(0);
	}else {
		deck.addAll(dg);
		Collections.shuffle(deck);
		return deck.remove(0);
	}
}
public ArrayList<card> getDeck(){
	return deck;
}
public void dis(ArrayList<card> c) {
	dg.addAll(c);
}
}
