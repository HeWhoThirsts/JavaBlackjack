import javax.swing.ImageIcon;

public class card {
	private final static ImageIcon back = new ImageIcon(BlackjackMain.class.getResource("/assets/back@2x.png"));
	private ImageIcon face;
	private int value;
	private boolean flipped;
	
	public card(String imageName) {
		face = new ImageIcon(BlackjackMain.class.getResource("/assets/"+imageName));
		int test = imageName.indexOf('_');
		value = Integer.parseInt(imageName.substring(0, imageName.indexOf('_')));
		flipped = true;
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
	}
