package com.liyuanhong.listener;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonModifyAccountListener extends MouseAdapter{
	private JTextField detailsAccount;
	private JTextField detailsDetails;
	private JTextField detailsAttribute;
	private JTextField detailsPassword;
	private JTextField detailsCipherText;
	private JTextArea detailsComment;
	
	public ButtonModifyAccountListener(JTextField detailsAccount,JTextField detailsDetails,
			JTextField detailsAttribute,JTextField detailsPassword,
			JTextField detailsCipherText,JTextArea detailsComment) {
		this.detailsAccount = detailsAccount;
		this.detailsDetails = detailsDetails;
		this.detailsAttribute = detailsAttribute;
		this.detailsPassword = detailsPassword;
		this.detailsCipherText = detailsCipherText;
		this.detailsComment = detailsComment;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			detailsAccount.setEditable(true);
			detailsDetails.setEditable(true);
			detailsAttribute.setEditable(true);
			detailsPassword.setEditable(true);
			detailsCipherText.setEditable(true);
			detailsComment.setEditable(true);
			detailsComment.setBackground(new Color(255, 255, 255));
		}
	}
}
