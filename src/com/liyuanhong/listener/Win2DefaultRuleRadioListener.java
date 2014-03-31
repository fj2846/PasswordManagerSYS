package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.liyuanhong.util.Win2SelectCategory;

public class Win2DefaultRuleRadioListener extends MouseAdapter{
	private JFrame frame;
	private JList list;
	private JButton selectRuleButton;
	private JTextField rulePathField;
	private JRadioButton sysRuleRadioButton;
	private JRadioButton sefRuleRadioButton;
	private Win2SelectCategory selectCategory;
	
	private JRadioButton radioButton;
	
	public Win2DefaultRuleRadioListener(JFrame frame, JList list,
			JButton selectRuleButton, JTextField rulePathField,
			JRadioButton sysRuleRadioButton,JRadioButton sefRuleRadioButton,
			Win2SelectCategory selectCategory) {
		super();
		this.frame = frame;
		this.list = list;
		this.selectRuleButton = selectRuleButton;
		this.rulePathField = rulePathField;
		this.sysRuleRadioButton = sysRuleRadioButton;
		this.sefRuleRadioButton = sefRuleRadioButton;
		this.selectCategory = selectCategory;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			radioButton = (JRadioButton)e.getSource();
			if(sysRuleRadioButton.equals(radioButton)){
				list.setEnabled(true);
				selectRuleButton.setEnabled(false);
				rulePathField.setEnabled(false);
				selectCategory.setCategory(0);  //0表示系统规则
			}else if(sefRuleRadioButton.equals(radioButton)){
				list.setEnabled(false);
				selectRuleButton.setEnabled(true);
				rulePathField.setEnabled(true);
				selectCategory.setCategory(1);  //1表示之定义的规则
			}
		}
	}
}
