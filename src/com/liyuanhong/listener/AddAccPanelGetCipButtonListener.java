package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.liyuanhong.util.RulesBean;

public class AddAccPanelGetCipButtonListener extends MouseAdapter{
	private JFrame frame;
	private RulesBean rulesBean;
	private JTextField passwordTest;
	private JTextField cipherText;
	
	public AddAccPanelGetCipButtonListener(JFrame frame, RulesBean rulesBean,
			JTextField passwordTest, JTextField cipherText) {
		super();
		this.frame = frame;
		this.rulesBean = rulesBean;
		this.passwordTest = passwordTest;
		this.cipherText = cipherText;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			cipherText.setText(rulesBean.getDefaultRuleClass().
					changeToCiphertext(passwordTest.getText()));
		}
	}
}
