package clientServer.client.frontend.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import clientServer.client.backend.beam.CSVCommunicator;

public class CSVClientGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -5835991100801909484L;
	
	private JMenuItem itemCarica;
	private JLabel lblStatus;
	
	public CSVClientGUI() {
		super("CSV - client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(600, 400));
		initComponents();
		
	}

	private void initComponents() {
		setJMenuBar(initJMenuBar());
		
		setLayout(new GridBagLayout());
		
		lblStatus = new JLabel("Status...");
		lblStatus.setFont(new Font("Calibri", Font.BOLD, 30));
		
		this.add(lblStatus, new GridBagConstraints());
		
	}
	
	private JMenuBar initJMenuBar() {
		JMenuBar bar = new JMenuBar();
		
		bar.add(initFileMenu());
		
		return bar;
	}
	
	private JMenu initFileMenu() {
		JMenu mnuFile = new JMenu("File");
		
		itemCarica = new JMenuItem("Carica");
		itemCarica.addActionListener(this);
		
		mnuFile.add(itemCarica);
		
		return mnuFile;
	}
	
	private JFileChooser initJFileChooser() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("Comma separated text", "csv"));
		return fc;
	}
	
	public void performLoadFile() {
		try {
			String host = JOptionPane.showInputDialog(this, "Server IP: ", "Connessione", JOptionPane.PLAIN_MESSAGE);
			int port = Integer.valueOf(JOptionPane.showInputDialog(this, "Port", "Connessione", JOptionPane.PLAIN_MESSAGE));
			JFileChooser fc = initJFileChooser();
			if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				
				CSVCommunicator c = new CSVCommunicator(host, port, f);
				lblStatus.setFont(new Font("Calibri", Font.BOLD, 20));
				lblStatus.setText("Invio del file " + f.getAbsolutePath());
				c.start();
				
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(itemCarica)) {
			performLoadFile();
		}

	}

	public static void main(String[] args) {
		new CSVClientGUI().setVisible(true);

	}

}
