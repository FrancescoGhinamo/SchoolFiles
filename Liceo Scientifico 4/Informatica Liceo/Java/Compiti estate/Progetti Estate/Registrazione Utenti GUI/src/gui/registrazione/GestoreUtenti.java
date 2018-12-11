package gui.registrazione;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import gui.visualizzazione.Visualizzatore;
import utente.Utente;

public class GestoreUtenti extends JFrame implements ActionListener {
	
	
	private static final long serialVersionUID = 6153633334580447569L;
	
	private Vector<Utente> utenti;
	
	
	private JPanel mainPanel;
	private JPanel panelCognome;
	private JPanel panelNome;
	private JPanel panelData;
	private JPanel panelIndirizzo;
	private JPanel panelTelefono;
	private JPanel buttonPanel;
	
	private JLabel lblCognome;
	private JLabel lblNome;
	private JLabel lblData;
	private JLabel lblIndirizzo;
	private JLabel lblTelefono;
	
	private JTextArea txtCognome;
	private JTextArea txtNome;
	private JTextArea txtData;
	private JTextArea txtIndirizzo;
	private JTextArea txtTelefono;
	
	private JButton cmdRegistra;
	private JButton cmdVisualizza;
	
	public GestoreUtenti() {
		
		this.utenti = new Vector<Utente>();
		
		mainPanel 		= new JPanel(new FlowLayout());
		panelCognome 	= new JPanel(new FlowLayout());
		panelNome 		= new JPanel(new FlowLayout());
		panelData 		= new JPanel(new FlowLayout());
		panelIndirizzo 	= new JPanel(new FlowLayout());
		panelTelefono 	= new JPanel(new FlowLayout());
		buttonPanel 	= new JPanel(new FlowLayout());
		
		lblCognome 		= new JLabel("Cognome", JLabel.RIGHT);
		lblNome 		= new JLabel("Nome", JLabel.RIGHT);
		lblData 		= new JLabel("Data di nascita", JLabel.RIGHT);
		lblIndirizzo 	= new JLabel("Indirizzo", JLabel.RIGHT);
		lblTelefono 	= new JLabel("Numero di telefono", JLabel.RIGHT);
		
		txtCognome 		= new JTextArea(1, 20);
		txtNome 		= new JTextArea(1, 20);
		txtData			= new JTextArea(1, 20);
		txtIndirizzo 	= new JTextArea(1, 20);
		txtTelefono 	= new JTextArea(1, 20);
		
		cmdRegistra 	= new JButton("Registra utente");
		cmdVisualizza 	= new JButton("Visualizza utenti");
		cmdRegistra.addActionListener(this);
		cmdVisualizza.addActionListener(this);
		
		
		
		
		
		panelCognome.add(lblCognome, JPanel.LEFT_ALIGNMENT);
		panelCognome.add(txtCognome, JPanel.RIGHT_ALIGNMENT);
		
		panelNome.add(lblNome, JPanel.LEFT_ALIGNMENT);
		panelNome.add(txtNome, JPanel.RIGHT_ALIGNMENT);
		
		panelData.add(lblData, JPanel.LEFT_ALIGNMENT);
		panelData.add(txtData, JPanel.RIGHT_ALIGNMENT);
		
		panelIndirizzo.add(lblIndirizzo, JPanel.LEFT_ALIGNMENT);
		panelIndirizzo.add(txtIndirizzo, JPanel.RIGHT_ALIGNMENT);
		
		panelTelefono.add(lblTelefono, JPanel.LEFT_ALIGNMENT);
		panelTelefono.add(txtTelefono, JPanel.RIGHT_ALIGNMENT);
		
		buttonPanel.add(cmdRegistra, JPanel.LEFT_ALIGNMENT);
		buttonPanel.add(cmdVisualizza, JPanel.RIGHT_ALIGNMENT);
		
		mainPanel.add(panelCognome, JPanel.RIGHT_ALIGNMENT);
		mainPanel.add(panelNome, JPanel.RIGHT_ALIGNMENT);
		mainPanel.add(panelData, JPanel.RIGHT_ALIGNMENT);
		mainPanel.add(panelIndirizzo, JPanel.RIGHT_ALIGNMENT);
		mainPanel.add(panelTelefono, JPanel.RIGHT_ALIGNMENT);
		mainPanel.add(buttonPanel, JPanel.CENTER_ALIGNMENT);
		
		this.getContentPane().add(mainPanel);
		this.addWindowListener(new MainWinManager());
		this.setTitle("Gestione utenti");
		this.setSize(350, 250);
		this.setResizable(false);
		
	}
	
	
	public Utente creaUtente() {
		Utente _u = null;
		try {
			SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			GregorianCalendar nascita = new GregorianCalendar();
			nascita.setTime(fmt.parse(txtData.getText()));
			_u = new Utente(txtCognome.getText(), txtNome.getText(), nascita, txtIndirizzo.getText(), txtTelefono.getText());
		}
		catch(Exception e) {
			this.pulisciCampi();
		}
		
		return  _u;
	}

	public void aggiungiUtente(Utente u) {
		utenti.add(u);
		this.pulisciCampi();
	}
	
	public void visualizzaUtenti() {
		Visualizzatore v = new Visualizzatore(utenti);
		v.setVisible(true);
		v.stampaUtenti();
	}
	
	
	public void pulisciCampi() {
		txtCognome.setText("");
		txtNome.setText("");
		txtData.setText("");
		txtIndirizzo.setText("");
		txtTelefono.setText("");
	}
	
	public static void main(String[] args) {
		GestoreUtenti gS = new GestoreUtenti();
		gS.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String source = arg0.getActionCommand();
		if(source.equals("Registra utente")) {
			this.aggiungiUtente(this.creaUtente());
		}
		if(source.equals("Visualizza utenti")) {
			this.visualizzaUtenti();
		}
		
	}

}
