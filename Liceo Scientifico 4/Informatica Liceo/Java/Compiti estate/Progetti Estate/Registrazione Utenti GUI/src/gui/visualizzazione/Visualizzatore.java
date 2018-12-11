package gui.visualizzazione;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import utente.Utente;

public class Visualizzatore extends JFrame implements WindowListener {

	private static final long serialVersionUID = 3819645580714179493L;

	private JPanel outPanel;
	private JTextArea outArea;
	
	private Vector<Utente> toPrint;
	
	public Visualizzatore(Vector<Utente> toPrint)  {
		
		this.toPrint = toPrint;
		
		outPanel = new JPanel();
		outArea = new JTextArea(40, 40);
		outArea.setEditable(false);
		
		outPanel.add(outArea);
		
		this.getContentPane().add(outPanel);
		this.setSize(500, 500);
		this.setResizable(false);
		this.addWindowListener(this);
		
	}
	
	public void stampaUtenti() {
		String uts = outArea.getText();
		for(int i = 0; i < toPrint.size(); i++) {
			uts += toPrint.elementAt(i).toString();
		}
		outArea.setText(uts);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		try {
			this.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		this.setVisible(false);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
