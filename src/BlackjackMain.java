import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class BlackjackMain extends JFrame {
	public static int hand = 0;
	private JPanel contentPane;
	private JTextField txtDeckinput;
	private ArrayList<Hand> h = new ArrayList<Hand>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlackjackMain frame = new BlackjackMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	protected JButton btnNextGame;
	protected JLabel lblBot3;
	protected JLabel lblBot2;
	protected JLabel lblBot1;
	protected JLabel lblMid3;
	protected JLabel lblMid2;
	protected JLabel lblMid1;
	protected JLabel lblTop3;
	protected JLabel lblTop2;
	protected JLabel lblTop1;
	protected JButton btnBuy;
	protected JButton btnStay;
	protected JButton btnDoubleDown;
	protected JButton btnSplit;
	protected JButton btnNex;
	protected JButton btnPre;
	protected JLabel lblPlayer;
	protected ArrayList<JButton> btn;
	protected ArrayList<JLabel> ls;
	protected DeckOfCards d;
	public BlackjackMain() {
		setTitle("BLACKJACK");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 1051);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel cHand = new JPanel();
		cHand.setBackground(Color.WHITE);
		cHand.setBounds(0, 0, 673, 1004);
		contentPane.add(cHand);
		cHand.setLayout(null);

		lblBot3 = new JLabel("");
		lblBot3.setForeground(Color.WHITE);
		lblBot3.setBackground(Color.WHITE);
		lblBot3.setBounds(444, 681, 222, 323);
		lblBot3.setIcon(null);
		cHand.add(lblBot3);

		lblBot2 = new JLabel("");
		lblBot2.setForeground(Color.WHITE);
		lblBot2.setBackground(Color.WHITE);
		lblBot2.setBounds(222, 681, 222, 323);
		lblBot2.setIcon(null);
		cHand.add(lblBot2);

		lblBot1 = new JLabel("");
		lblBot1.setForeground(Color.WHITE);
		lblBot1.setBackground(Color.WHITE);
		lblBot1.setBounds(0, 681, 222, 323);
		lblBot1.setIcon(null);
		cHand.add(lblBot1);

		lblMid1 = new JLabel("");
		lblMid1.setForeground(Color.WHITE);
		lblMid1.setBackground(Color.WHITE);
		lblMid1.setBounds(0, 345, 222, 323);
		lblMid1.setIcon(null);
		cHand.add(lblMid1);

		JLabel lblMid2 = new JLabel("");
		lblMid2.setForeground(Color.WHITE);
		lblMid2.setBackground(Color.WHITE);
		lblMid2.setBounds(222, 345, 222, 323);
		lblMid2.setIcon(null);
		cHand.add(lblMid2);

		lblMid3 = new JLabel("");
		lblMid3.setForeground(Color.WHITE);
		lblMid3.setBackground(Color.WHITE);
		lblMid3.setBounds(444, 345, 222, 323);
		lblMid3.setIcon(null);
		cHand.add(lblMid3);

		lblTop1 = new JLabel("");
		lblTop1.setForeground(Color.WHITE);
		lblTop1.setBackground(Color.WHITE);
		lblTop1.setBounds(0, 0, 222, 323);
		lblTop1.setIcon(null);
		cHand.add(lblTop1);

		lblTop2 = new JLabel("");
		lblTop2.setForeground(Color.WHITE);
		lblTop2.setBackground(Color.WHITE);
		lblTop2.setBounds(222, 0, 222, 323);
		lblTop2.setIcon(null);
		cHand.add(lblTop2);

		lblTop3 = new JLabel("");
		lblTop3.setForeground(Color.WHITE);
		lblTop3.setBackground(Color.WHITE);
		lblTop3.setBounds(444, 0, 222, 323);
		lblTop3.setIcon(null);
		cHand.add(lblTop3);
		ls = new ArrayList<JLabel>();

		ls.add(lblTop1);
		ls.add(lblTop2);
		ls.add(lblTop3);
		ls.add(lblMid1);
		ls.add(lblMid2);
		ls.add(lblMid3);
		ls.add(lblBot1);
		ls.add(lblBot2);
		ls.add(lblBot3);

		JPanel panel = new JPanel();
		panel.setBounds(685, 5, 205, 968);
		contentPane.add(panel);
		panel.setLayout(null);

		btnBuy = new JButton("Buy");
		btnBuy.setEnabled(false);
		btnBuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnBuy.isEnabled()&&h.get(hand).hValue()<21) {
					h.get(hand).draw(1);
					displayHand();
					CheckScore();
					
				}

			}
		});
		btnBuy.setBounds(0, 25, 107, 25);
		panel.add(btnBuy);

		btnStay = new JButton("Stay");
		btnStay.setEnabled(false);
		btnStay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnStay.isEnabled()) {
					hand = 1;
					for(int i = 0;i<h.size();i++)
						h.get(i).playerCont = false;
					displayHand();
					try {
						dealerAi();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnStay.setBounds(0, 50, 107, 25);
		panel.add(btnStay);

		btnDoubleDown = new JButton("Double Down");
		btnDoubleDown.setEnabled(false);
		btnDoubleDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnDoubleDown.setBounds(0, 75, 107, 25);
		panel.add(btnDoubleDown);

		btnSplit = new JButton("Split");
		btnSplit.setEnabled(false);
		btnSplit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnSplit.isEnabled()) {

					h.add(h.get(0).Split());

					displayHand();
				}
			}
		});
		btnSplit.setBounds(0, 100, 107, 25);
		panel.add(btnSplit);

		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnStart.isEnabled()) {
					try {
						d = new DeckOfCards(Integer.parseInt(txtDeckinput.getText()));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					h.add(new Hand(d, true, "You"));
					h.get(0).draw(2);
					h.add(new Hand(d, false, "Dealer"));
					h.get(1).draw(2);
					h.get(1).get(1).flip();
					btnStart.setEnabled(false);
					txtDeckinput.setEnabled(false);
					for(int i = 0;i<btn.size();i++){
						btn.get(i).setEnabled(false);
					}

					displayHand();
					for(int i = 0;i<btn.size();i++)
						btn.get(i).setEnabled(true);
				}
			}
		});
		btnStart.setEnabled(false);
		btnStart.setBounds(0, 295, 97, 25);
		panel.add(btnStart);

		txtDeckinput = new JTextField();
		txtDeckinput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				btnStart.setEnabled(true);
				try{
					int i =Integer.parseInt(txtDeckinput.getText());
				}catch(Exception ex) {
					btnStart.setEnabled(false);
				}

			}
		});
		txtDeckinput.setText("Number of Decks");
		txtDeckinput.setBounds(0, 263, 107, 22);
		panel.add(txtDeckinput);
		txtDeckinput.setColumns(10);

		btnPre = new JButton("<-");
		btnPre.setEnabled(false);
		btnPre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnPre.isEnabled()) {
					if(hand > 0) 
						hand--;
					else
						hand = h.size()-1;
					displayHand();
				}
			}

		});
		btnPre.setBounds(0, 943, 47, 25);
		panel.add(btnPre);

		btnNex = new JButton("->");
		btnNex.setEnabled(false);
		btnNex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnNex.isEnabled()) {
					if(hand< h.size()-1)
						hand++;
					else
						hand = 0;
					displayHand();
				}
			}
		});
		btnNex.setBounds(52, 943, 47, 25);
		panel.add(btnNex);
		btn = new ArrayList<JButton>();
		btn.add(btnDoubleDown);
		btn.add(btnBuy);
		btn.add(btnStay);
		btn.add(btnNex);
		btn.add(btnPre);

		lblPlayer = new JLabel("You");
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlayer.setBounds(0, 0, 193, 16);
		panel.add(lblPlayer);
		
		btnNextGame = new JButton("Next Game");
		btnNextGame.setEnabled(false);
		btnNextGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnNextGame.isEnabled())
				Cleanup();
			}
		});
		btnNextGame.setBounds(0, 916, 97, 25);
		panel.add(btnNextGame);

	}
	private void displayHand() {
		
		try {
			if(h.get(hand).get(0).val() == h.get(hand).get(1).val()&&h.get(0).numCards()==2&&h.get(hand).playerCont) {
				btnSplit.setEnabled(true);
			}else
				btnSplit.setEnabled(false);
		}catch(Exception e) {
			btnSplit.setEnabled(false);
		}
		for(int i = 0;i< h.get(hand).numCards();i++)
			ls.get(i).setIcon(h.get(hand).get(i).GetCard());
		for(int i = ls.size()-1;i>h.get(hand).numCards()-1;i--)
			ls.get(i).setIcon(null);
		lblPlayer.setText(h.get(hand).name()+": Hand Value "+ h.get(hand).hValue() +h.get(hand).endGame);
		if(h.get(hand).playerCont) {
			for(int i = 0;i<3;i++)
				btn.get(i).setEnabled(true);
		}else {
			for(int i = 0;i<3;i++)
				btn.get(i).setEnabled(false);
		}
		if(h.get(hand).hValue()>20)
			btnBuy.setEnabled(false);

	}
	private void CheckScore() {
		Hand dHand = h.get(1);
		for(int i = 0; i<h.size();i++) {
			if(i!=1)
			if(h.get(i).hValue()>21)
				h.get(i).endGame = " BUST!";
			else if(h.get(i).hValue()==dHand.hValue())
				h.get(i).endGame =" PUSH!";
			else if(h.get(i).hValue()==21)
				h.get(i).endGame =" BLACKJACK!";
			else if(h.get(i).hValue()>dHand.hValue()||dHand.hValue()>21)
				h.get(i).endGame =" WIN!";
			else
				h.get(i).endGame =" LOSS!";
			
		}
		
	}
	private void dealerAi() throws InterruptedException {
		boolean stop = false;
		h.get(1).get(1).flip();
		while(!stop) {
			if(h.get(1).hValue()==21) {
				stop = true;
				break;
			}else if(h.get(1).hValue()<17) {
				h.get(1).draw(1);
				displayHand();
			}else if(h.get(1).hValue()>21) {
				stop = true;
				break;
			}else if(Hand.max>=h.get(1).hValue()) {
				h.get(1).draw(1);
				displayHand();
			}else if(h.get(1).hValue()>21) {
				stop = true;
				break;
			}else {
				stop = true;
			}
		}
		CheckScore();
		displayHand();
		btnNextGame.setEnabled(true);
		
	}

	private void Cleanup() {
		for(int i = 0;i<h.size();i++)
			h.get(i).endGame = "";
		h.get(0).playerCont = true;
		hand = 0;
		for(int i = 0; i<h.size();i++) { 
			d.dis(h.get(i).getAll());
			h.get(i).clear();
		}
		for(int i = 0;i<9;i++) 
			ls.get(i).setIcon(null);
		for(int i = 0;i<3;i++){
			btn.get(i).setEnabled(false);
		}
		for(int i = 2; i<h.size();i++)
				h.remove(i);
		for(int i = 0;i<d.getDeck().size();i++)
			d.getDeck().get(i).up();
		h.get(0).draw(2);
		h.get(1).draw(2);
		h.get(1).get(1).flip();
		displayHand();
		btnNextGame.setEnabled(false);

	}
}
