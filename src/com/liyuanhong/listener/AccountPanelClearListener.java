package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AccountPanelClearListener extends MouseAdapter{
	private JTextField accountText;
	private JTextField detailText;
	private JTextField passwordTest;
	private JTextField cipherText;
	private JTextArea commentText;
	
	public AccountPanelClearListener(JTextField accountText,JTextField detailText,
			JTextField passwordTest,JTextField cipherText,JTextArea commentText) {
		this.accountText = accountText;
		this.detailText = detailText;
		this.passwordTest = passwordTest;
		this.cipherText = cipherText;
		this.commentText = commentText;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			accountText.setText("");
			detailText.setText("");
			passwordTest.setText("");
			cipherText.setText("");
			commentText.setText("");
		}	
	}
}
