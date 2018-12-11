package listGUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;


import lists.DynamicNumberList;

public class NumberListGUI extends JFrame implements ActionListener, WindowListener {
	
	
	private static final long serialVersionUID = 6230708802901334802L;

	private DynamicNumberList list;
	
	private JTextField txtNum;
	private JButton btnSubmit;
	private JComboBox<String> cmbSort;
	private JButton btnSort;
	private JButton btnShow;
	private JTextField txtOut;
	
	public NumberListGUI() {
		super("Number list");
		list = new DynamicNumberList();
		setSize(324, 164);
		addWindowListener(this);
		initComponents();
	}
	
	
	public void initComponents() {
		txtNum = new JTextField(10);
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnSort = new JButton("Sort");
		btnSort.addActionListener(this);
		btnShow  = new JButton("Show numbers");
		btnShow.addActionListener(this);
		txtOut = new JTextField(30);
		
		
		cmbSort = new JComboBox<String>();
		cmbSort.addItem("Sort increasing");
		cmbSort.addItem("Sort decreasing");
		
		setLayout(new FlowLayout());
		
		add(txtNum);
		add(btnSubmit);
		add(cmbSort);
		add(btnSort);
		add(btnShow);
		add(txtOut);
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnSubmit)) {
			list.addNumber(Integer.parseInt(txtNum.getText()));
			txtNum.setText("");
		}
		else if(e.getSource().equals(btnSort)) {
			switch(cmbSort.getSelectedItem().toString()) {
			case "Sort increasing":
				list.sortI();
				break;
				
			case "Sort decreasing":
				list.sortD();
				break;
			}
		}
		else if(e.getSource().equals(btnShow)) {
			txtOut.setText(list.toString());
//			System.out.println(this.getWidth()+" "+this.getHeight());
		}
		
	}

	public static void main(String[] args) {
		NumberListGUI gui = new NumberListGUI();
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
