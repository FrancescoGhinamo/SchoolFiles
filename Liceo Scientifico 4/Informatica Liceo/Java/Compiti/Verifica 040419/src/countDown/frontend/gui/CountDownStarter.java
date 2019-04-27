package countDown.frontend.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CountDownStarter extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1168148184576501386L;
	
	private JTextField txtSec;
	private JButton btnStart;
	
	public CountDownStarter() {
		super("Conto alla rovescia");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
		pack();
	}

	private void initComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(5, 10, 5, 10);
		gbc.weighty = 2;
		gbc.gridy = 0;
		
		gbc.gridx = 0;
		gbc.weightx = 5;
		add(new JLabel("Durata: "));
		
		gbc.gridx = 1;
		gbc.weightx = 15;
		add(txtSec = new JTextField(20));
		
		gbc.gridx = 2;
		gbc.weightx = 5;
		btnStart = new JButton("Avvia");
		btnStart.addActionListener(this);
		add(btnStart, gbc);
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnStart)) {
			try {
				new CountDownDialog(this, true, Integer.parseInt(txtSec.getText())).setVisible(true);;
				
			}
			catch(NumberFormatException exc) {}
			txtSec.setText("");
			
		}

	}

	public static void main(String[] args) {
		new CountDownStarter().setVisible(true);

	}

}
