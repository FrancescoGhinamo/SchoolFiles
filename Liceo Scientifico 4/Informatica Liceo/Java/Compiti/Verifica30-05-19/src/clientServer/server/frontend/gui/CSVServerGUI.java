package clientServer.server.frontend.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clientServer.server.backend.beam.CSVServer;
import clientServer.server.backend.beam.ClientHandler;

@SuppressWarnings("deprecation")
public class CSVServerGUI extends JFrame implements ActionListener, Observer {

	
	private static final long serialVersionUID = -1432818586050381729L;
	
	private static final String CSV_SEPARATOR = ";";
	
	private static final String[] TABLE_HEADER = {"policyID", "statecode", "county", "eq_site_limit"};
	private DefaultTableModel tblMod;
	
	private JMenuItem itemStartServer;
	
	private CSVServer server;
	
	public CSVServerGUI() {
		super("CSV - server");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}

	private void initComponents() {
		setJMenuBar(initJMenuBar());
		
		setLayout(new BorderLayout());
		
		tblMod = new DefaultTableModel(TABLE_HEADER, 0);
		JTable tbl = new JTable(tblMod);
		JScrollPane scrl = new JScrollPane(tbl);
		
		this.add(scrl, BorderLayout.CENTER);
		
		
	}

	private JMenuBar initJMenuBar() {
		JMenuBar bar = new JMenuBar();
		
		bar.add(initServerMenu());
		
		return bar;
	}
	
	private JMenu initServerMenu() {
		JMenu mnuServer = new JMenu("Server");
		
		itemStartServer = new JMenuItem("Avvia");
		itemStartServer.addActionListener(this);
		
		mnuServer.add(itemStartServer);
		
		return mnuServer;
	}
	
	@Override
	public synchronized void update(Observable o, Object arg) {
		if(o instanceof ClientHandler) {
			String line = (String) arg;
			String[] cont = line.split(CSV_SEPARATOR);
			if(!cont.equals(TABLE_HEADER)) {
				tblMod.addRow(cont);
			}
			
		}

	}
	
	public void performStartServer() {
		try {
			int port = Integer.valueOf(JOptionPane.showInputDialog(this, "Port", "Connessione", JOptionPane.PLAIN_MESSAGE));
			server = new CSVServer(port, this);
			new Thread(server).start();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(itemStartServer)) {
			performStartServer();
		}

	}
	
	
	public static void main(String[] args) {
		new CSVServerGUI().setVisible(true);
	}

}
