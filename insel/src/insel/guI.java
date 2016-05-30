package insel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class guI {

	private JFrame frame;
	private JTextField textField;
	public static JLabel lblError;
	public static JLabel lblOptimaleSchritte;
	public static JLabel lblDieZahlIst;
	public static JLabel lblDerzeitigeSchrittanzahl;
	public static JLabel lblIhrTipp;
	static String Überprüfen ="";
	static int Tipp =0;
	static int Range = 1000;
	static int Schrittanzahl = 0;
	static int Schritte = Schritte(Range);
	static int Random = Randomzahl(Range);
	
	public static JLabel getLblDerzeitigeSchrittanzahl() {
		return lblDerzeitigeSchrittanzahl;
	}
    public static void setLblDerzeitigeSchrittanzahl(JLabel lblDerzeitigeSchrittanzahl) {
		guI.lblDerzeitigeSchrittanzahl = lblDerzeitigeSchrittanzahl;
	}
    public static JLabel getLblDieZahlIst() {
		return lblDieZahlIst;
	}
    public static void setLblDieZahlIst(JLabel lblDieZahlIst) {
		guI.lblDieZahlIst = lblDieZahlIst;
	}
    public static JLabel getLblOptimaleSchritte() {
		return lblOptimaleSchritte;
	}
    public static void setLblOptimaleSchritte(JLabel lblOptimaleSchritte) {
		guI.lblOptimaleSchritte = lblOptimaleSchritte;
	}
	public static JLabel getLblIhrTipp() {
		return lblIhrTipp;
	}
    public static void setLblIhrTipp(JLabel lblIhrTipp) {
		guI.lblIhrTipp = lblIhrTipp;
	}
    public JLabel getLblErrer() {
		return lblError;
	}
    public static void setLblErr0r(JLabel lblError) {
		guI.lblError = lblError;
	}
	public int getSchrittanzahl() {
		return Schrittanzahl;
	}
    public void setSchrittanzahl(int schrittanzahl) {
		Schrittanzahl = schrittanzahl;
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guI window = new guI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public guI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 194);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblErratenSie = new JLabel("Erraten sie eine zahl zwischen 0 und 1000");
		lblErratenSie.setBounds(12, 22, 354, 14);
		frame.getContentPane().add(lblErratenSie);
		
		textField = new JTextField();
		textField.setBounds(108, 47, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
	    lblIhrTipp = new JLabel("Ihr Tipp:");
		lblIhrTipp.setBounds(28, 50, 70, 14);
		frame.getContentPane().add(lblIhrTipp);
		
		lblError = new JLabel("");
		lblError.setBounds(228, 50, 196, 14);
		frame.getContentPane().add(lblError);
		
		lblOptimaleSchritte = new JLabel("Optimale Schrite:");
		lblOptimaleSchritte.setBounds(12, 102, 146, 14);
		frame.getContentPane().add(lblOptimaleSchritte);
		
		lblDerzeitigeSchrittanzahl = new JLabel("Derzeitige Schrittanzahl: "+Schrittanzahl);
		lblDerzeitigeSchrittanzahl.setBounds(168, 102, 223, 14);
		frame.getContentPane().add(lblDerzeitigeSchrittanzahl);
		
	    lblDieZahlIst = new JLabel("Die Zahl ist:");
		lblDieZahlIst.setBounds(28, 77, 124, 14);
		frame.getContentPane().add(lblDieZahlIst);
		
		JButton btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				try
				{Tipp = Integer.parseInt(textField.getText());
				Schrittanzahl++;
				lblError.setText("");
				}
				catch(Exception e)
				{
					lblError.setText("Es muss eine Zahl sein");
				}
				lblDieZahlIst.setText("Die Zahl ist: "+ Vergleichen(Random,Tipp));
				lblOptimaleSchritte.setText("Optimale Schrite:"+Schritte(Range));
				
				lblDerzeitigeSchrittanzahl.setText("Derzeitige Schrittanzahl: "+Schrittanzahl);}
		});
		btnSet.setBounds(277, 73, 89, 23);
		frame.getContentPane().add(btnSet);
	}
	public static int Randomzahl(int a)
	{
		Random rand = new Random();
		int zahl = rand.nextInt(a)+1;

		return zahl;

	}
	public static String Vergleichen(int Rand,int Geraten)
	{
		String a="";
		if(Rand<Geraten)a="kleiner";
		if(Rand>Geraten)a="größer";
		else if(Rand == Geraten)a="Treffer";
		return a;
	}
	public static int Schritte(int Range)
	{
		double Rang=Range;
		int anzahl =((int) Math.log(Rang))+1;
		System.out.println(anzahl);
		return anzahl;
	}
}


