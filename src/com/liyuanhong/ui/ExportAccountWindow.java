package com.liyuanhong.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

public class ExportAccountWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExportAccountWindow window = new ExportAccountWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ExportAccountWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 539, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 192, 395);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton(">>>");
		btnNewButton.setBounds(212, 43, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("<<<");
		button.setBounds(212, 76, 93, 23);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(315, 43, 192, 395);
		frame.getContentPane().add(scrollPane_1);
		
		JList list_1 = new JList();
		scrollPane_1.setViewportView(list_1);
		
		JLabel label = new JLabel("\u6240\u6709\u8D26\u53F7\uFF1A");
		label.setBounds(10, 14, 192, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8981\u5BFC\u51FA\u7684\u8D26\u53F7\uFF1A");
		label_1.setBounds(319, 14, 188, 15);
		frame.getContentPane().add(label_1);
	}
}
