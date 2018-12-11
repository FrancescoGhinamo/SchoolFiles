package euqazione.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import equazione.eccezioni.InserimentoErratoException;
import euqazione.FunzioneLineare;
import euqazione.Punto;

public class EquazioneGUI extends JFrame implements ActionListener {
	
	
	private static final long serialVersionUID = -107540918727634503L;
	
	
	private JTextField txtIn;
	private JButton btnCalcola;
	
	private DefaultListModel<String> listModel;
	private JList<String> listOut;
	
	public EquazioneGUI() {
		super("Equazione lineare");
		setExtendedState(MAXIMIZED_BOTH);
		this.addWindowListener(new WinMan());
		initComponents();
		
	}
	
	public void initComponents() {
		txtIn = new JTextField(20);
		btnCalcola = new JButton("Calcola");
		btnCalcola.addActionListener(this);
		JPanel inP = new JPanel(new FlowLayout());
		inP.add(txtIn);
		inP.add(btnCalcola);
		
		listModel = new DefaultListModel<String>();
		listOut = new JList<String>(listModel);
		listOut.setLayout(new GridLayout(100, 2));
		JScrollPane outP = new JScrollPane(listOut);
		
		setLayout(new BorderLayout());
		
		add(inP, BorderLayout.NORTH);
		add(outP, BorderLayout.CENTER);
		
	}
	
	public void parseCalcola() throws InserimentoErratoException {
		if(!txtIn.getText().equals("")) {
			FunzioneLineare f = new FunzioneLineare(txtIn.getText());
			ArrayList<Punto> punti = f.trovaPunti(100);
			for(Punto p: punti) {
				
				listModel.addElement(String.valueOf(p.getX()) + "                   "
						+ "       " + String.valueOf(p.getY()));
			}
		}
		else {
			throw new InserimentoErratoException();
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnCalcola)) {
			try {
				parseCalcola();
				txtIn.setText("");
			}
			catch(InserimentoErratoException exc) {
				JOptionPane.showMessageDialog(this, exc.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		EquazioneGUI gui = new EquazioneGUI();
		gui.setVisible(true);
	}

}
