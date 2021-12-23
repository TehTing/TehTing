import java.awt.*;
import javax.swing.*;

public class Basic extends JFrame{
	setTitle("繪製圖形");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(640, 480);
	
	
	/*迎賓訊息*/
	Frame welcome = new Frame();
	welcome.setVisible(true);
	JOptionPane.showMessageDialog(welcome,"welcome","訊息", JOptionPane.PLAIN_MESSAGE);
	
	
	/* 建立工具列 */
	JPanel tools = new JPanel();
	add(tools, BorderLayout.NORTH);
	
	
	/* 建立繪圖工具 */
	JLabel lbkind = new JLabel("繪圖工具");
	String[] kind = {"筆刷","直線","橢圓形","矩形"};
	JComboBox<String> combo = new JComboBox<>(kind);
	// 建立Listener
	combo.addItemListener(		
		new  ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					System.out.println("選擇 " + kind[combo.getSelectedIndex()]);
			}
		}	
	);
	JPanel subjp = new JPanel();	
	subjp.setLayout(new BoxLayout(subjp, BoxLayout.PAGE_AXIS));
	subjp.add(lbkind);
	subjp.add(combo);
	tools.add(subjp);
	
	
	/* 建立筆刷大小 */
	JPanel radiojp = new JPanel();
	JPanel groupjp = new JPanel();
	//radiojp.setLayout(new BoxLayout(radiojp, BoxLayout.PAGE_AXIS));
	radiojp.setLayout(new GridLayout(2,1));
	JLabel lbsize = new JLabel("筆刷大小");
	radiojp.add(lbsize);
	ButtonGroup group = new ButtonGroup();
	JRadioButton[] radio = new JRadioButton[3];
	String[] sizegroup = {"大","中","小"};
	for(int i = 0; i < 3; i++) {
		radio[i] = new JRadioButton(sizegroup[i]);
		group.add(radio[i]);
		groupjp.add(radio[i], new FlowLayout());
		// 建立Listener
		radio[i].addItemListener(new RadioButtonHandler(sizegroup[i]));
	}
	radiojp.add(groupjp);
	tools.add(radiojp);
	
	
	/* 建立填滿選項 */
	JPanel checkjp = new JPanel();
	checkjp.setLayout(new BoxLayout(checkjp, BoxLayout.PAGE_AXIS));
	JLabel lbfill = new JLabel("筆刷大小");
	checkjp.add(lbfill);
	JCheckBox check = new JCheckBox("填滿");
	// 建立Listener
	CheckBoxHandler checkBoxHandler= new CheckBoxHandler();
	check.addItemListener(checkBoxHandler);
	checkjp.add(check);
	tools.add(checkjp);
	
	
	/* 建立按鈕 */
	JButton color = new JButton("筆刷顏色");
	JButton clean = new JButton("清除畫面");
	// 建立Listener
	color.addActionListener(new ButtonHandler(color.getText()));
	clean.addActionListener(new ButtonHandler(clean.getText()));
	tools.add(color);
	tools.add(clean);
	
	//	可視為真
	setVisible(true);
	
	/*	指標位置	*/
	/*
	JPanel canvasPnl = new JPanel();
	add(canvasPnl,BorderLayout.CENTER);
	JLabel statusBarLabel = new JLabel();
	MouseHandler mouseHandler = new MouseHandler();
	canvasPnl.addMouseMotionListener(mouseHandler);
	 
	 private class MouseHandler extends MouseAdapter{
		  @Override
		  public void mouseMoved(MouseEvent e) {
		   statusBarLabel.setText((String.format("游標位置 [%d,%d]", e.getX(),e.getY())));
		  }
	 }
	 */
	/*
	JPanel mousejp = new JPanel();
	JLabel position = new JLabel("指標位置：(	,	)");
	MouseHandler mouseHandler = new MouseHandler();
	//	mousejp.addMouseMotionListener(mouseHandler);
	add(mousejp,BorderLayout.CENTER);
	add(position,BorderLayout.SOUTH);		
	setVisible(true);*/
	/*	CheckBoxHandler	*/
	class CheckBoxHandler implements ItemListener{
		  public void itemStateChanged(ItemEvent e) {
		   if(e.getStateChange() == ItemEvent.SELECTED)
			   System.out.println("選擇填滿");
		   else
			   System.out.println("取消填滿");
		  }
	}

	
	/*	RadioButtonHandler	*/
	class RadioButtonHandler implements ItemListener {
		  public String size;
		  public RadioButtonHandler(String size) {
			  this.size = size;
		  }
		  public void itemStateChanged(ItemEvent e) {
			  if(e.getStateChange() == ItemEvent.SELECTED)
				  System.out.printf("選擇  %s 筆刷\r\n", size);
		  }
	}
	
	
	/*	ButtonHandler	*/
	class ButtonHandler implements ActionListener{
		  public String text;
		  public ButtonHandler(String text) {
			  this.text = text;
		  }
		  public void actionPerformed(ActionEvent e) {
			  System.out.printf("點選  %s\r\n",text);
		  }
	}
	
	
	/*	MouseHandler	*/
	/*
	class MouseHandler extends MouseAdapter{
		public void mouseMoved(MouseEvent e) {
			position.setText((String.format("指標位置: (%d,%d)",e.getX() ,e.getY())));
		}                
	}
	public void mouseMoved(MouseEvent e) {
		   statusBarLabel.setText((String.format("游標位置 [%d,%d]", e.getX(),e.getY())));
		  }
		  */
}

public class Main {
	public static void main(String[] args) {
		new Basic();
	}
}
