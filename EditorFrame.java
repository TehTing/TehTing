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
	/*	�w�q�����ݩ�	*/ 
	//private JMenuBar menuBar;	// ��������� 
	//private JMenu menuFile, menuEdit, menuAbout;	// �����B�s��B���� 
	private JMenuItem itemNewFile, itemOpen, itemSave, itemExit, itemCut, itemCopy, itemPaste, itemAbout;	// ��涵�s�ءB ���}�B�O�s�B�h�X�B�Ť��B�ƻs�B�߶K�B���� 
	private JToolBar toolBar;	// �u��� 
	// ���s�s�ءB ���}�B�O�s�B�h�X�B�Ť��B�ƻs�B�߶K�B���� 
	private JButton butNewFile, butOpen, butSave, butExit, butCut, butCopy, butPaste, butAbout; 
	private JTextPane textPane;	// �s�赡�f 
	private JLabel label;	// ���������� 
	private JFileChooser fileChooser;	// ����ܾ� 
	private JScrollPane scrollPane; 
	/* * �c�y��k */ 
	public EditorFrame() { 
		//menuBar = new JMenuBar(); 	// ��ҤƵ���� 	
		// ��ҤƵ�� 
		//menuFile = new JMenu("���"); menuEdit = new JMenu("�s��"); menuAbout = new JMenu("����"); 
		// ��ҤƵ�涵�òK�[�ƥ��ť 
		itemNewFile = new JMenuItem("�s��"); 
		itemNewFile.addActionListener(this);		// �]�m��ť 
		itemNewFile.setActionCommand("newFile"); 
		itemOpen = new JMenuItem("���}"); 
		itemOpen.addActionListener(this);		// �]�m��ť 
		itemOpen.setActionCommand("open"); 
		itemSave = new JMenuItem("�O�s"); 
		itemSave.addActionListener(this);	// �]�m��ť 
		itemSave.setActionCommand("save"); 
		itemExit = new JMenuItem("�h�X"); 
		itemExit.addActionListener(this);	// �]�m��ť 
		itemExit.setActionCommand("exit"); 
		itemCut = new JMenuItem("�Ť�"); 
		itemCut.addActionListener(this);// �]�m��ť 
		itemCut.setActionCommand("cut"); 
		itemCopy = new JMenuItem("�ƻs"); 
		itemCopy.addActionListener(this);// �]�m��ť 
		itemCopy.setActionCommand("copy"); 
		itemPaste = new JMenuItem("�߶K"); 
		itemPaste.addActionListener(this);// �]�m��ť 
		itemPaste.setActionCommand("paste"); 
		itemAbout = new JMenuItem("����"); 
		itemAbout.addActionListener(this);// �]�m��ť 
		itemAbout.setActionCommand("about"); 
		/*
		// ���]�m��涵 
		menuFile.add(itemNewFile); 
		menuFile.add(itemOpen); 
		menuFile.add(itemExit); 
		menuFile.add(itemSave); 
		// �s��]�m��涵 
		menuEdit.add(itemCut); 
		menuEdit.add(itemCopy); 
		menuEdit.add(itemPaste); 
		// ����]�m��� 
		menuAbout.add(itemAbout); 
		// �����]�m��� 
		menuBar.add(menuFile); 
		menuBar.add(menuEdit); 
		menuBar.add(menuAbout); 
		this.setJMenuBar(menuBar); // ��ҤƤu��� 
		*/
		toolBar = new JToolBar(); 
		// ��Ҥƫ��s 
		butNewFile = new JButton("�s��"); 
		butNewFile.addActionListener(this); 
		butNewFile.setActionCommand("newFile"); 
		butOpen = new JButton("���}"); 
		butOpen.addActionListener(this);// �]�m��ť 
		butOpen.setActionCommand("open"); 
		butSave = new JButton("�O�s"); 
		butSave.addActionListener(this);// �]�m��ť 
		butSave.setActionCommand("save"); 
		butExit = new JButton("�h�X"); 
		butExit.addActionListener(this);// �]�m��ť 
		butExit.setActionCommand("exit"); 
		butCut = new JButton("�Ť�"); 
		butCut.addActionListener(this);// �]�m��ť 
		butCut.setActionCommand("cut"); 
		butCopy = new JButton("�ƻs"); 
		butCopy.addActionListener(this);// �]�m��ť 
		butCopy.setActionCommand("copy"); 
		butPaste = new JButton("�߶K"); 
		butPaste.addActionListener(this);// �]�m��ť
		butPaste.setActionCommand("paste"); 
		butAbout = new JButton("����"); 
		butAbout.addActionListener(this);// �]�m��ť 
		butAbout.setActionCommand("about"); 
		// �u����]�m���s toolBar.add(butNewFile); 
		toolBar.add(butOpen); 
		toolBar.add(butSave); 
		toolBar.add(butExit); 
		toolBar.add(butCut); 
		toolBar.add(butCopy); 
		toolBar.add(butPaste); 
		toolBar.add(butAbout); 
		// ��Ҥƽs�赡�f 
		textPane = new JTextPane(); 
		label = new JLabel("www.javayihao.top ----by xiaoyuan"); 
		// ��ҤƤ���ܾ� 
		fileChooser = new JFileChooser(); 
		// ��Ҥƺu�ʱ� 
		scrollPane = new JScrollPane(textPane); 
		// ���f�e�����K�[�ե�]�ϥ���ɥ����^ 
		Container container = getContentPane(); 
		// �o��e��
		container.add(toolBar, BorderLayout.NORTH); 
		// �W�[�u���� 
		container.add(scrollPane, BorderLayout.CENTER); 
		container.add(label, BorderLayout.SOUTH); 
		// �W�[���A�� 
		// ��l�Ƶ��f
		this.setTitle("�p��O�ƥ�");// ���f���D 
		this.setSize(600, 300);		// ����j�p 
		this.setIconImage((new ImageIcon("images/logo.png")).getImage());		// �]�m�ϼ� 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �]�m�i�����i�{ 
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;// ��o�̹��e�� 
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;// ��o�̹����� 
		this.setLocation((width - 500) / 2, (height - 400) / 2);// �@����� 
		this.setVisible(true);// �]�m����i�� 
		this.setResizable(true);// �i���ܵ���j�p 
	} 
	/* * �ƥ��k */ 
	@Override 
	public void actionPerformed(ActionEvent e) { 
		if (e.getActionCommand().equals("newFile")) { 
			textPane.setDocument(new DefaultStyledDocument());// �M�Ť��� 
		} else if (e.getActionCommand().equals("open")) { 
			int i = fileChooser.showOpenDialog(EditorFrame.this); // ��ܥ��}����ܮ� 
			if (i == JFileChooser.APPROVE_OPTION) { // �I����ܮؤ����}�ﶵ 
				File f = fileChooser.getSelectedFile(); // �o���ܪ���� 
				try { 
					InputStream is = new FileInputStream(f); // �o�����J�y 
					textPane.read(is, "d"); // Ū�J����奻���� 
				} catch (Exception ex) {
					ex.printStackTrace(); // ��X�X���H�� 
				} 
			} 
		} else if (e.getActionCommand().equals("save")) { 
			int i = fileChooser.showSaveDialog(EditorFrame.this); // ��ܫO�s����ܮ� 
			if (i == JFileChooser.APPROVE_OPTION) { // �I����ܮؤ��O�s���s 
				File f = fileChooser.getSelectedFile(); // �o���ܪ���� 
				try {
					FileOutputStream out = new FileOutputStream(f); // �o�����X�y 
					out.write(textPane.getText().getBytes()); // �g�X��� 
				} catch (Exception ex) {
					ex.printStackTrace(); // ��X�X���H�� 
				} 
			} 
		} else if (e.getActionCommand().equals("exit")) {
			System.exit(0); 
		} else if (e.getActionCommand().equals("cut")) {
			textPane.cut();// �եΤ奻�Ť���k 
		} else if (e.getActionCommand().equals("copy")) {
			textPane.copy();// �եνƻs��k 
		} else if (e.getActionCommand().equals("paste")) {
			textPane.paste();// �ե��߶K��k
		} else if (e.getActionCommand().equals("about")) {
			JOptionPane.showMessageDialog(EditorFrame.this, "www.javayihao.top---²�檺�奻�s�边�t��"); 
		} 
	} 
}