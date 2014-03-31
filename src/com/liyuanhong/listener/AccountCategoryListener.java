package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import com.liyuanhong.util.AccountCategory;

public class AccountCategoryListener extends MouseAdapter{
	private JFrame frame;
	private JRadioButton personalRadioButton;
	private JRadioButton workRadioButton;
	private JRadioButton tempRadioButton;
	private AccountCategory category;
	
	private JRadioButton radioButton;
	
	
	public AccountCategoryListener(JFrame frame,JRadioButton personalRadioButton,
			JRadioButton workRadioButton,JRadioButton tempRadioButton,AccountCategory category){
		this.frame = frame;
		this.personalRadioButton = personalRadioButton;
		this.workRadioButton = workRadioButton;
		this.tempRadioButton = tempRadioButton;
		this.category = category;
	}
	
	//三种状态person，work，temp分别赋值为0,1,2
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			radioButton = (JRadioButton)e.getSource();
			
			if(personalRadioButton.equals(radioButton)){
				category.setBlongs(0);
			}else if(workRadioButton.equals(radioButton)){
				category.setBlongs(1);
			}else if(tempRadioButton.equals(radioButton)){
				category.setBlongs(2);
			}
		}		
	}
}
