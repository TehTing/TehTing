import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Canvaspnl extends JPanel {
	//public JLabel mouselbl;
	public Canvaspnl(){

	this.setBackground(Color.WHITE);
	
	JLabel mouselbl = new JLabel();
	add(mouselbl,BorderLayout.SOUTH);		
	
	addMouseMotionListener(
	    new MouseMotionAdapter() {
		    public void mouseDragged(MouseEvent e) {
		    }
		    public void mouseMoved(MouseEvent e) {
		    	mouselbl.setText((String.format("游標位置 [%d,%d]", e.getX(),e.getY())));
		    }
	    });
	setVisible(true); 
    }
}
