package numeriCasuali.frontend.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import numeriCasuali.backend.beam.NumeroCasualeAutogenerato;

public class GeneratoreGUI extends JFrame implements Observer {

	
	private static final long serialVersionUID = -3010212461070569086L;
	
	private NumeroCasualeAutogenerato numero;
	
	private JLabel lblVal;
	private JMenuItem itemStop;
	
	public GeneratoreGUI() {
		super("Numeri casuali");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		initComponents();
		
		numero = new NumeroCasualeAutogenerato();
		numero.addObserver(this);
		new Thread(numero).start();
		
		
	}

	private void initComponents() {
		lblVal = new JLabel();
		lblVal.setFont(new Font("Calibri", Font.BOLD, 80));
		add(lblVal);
		
		setJMenuBar(initMenuBar());
		
	}
	
	private JMenuBar initMenuBar() {
		JMenuBar bar = new JMenuBar();
		
		itemStop = new JMenuItem("Stop");
		itemStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				numero.setStopped(true);
				
			}
			
		});
		
		JMenu mnuGeneratore = new JMenu("Generatore");
		mnuGeneratore.add(itemStop);
		
		bar.add(mnuGeneratore);
		
		return bar;
	}

	public static void main(String[] args) {
		new GeneratoreGUI().setVisible(true);

	}

	@Override
	public void update(Observable o, Object arg) {
		if(o.equals(numero)) {
			int v = (Integer) arg;
			lblVal.setText(String.valueOf(v));
		}
		
	}

}
