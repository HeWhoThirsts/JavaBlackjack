import java.util.ArrayList;

import javax.swing.ImageIcon;

public class card {
	private final static ImageIcon back = new ImageIcon(BlackjackMain.class.getResource("/assets/back@2x.png"));
	private ImageIcon face;
	private int value;
	private boolean flipped;
	private static ArrayList<card> crd;
	
	public card(String imageName) {
		if(crd == null)
			crd = new ArrayList<card>();
		
		face = new ImageIcon(BlackjackMain.class.getResource("/assets/"+imageName));
		int test = imageName.indexOf('_');
		value = Integer.parseInt(imageName.substring(0, imageName.indexOf('_')));
		flipped = true;
		crd.add(this);
	}
	public ImageIcon GetCard() {
		if(flipped)
		return face;
		else
			return back;
	}
	public void up() {
		flipped = true;
	}
	public int val() {
		if(flipped)
			return value;
		else
			return 0;
	}
	public void flip() {
			flipped = !flipped;
	}
	public static void flipAll(){
		for(int i = 0; i<crd.size();i++)
			crd.get(i).up();
	}
	}
