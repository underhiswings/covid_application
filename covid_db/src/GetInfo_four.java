import java.awt.FlowLayout; 
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.*;
import javax.swing.event.*;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;


class GetInfo_four extends JFrame implements ActionListener{
	JFrame frame = new JFrame();
	JPanel getinfoPanel = new JPanel();
	
	JLabel steps = new JLabel("Step 4/4");
	JLabel question;
	JLabel none;   // can be removed just for checking 
	static JCheckBox[] symptomlist = new JCheckBox[6];

	JButton next;
	
	GetInfo_four(JFrame frame){
		
		this.frame = frame;
		
		//setting panel
		getinfoPanel.setLayout(null);
		getinfoPanel.setBackground(Color.white);
		getinfoPanel.setSize(new Dimension(1000,500));
		
		question = new JLabel("Please check applicable boxes for the symptoms");
		question.setBounds(50,80,400,20);
		steps.setBounds(10, 10, 150, 50);

		
		getinfoPanel.add(steps);
		getinfoPanel.add(question);		
		
		String[] symptoms= {"Dry Cough", "Fever", "Headaches", "Sore throat", "Fatigue", "Diarrhea"};
		
		int y = 100;
		
		for(int i=0; i<symptomlist.length; i++){
			symptomlist[i] = new JCheckBox(symptoms[i]);
			symptomlist[i].addItemListener(new MyItemListener());
			symptomlist[i].setBounds(100,y,350,20);
			y += 20;
			getinfoPanel.add(symptomlist[i]);
		}
		
		//none = new JLabel("your current score is 0");
		//none.setBounds(100,y+20,300,20);
		//getinfoPanel.add(none);	
		
		next = new JButton("next");
		next.setBounds(400,400,80,30);
		next.addActionListener(this);
		getinfoPanel.add(next);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(getinfoPanel);
		//frame.setResizable(false);
		//frame.setSize(500,500);
		//frame.setVisible(true);
	}
	class MyItemListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			int select = 1;
			int amount = 0;
			
			if(e.getStateChange() == ItemEvent.SELECTED) {
				select = 1;	// increment upon selection
			}
			else {
				select = -1; // decrement upon no selection
			}
			for(int i=0; i<symptomlist.length; i++) {
				if(e.getItem() == symptomlist[i]) {
					amount += select;
				}
			}
			
			MainPanel.s += amount;
			System.out.println("Score in step 4 : " + amount);


			//JLabel label2 = new JLabel();
			//none.setText("your current score is " + MainPanel.s);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(next)) {
			System.out.println("Total Score : " + MainPanel.s);
			getinfoPanel.setVisible(false);
			//frame.setVisible(false);
			new GetResult(frame);
		}
	}
}











