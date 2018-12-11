package liceocuneo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * La classe ScuolaGUI è una finestra
 * i pulsanti della finestra li fa uscire Windows in automatico, come il cambio del focus con tab
 * 
 * la classe è ascoltatore di azioni (ActionListener), ascolta gli eventi
 * quando si verifica un evento su un oggetto grafico, viene chamato in automatico il metodo actionPerformed
 * @author Francesco
 *
 */
public class ScuolaGUI extends JFrame implements ActionListener {
	
	
	private static final long serialVersionUID = 1L;
	//gli oggetti grafici possono essere attributi della classe
	private JTextField txtCognome;
	private JTextField txtNome;
	private JButton btnAggiungi;
	private JButton btnVisualizza;
	
	public ScuolaGUI() {
		setTitle("Gestione scuola");
		setSize(800, 600);
		initComponents();
	}
	
	/**
	 * Inizializzatore per componeneti grafici
	 */
	public void initComponents() {
		//nelle interfacce grafiche si inseriscono oggetti
		txtCognome = new JTextField(20);
		txtNome = new JTextField(20);
		btnAggiungi = new JButton("Aggiungi studente");
		//aggiungo l'ascolatatore di eventi
		btnAggiungi.addActionListener(this);
		btnVisualizza = new JButton("Visualizza elenco studenti");
		btnVisualizza.addActionListener(this);
		//i componenti devono essere aggiunti con una struttura grafica (Layout)
		//add(txtCognome);
		
		//imposto il tipo di layout
		setLayout(new FlowLayout());
		add(txtCognome);
		add(txtNome);
		add(btnAggiungi);
		add(btnVisualizza);

		
	}
	
	
	@Override
	/**
	 * Esegue un azione con evento d'azione come parametro
	 */
	public void actionPerformed(ActionEvent e) {
		//controlla la sorgente dell'evento tramite l'istanza dell'evento che l'ha generato
		if(e.getSource().equals(btnAggiungi)) {
			
		}
		else if(e.getSource().equals(btnVisualizza)) {
			
		}
	}
	
	public static void main(String[] args) {
		ScuolaGUI s = new ScuolaGUI();
		s.setVisible(true);
	}

	

}
