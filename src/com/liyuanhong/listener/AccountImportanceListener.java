package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import com.liyuanhong.util.AccountCategory;

public class AccountImportanceListener extends MouseAdapter{
	private JFrame frame;
	private JRadioButton importentRadioButton;
	private JRadioButton generalRadioButton;
	private AccountCategory category;
	
	private JRadioButton radioButton;
	
	public AccountImportanceListener(JFrame frame,JRadioButton importentRadioButton,
			JRadioButton generalRadioButton,AccountCategory category) {
		this.frame = frame;
		this.importentRadioButton = importentRadioButton;
		this.generalRadioButton = generalRadioButton;
		this.category = category;
	}
	
	//重要性越大，数值越大 general，importance分别为1,5
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			radioButton = (JRadioButton)e.getSource();
			
			if(importentRadioButton.equals(radioButton)){
				category.setImportance(5);
			}else if(generalRadioButton.equals(radioButton)){
				category.setImportance(1);
			}
		}	
	}
}
