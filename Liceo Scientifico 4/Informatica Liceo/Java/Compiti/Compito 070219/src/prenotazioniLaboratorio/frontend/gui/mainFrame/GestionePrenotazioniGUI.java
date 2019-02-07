package prenotazioniLaboratorio.frontend.gui.mainFrame;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.filechooser.FileNameExtensionFilter;

import prenotazioniLaboratorio.backend.bean.ElencoPrenotazioni;
import prenotazioniLaboratorio.backend.bean.PrenotazioneLaboratorio;

public class GestionePrenotazioniGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -6609203161800904175L;
	
	private JTextField txtClasse;
	private JTextField txtDocente;
	private JSpinner spinData;
	private JTextField txtDurata;
	
	private JButton btnConferma;
	
	private JMenuItem itemSalva;
	private JMenuItem itemApri;
	
	private ElencoPrenotazioni ePren;
	
	public GestionePrenotazioniGUI() {
		super("Gestione prenotazioni");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		pack();
		ePren = new ElencoPrenotazioni();
	}

	public void initComponents() {
		setJMenuBar(initJMenuBar());
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 0;
		gbc.weightx = gbc.weighty = 5;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 5, 5, 5);
		
		add(initDataPanel(), gbc);
		
		gbc.gridy = 1;
		gbc.weighty = 1;
		
		add(initButsPanel(), gbc);
		
	}
	
	private JMenuBar initJMenuBar() {
		JMenuBar bar = new JMenuBar();
		bar.add(initFileJMenu());
		return bar;
	}
	
	private JMenu initFileJMenu() {
		JMenu mnuFile = new JMenu("File");
		
		itemApri = new JMenuItem("Apri");
		itemApri.addActionListener(this);
		
		itemSalva = new JMenuItem("Salva");
		itemSalva.addActionListener(this);
		
		mnuFile.add(itemApri);
		mnuFile.add(itemSalva);
		
		return mnuFile;
	}

	
	
	private JPanel initDataPanel() {
		JPanel pan = new JPanel(new GridLayout(4, 2, 5, 5));
		
		pan.add(new JLabel("Classe"));
		pan.add(txtClasse = new JTextField(20));
		pan.add(new JLabel("Docente"));
		pan.add(txtDocente = new JTextField(20));
		pan.add(new JLabel("Data"));
		
		SpinnerDateModel model = new SpinnerDateModel(new Date(), null, null, GregorianCalendar.DAY_OF_YEAR);
		spinData = new JSpinner(model);
		
		JSpinner.DateEditor dEdit = new JSpinner.DateEditor(spinData, "dd/MM/yyyy");
		dEdit.getTextField().setEditable(false);
		spinData.setEditor(dEdit);
		
		pan.add(spinData);
		
		pan.add(new JLabel("Durata [min]"));
		pan.add(txtDurata = new JTextField(20));
		
		return pan;
	}
	
	private JPanel initButsPanel() {
		JPanel pan = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(this);
		
		pan.add(btnConferma);
		
		return pan;
	}
	
	
	public void performConferma() {
		if(!txtClasse.getText().equals("") && !txtDocente.getText().equals("") && !txtDurata.getText().equals("")) {
			GregorianCalendar data = new GregorianCalendar();
			data.setTime((Date) spinData.getValue());
			int durata = 0;
			try {
				durata = Integer.parseInt(txtDurata.getText());
			}
			catch(NumberFormatException e) {
				
			}
			
			PrenotazioneLaboratorio pren = new PrenotazioneLaboratorio(txtClasse.getText(), txtDocente.getText(), data, durata);
			ePren.add(pren);
			
			txtClasse.setText("");
			txtDocente.setText("");
			spinData.setValue(new Date());
			txtDurata.setText("");
		}
	}
	
	
	
	public JFileChooser initFileChooser() {
		JFileChooser fC = new JFileChooser();
		fC.setFileFilter(new FileNameExtensionFilter("Testo CSV", "csv"));
		return fC;
	}
	
	public void performApri() throws IOException {
		JFileChooser fc = initFileChooser();
		if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				ePren.importaCSV(fc.getSelectedFile());
			} catch (IOException e) {
				throw e;
			}
		}
	}
	
	public void performSalva() throws IOException {
		JFileChooser fc = initFileChooser();
		if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			if(!f.getAbsolutePath().endsWith(".csv")) {
				f = new File(f.getAbsolutePath() + ".csv");
			}
			try {
				ePren.esportaCSV(f);
			} catch (IOException e) {
				throw e;
			}
		}
	}
	
	public void showExceptionMessage(Exception e) {
		JOptionPane.showMessageDialog(this, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
	}
	@Override
	public void actionPerformed(ActionEvent aE) {
		if(aE.getSource().equals(btnConferma)) {
			performConferma();
		}
		else if(aE.getSource().equals(itemApri)) {
			try {
				performApri();
			} catch (IOException e) {
				showExceptionMessage(e);
			}
		}
		else if(aE.getSource().equals(itemSalva)) {
			try {
				performSalva();
			} catch (IOException e) {
				showExceptionMessage(e);
			}
		}

	}

	public static void main(String[] args) {
		GestionePrenotazioniGUI gestGUI = new GestionePrenotazioniGUI();
		gestGUI.setVisible(true);

	}

}
