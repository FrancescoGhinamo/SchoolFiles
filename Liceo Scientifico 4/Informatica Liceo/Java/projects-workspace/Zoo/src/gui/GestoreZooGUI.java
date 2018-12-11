package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import animali.Animale;
import animali.TipoAnimale;
import animali.TipoPelo;
import gestione.GestoreZoo;

public class GestoreZooGUI extends JFrame implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;

	private GestoreZoo gestore;
	
	private JLabel lblTipoAnimale;
	private JComboBox<String> cmbTipoAnimale;
	
	private JLabel lblGabbia;
	private JComboBox<String> cmbGabbia;
	
	private JLabel lblNome;
	private JTextField txtNome;
	
	private JLabel lblMatricola;
	private JTextField txtMatricola;
	
	private JLabel lblNascita;
	private JTextField txtNascita;
	
	private JLabel lblArrivo;
	private JTextField txtArrivo;
	
	private JLabel lblPeso;
	private JTextField txtPeso;
	
	private JLabel lblPelo;
	private JComboBox<String> cmbPelo;
	
	private JButton btnAggiungi;
	private JButton btnVisualizza;
	
	
	
	
	
	private JLabel lblGabbiaNuova;
	private JTextField txtGabbiaNuova;
	private JButton btnGabbia;
	
	
	
	
	
	private DefaultListModel<String> listModel;
	private JList<String> anList;
	
	private ArrayList<Animale> _animali;
	
	
	private JTextArea genOut;
	
	public GestoreZooGUI() {
		super("Gestione zoo");
		gestore = new GestoreZoo();
		_animali = new ArrayList<Animale>();
		setExtendedState(MAXIMIZED_BOTH);
		initComponents();
		addWindowListener(new WinMan());
	}
	
	public void initComponents() {
		lblTipoAnimale = new JLabel("TipoAnimale: ");
		cmbTipoAnimale = new JComboBox<String>();
		cmbTipoAnimale.addItem("Tigre");
		cmbTipoAnimale.addItem("Gorilla");
		cmbTipoAnimale.addItem("Pinguino");
		
		lblGabbia = new JLabel("Gabbia");
		cmbGabbia = new JComboBox<String>();
		cmbGabbia.addItem("<default>");
		gestore.aggiungiGabbia("<default>");
		
		
		lblNome = new JLabel("Nome: ");
		txtNome = new JTextField(20);
		
		lblMatricola = new JLabel("Matricola: ");
		txtMatricola = new JTextField(20);
		
		lblNascita = new JLabel("Data di nascita: ");
		txtNascita = new JTextField(20);
		
		lblArrivo = new JLabel("Data di arrivo: ");
		txtArrivo = new JTextField(20);		
		
		lblPeso = new JLabel("Peso [kg]: ");
		txtPeso = new JTextField(20);
		
		lblPelo = new JLabel("Tipo pelo: ");
		cmbPelo = new JComboBox<String>();
		cmbPelo.addItem("Raso");
		cmbPelo.addItem("Lungo");
		cmbPelo.addItem("Corto");
		
		btnAggiungi = new JButton("Registra animale");
		btnAggiungi.addActionListener(this);
		btnVisualizza = new JButton("Visualizza zoo");
		btnVisualizza.addActionListener(this);
		
		JPanel animalePan = new JPanel(new GridLayout(9, 2));
		animalePan.add(lblTipoAnimale);
		animalePan.add(cmbTipoAnimale);
		animalePan.add(lblGabbia);
		animalePan.add(cmbGabbia);
		animalePan.add(lblNome);
		animalePan.add(txtNome);
		animalePan.add(lblMatricola);
		animalePan.add(txtMatricola);
		animalePan.add(lblNascita);
		animalePan.add(txtNascita);
		animalePan.add(lblArrivo);
		animalePan.add(txtArrivo);
		animalePan.add(lblPeso);
		animalePan.add(txtPeso);
		animalePan.add(lblPelo);
		animalePan.add(cmbPelo);
		animalePan.add(btnAggiungi);
		animalePan.add(btnVisualizza);
		
		
		
		
		
		
		lblGabbiaNuova = new JLabel("Codice nuova gabbia");
		txtGabbiaNuova = new JTextField(20);
		btnGabbia = new JButton("Registra gabbia");
		btnGabbia.addActionListener(this);
		
		JPanel gabbiaPan = new JPanel(new FlowLayout());
		gabbiaPan.add(lblGabbiaNuova);
		gabbiaPan.add(txtGabbiaNuova);
		gabbiaPan.add(btnGabbia);
		
		
		listModel = new DefaultListModel<String>();
		anList = new JList<String>(listModel);
		anList.setToolTipText("Animali presenti nello zoo");
		anList.addListSelectionListener(this);
		JScrollPane listPane = new JScrollPane(anList);
		
		
		
		genOut = new JTextArea(20, 40);
		genOut.setEditable(false);
		genOut.setToolTipText("Descrizione dei singoli animali o dello zoo");
		JScrollPane outPane = new JScrollPane(genOut);
		
		setLayout(new BorderLayout());
		add(animalePan, "North");
		add(gabbiaPan, "East");
		add(listPane, "Center");
		add(outPane, "South");
	}
	
	public void parseAggiungiGabbia() {
		String nome = txtGabbiaNuova.getText();
		gestore.aggiungiGabbia(nome);
		cmbGabbia.addItem(nome);
	}
	
	public void parseAggiungiAnimale() throws NumberFormatException, ParseException {
		Animale an = null;
		TipoAnimale tipo = null;
		TipoPelo pelo = null;
		if(cmbTipoAnimale.getSelectedItem().equals("Tigre")) {
			tipo = TipoAnimale.TIGRE;
		}
		else if(cmbTipoAnimale.getSelectedItem().equals("Gorilla")) {
			tipo = TipoAnimale.GORILLA;
		}
		else if(cmbTipoAnimale.getSelectedItem().equals("Pinguino")) {
			tipo = TipoAnimale.PINGUINO;
		}
		
		if(cmbPelo.getSelectedItem().equals("Raso")) {
			pelo = TipoPelo.RASO;
		}
		else if(cmbPelo.getSelectedItem().equals("Lungo")) {
			pelo = TipoPelo.LUNGO;
		}
		else if(cmbPelo.getSelectedItem().equals("Corto")) {
			pelo = TipoPelo.CORTO;
		}
		
		an = gestore.creaAnimale(tipo, txtNome.getText(), txtMatricola.getText(), txtNascita.getText(), txtArrivo.getText(), Float.parseFloat(txtPeso.getText()), pelo);
		gestore.aggiungiAnimale((String) cmbGabbia.getSelectedItem(), tipo, txtNome.getText(), txtMatricola.getText(), txtNascita.getText(), txtArrivo.getText(), Float.parseFloat(txtPeso.getText()), pelo);
		listModel.addElement("Animale: "+an.getNome());
		_animali.add(an);
		
	}
	
	public void parseVisualizza() {
		genOut.setText(gestore.datiZoo());
	}
	
	
	
	public void parseSelezione() {
		genOut.setText(_animali.get(anList.getSelectedIndex()).toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAggiungi)) {
			try {
				this.parseAggiungiAnimale();
			} catch (NumberFormatException | ParseException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			}
			
			txtNome.setText("");
			txtMatricola.setText("");
			txtNascita.setText("");
			txtArrivo.setText("");
			txtPeso.setText("");
			
		}
		else if(e.getSource().equals(btnVisualizza)) {
			this.parseVisualizza();
		}
		else if(e.getSource().equals(btnGabbia)) {
			this.parseAggiungiGabbia();
			txtGabbiaNuova.setText("");
		}
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource().equals(anList)) {
			this.parseSelezione();
		}
	}
	
	public static void main(String[] args) {
		GestoreZooGUI g = new GestoreZooGUI();
//		g.setResizable(false);
		g.setVisible(true);

	}

	

}
