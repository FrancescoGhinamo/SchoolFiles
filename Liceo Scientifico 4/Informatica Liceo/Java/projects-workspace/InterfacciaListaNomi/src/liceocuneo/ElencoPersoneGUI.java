package liceocuneo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ElencoPersoneGUI extends JFrame implements ActionListener {
	
	private JTextField txtNome;
	private JButton btnAdd;
	private JLabel lblNome;
	
	//gestione grafica
	private JList listView;
	//gestione lista
	private DefaultListModel listModel;
	
	private ElencoPersone elenco;
	
	public ElencoPersoneGUI() {
		super("Gestione elenco persone");
		//setta l'estansione con massima larghezza e altezza (a tutto schermo)
		setExtendedState(MAXIMIZED_BOTH);
		elenco = new ElencoPersone();
		initComponents();
	}

	public void initComponents() {
		//pannello per l'inserimento
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		
		txtNome = new JTextField(20);
		lblNome = new JLabel("Immetti il nome: ");
		btnAdd = new JButton("Aggiungi");
		
		btnAdd.addActionListener(this);
		
		//aggiungo elementi al pannello p1
		p1.add(lblNome);
		p1.add(txtNome);
		p1.add(btnAdd);
		
		//aggiungo nelle posizioni del Frame il pannello
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		
		listModel = new DefaultListModel();
		listView = new JList(listModel);
		//pannello con barre di scorrimeto
		JScrollPane sp = new JScrollPane(listView);
		add(sp, BorderLayout.CENTER);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAdd)) {
			Persona p = new Persona(txtNome.getText());
			elenco.aggiungiPersona(p);
//			System.out.println("aggiunta persona "+p.getNome());
			//per agiungere elemento alla JList, devo agire sul DefaultListModel
			listModel.addElement(p);
		}
		
	}
	
	public static void main(String[] args) {
		ElencoPersoneGUI g = new ElencoPersoneGUI();
		g.setVisible(true);

	}

	

}
