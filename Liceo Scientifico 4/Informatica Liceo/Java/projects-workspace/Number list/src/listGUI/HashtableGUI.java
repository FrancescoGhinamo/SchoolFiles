package listGUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import lists.HashtableList;

public class HashtableGUI extends JFrame implements ActionListener, WindowListener {


	private static final long serialVersionUID = -3654938971522214425L;

	private HashtableList list;
	
	private JTextField txtNum;
	private JButton btnSubmit;
	private JButton btnShow;
	private JTextField txtOut;
	
	public HashtableGUI() {
		super("Number hashtable");
		list = new HashtableList();
		setSize(324, 164);
		addWindowListener(this);
		initComponents();
	}
	
	
	public void initComponents() {
		txtNum = new JTextField(10);
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnShow  = new JButton("Show numbers");
		btnShow.addActionListener(this);
		txtOut = new JTextField(30);
		
		
		setLayout(new FlowLayout());
		
		add(txtNum);
		add(btnSubmit);
		add(btnShow);
		add(txtOut);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnSubmit)) {
			list.put(Integer.parseInt(txtNum.getText()));
			txtNum.setText("");
		}
		else if(e.getSource().equals(btnShow)) {
			txtOut.setText(list.getElements());
//			System.out.println(this.getWidth()+" "+this.getHeight());
		}
		
	}

	public static void main(String[] args) {
		HashtableGUI gui = new HashtableGUI();
		gui.setVisible(true);

	}


	@Override
	public void windowActivated(WindowEvent arg0) {}


	@Override
	public void windowClosed(WindowEvent arg0) {}


	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}


	@Override
	public void windowDeactivated(WindowEvent arg0) {}


	@Override
	public void windowDeiconified(WindowEvent arg0) {}


	@Override
	public void windowIconified(WindowEvent arg0) {}


	@Override
	public void windowOpened(WindowEvent arg0) {}




}
