package com.liyuanhong.listener;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;

public class MenuRightCopy implements ActionListener{
	private JFrame frame;
	private JList searchReasults;
	
	private String str = "";
	public MenuRightCopy(JFrame frame, JList searchReasults) {
		super();
		this.frame = frame;
		this.searchReasults = searchReasults;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		str = searchReasults.getSelectedValue().toString();
		StringSelection stsel = new StringSelection(str);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel, stsel);		
	}

}
