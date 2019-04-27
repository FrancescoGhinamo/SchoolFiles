package countDown.frontend.gui;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class CountDownDialog extends JDialog {

	
	private static final long serialVersionUID = -513812846971842012L;
	
	private CountDownDial dial;
	
	public CountDownDialog(JFrame owner, boolean modale, int startVal) {
		super(owner, "Conto alla rovescia", modale);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		dial = new CountDownDial(startVal, this.getContentPane());
		add(dial);
		setSize(new Dimension(400, 400));
		new Thread(dial).start();
		
	}
	
	public void dispose() {
		super.dispose();
		dial.setStopped(true);
	}
	
	

}
