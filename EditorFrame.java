package example;

import java.awt.BorderLayout; 
import java.awt.Container; 
import java.awt.Toolkit; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.InputStream; 
import javax.swing.ImageIcon; 
import javax.swing.JButton; 
import javax.swing.JFileChooser; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JMenu; 
import javax.swing.JMenuBar; 
import javax.swing.JMenuItem; 
import javax.swing.JOptionPane; 
import javax.swing.JScrollPane; 
import javax.swing.JTextPane; 
import javax.swing.JToolBar; 
import javax.swing.text.DefaultStyledDocument; 

public class EditorFrame extends JFrame implements ActionListener { 
	/*	定義相關屬性	*/ 
	//private JMenuBar menuBar;	// 頂部菜單欄 
	//private JMenu menuFile, menuEdit, menuAbout;	// 菜單文件、編輯、關於 
	private JMenuItem itemNewFile, itemOpen, itemSave, itemExit, itemCut, itemCopy, itemPaste, itemAbout;	// 菜單項新建、 打開、保存、退出、剪切、複製、粘貼、關於 
	private JToolBar toolBar;	// 工具條 
	// 按鈕新建、 打開、保存、退出、剪切、複製、粘貼、關於 
	private JButton butNewFile, butOpen, butSave, butExit, butCut, butCopy, butPaste, butAbout; 
	private JTextPane textPane;	// 編輯窗口 
	private JLabel label;	// 底部標籤欄 
	private JFileChooser fileChooser;	// 文件選擇器 
	private JScrollPane scrollPane; 
	/* * 構造方法 */ 
	public EditorFrame() { 
		//menuBar = new JMenuBar(); 	// 實例化菜單欄 	
		// 實例化菜單 
		//menuFile = new JMenu("文件"); menuEdit = new JMenu("編輯"); menuAbout = new JMenu("關於"); 
		// 實例化菜單項並添加事件監聽 
		itemNewFile = new JMenuItem("新建"); 
		itemNewFile.addActionListener(this);		// 設置監聽 
		itemNewFile.setActionCommand("newFile"); 
		itemOpen = new JMenuItem("打開"); 
		itemOpen.addActionListener(this);		// 設置監聽 
		itemOpen.setActionCommand("open"); 
		itemSave = new JMenuItem("保存"); 
		itemSave.addActionListener(this);	// 設置監聽 
		itemSave.setActionCommand("save"); 
		itemExit = new JMenuItem("退出"); 
		itemExit.addActionListener(this);	// 設置監聽 
		itemExit.setActionCommand("exit"); 
		itemCut = new JMenuItem("剪切"); 
		itemCut.addActionListener(this);// 設置監聽 
		itemCut.setActionCommand("cut"); 
		itemCopy = new JMenuItem("複製"); 
		itemCopy.addActionListener(this);// 設置監聽 
		itemCopy.setActionCommand("copy"); 
		itemPaste = new JMenuItem("粘貼"); 
		itemPaste.addActionListener(this);// 設置監聽 
		itemPaste.setActionCommand("paste"); 
		itemAbout = new JMenuItem("關於"); 
		itemAbout.addActionListener(this);// 設置監聽 
		itemAbout.setActionCommand("about"); 
		/*
		// 文件設置菜單項 
		menuFile.add(itemNewFile); 
		menuFile.add(itemOpen); 
		menuFile.add(itemExit); 
		menuFile.add(itemSave); 
		// 編輯設置菜單項 
		menuEdit.add(itemCut); 
		menuEdit.add(itemCopy); 
		menuEdit.add(itemPaste); 
		// 關於設置菜單 
		menuAbout.add(itemAbout); 
		// 菜單欄設置菜單 
		menuBar.add(menuFile); 
		menuBar.add(menuEdit); 
		menuBar.add(menuAbout); 
		this.setJMenuBar(menuBar); // 實例化工具條 
		*/
		toolBar = new JToolBar(); 
		// 實例化按鈕 
		butNewFile = new JButton("新建"); 
		butNewFile.addActionListener(this); 
		butNewFile.setActionCommand("newFile"); 
		butOpen = new JButton("打開"); 
		butOpen.addActionListener(this);// 設置監聽 
		butOpen.setActionCommand("open"); 
		butSave = new JButton("保存"); 
		butSave.addActionListener(this);// 設置監聽 
		butSave.setActionCommand("save"); 
		butExit = new JButton("退出"); 
		butExit.addActionListener(this);// 設置監聽 
		butExit.setActionCommand("exit"); 
		butCut = new JButton("剪切"); 
		butCut.addActionListener(this);// 設置監聽 
		butCut.setActionCommand("cut"); 
		butCopy = new JButton("複製"); 
		butCopy.addActionListener(this);// 設置監聽 
		butCopy.setActionCommand("copy"); 
		butPaste = new JButton("粘貼"); 
		butPaste.addActionListener(this);// 設置監聽
		butPaste.setActionCommand("paste"); 
		butAbout = new JButton("關於"); 
		butAbout.addActionListener(this);// 設置監聽 
		butAbout.setActionCommand("about"); 
		// 工具條設置按鈕 toolBar.add(butNewFile); 
		toolBar.add(butOpen); 
		toolBar.add(butSave); 
		toolBar.add(butExit); 
		toolBar.add(butCut); 
		toolBar.add(butCopy); 
		toolBar.add(butPaste); 
		toolBar.add(butAbout); 
		// 實例化編輯窗口 
		textPane = new JTextPane(); 
		label = new JLabel("www.javayihao.top ----by xiaoyuan"); 
		// 實例化文件選擇器 
		fileChooser = new JFileChooser(); 
		// 實例化滾動條 
		scrollPane = new JScrollPane(textPane); 
		// 窗口容器中添加組件（使用邊界布局） 
		Container container = getContentPane(); 
		// 得到容器
		container.add(toolBar, BorderLayout.NORTH); 
		// 增加工具欄 
		container.add(scrollPane, BorderLayout.CENTER); 
		container.add(label, BorderLayout.SOUTH); 
		// 增加狀態欄 
		// 初始化窗口
		this.setTitle("小猿記事本");// 窗口標題 
		this.setSize(600, 300);		// 窗體大小 
		this.setIconImage((new ImageIcon("images/logo.png")).getImage());		// 設置圖標 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 設置可關閉進程 
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;// 獲得屏幕寬度 
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;// 獲得屏幕高度 
		this.setLocation((width - 500) / 2, (height - 400) / 2);// 劇中顯示 
		this.setVisible(true);// 設置窗體可見 
		this.setResizable(true);// 可改變窗體大小 
	} 
	/* * 事件方法 */ 
	@Override 
	public void actionPerformed(ActionEvent e) { 
		if (e.getActionCommand().equals("newFile")) { 
			textPane.setDocument(new DefaultStyledDocument());// 清空文檔 
		} else if (e.getActionCommand().equals("open")) { 
			int i = fileChooser.showOpenDialog(EditorFrame.this); // 顯示打開文件對話框 
			if (i == JFileChooser.APPROVE_OPTION) { // 點擊對話框中打開選項 
				File f = fileChooser.getSelectedFile(); // 得到選擇的文件 
				try { 
					InputStream is = new FileInputStream(f); // 得到文件輸入流 
					textPane.read(is, "d"); // 讀入文件到文本窗格 
				} catch (Exception ex) {
					ex.printStackTrace(); // 輸出出錯信息 
				} 
			} 
		} else if (e.getActionCommand().equals("save")) { 
			int i = fileChooser.showSaveDialog(EditorFrame.this); // 顯示保存文件對話框 
			if (i == JFileChooser.APPROVE_OPTION) { // 點擊對話框中保存按鈕 
				File f = fileChooser.getSelectedFile(); // 得到選擇的文件 
				try {
					FileOutputStream out = new FileOutputStream(f); // 得到文件輸出流 
					out.write(textPane.getText().getBytes()); // 寫出文件 
				} catch (Exception ex) {
					ex.printStackTrace(); // 輸出出錯信息 
				} 
			} 
		} else if (e.getActionCommand().equals("exit")) {
			System.exit(0); 
		} else if (e.getActionCommand().equals("cut")) {
			textPane.cut();// 調用文本剪切方法 
		} else if (e.getActionCommand().equals("copy")) {
			textPane.copy();// 調用複製方法 
		} else if (e.getActionCommand().equals("paste")) {
			textPane.paste();// 調用粘貼方法
		} else if (e.getActionCommand().equals("about")) {
			JOptionPane.showMessageDialog(EditorFrame.this, "www.javayihao.top---簡單的文本編輯器演示"); 
		} 
	} 
}