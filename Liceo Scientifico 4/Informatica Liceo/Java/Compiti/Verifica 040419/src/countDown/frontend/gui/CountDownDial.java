package countDown.frontend.gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class CountDownDial extends JLabel implements Runnable {

	
	private static final long serialVersionUID = 1298416119276393118L;
	
	private int _val;
	
	private Container owner;
	
	private boolean stopped;
	
	

	public CountDownDial(int _val, Container owner) {
		super();
		this._val = _val;
		this.owner = owner;
		this.stopped = false;
		this.setFont(new Font("Calibri", Font.BOLD, 80));
	}



	public void paintComponent(Graphics g) {
		int diametro = owner.getWidth();
		if(diametro > owner.getHeight()) {
			diametro = owner.getHeight();
		}
		
		int centerX = (getWidth() - diametro) / 2;
		int centerY = (getHeight() - diametro) / 2;
		g.drawString(String.valueOf(_val), centerX + diametro / 2 - 20, centerY + diametro / 2 + 20);
		
		g.drawOval(centerX, centerY, diametro, diametro);
		
	}


	
	@Override
	public void run() {
		while(_val >= 0 && !stopped) {
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(this.isVisible()) {
				_val--;
			}
			
		}
		
	}



	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

	
}
