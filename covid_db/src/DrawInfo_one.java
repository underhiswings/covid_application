import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Choice;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DrawInfo_one extends JPanel {
	
	DBdata db = new DBdata();


	int[] confirmedCaseTotal = null;
	String[] district = null; 
	int[] size = null; // length of rectangle
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		System.out.println("2");
		
		setGraph();				
		
		super.paintComponent(g);
		
		Font font = new Font("Dialog", Font.BOLD, 9);
		g.setFont(font);
		
		int x = 15;
		for(int i=0;i<district.length;i++) {
			g.setColor(Color.blue);
			g.fillRect(x, 300 - (size[i]*10), 30, size[i]*10);			
			x+=37;
		}	
		
		int set = 15;
		for(int i = 0; i < district.length; i++){
			g.setColor(Color.black);
			g.drawString(district[i],set,320);
			set += 37;
		}		
		// determine longest bar	
	}
	
	public void setGraph() {
		//get info from DB
		confirmedCaseTotal = db.getCCTotalFromArea();
		district = db.getDistrictFromArea();
		
		// get size of each rectangle
		size = new int[district.length];
		for(int i=0;i<district.length;i++) {
			if(confirmedCaseTotal[i]<10) size[i] = 1;
			else {
				size[i] = confirmedCaseTotal[i]/10;
			}
		}
	}
	
}

