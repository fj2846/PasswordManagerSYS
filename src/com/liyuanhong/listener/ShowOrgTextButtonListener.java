package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.liyuanhong.util.RulesBean;
import com.liyuanhong.util.TransformRuleUtil;

public class ShowOrgTextButtonListener extends MouseAdapter{
	private JFrame frame;
	private TransformRuleUtil transformRule;
	private JTextField detailsPassword;
	private JTextField detailsCipherText;
	private RulesBean rulesBean;
	
	public ShowOrgTextButtonListener(JFrame frame,
			RulesBean rulesBean, JTextField detailsPassword,
			JTextField detailsCipherText) {
		super();
		this.frame = frame;
		this.rulesBean = rulesBean;
		this.detailsPassword = detailsPassword;
		this.detailsCipherText = detailsCipherText;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			detailsPassword.setText(rulesBean.getDefaultRuleClass().
					changeToOrigenalText(detailsCipherText.getText()));
		}
	}
}
