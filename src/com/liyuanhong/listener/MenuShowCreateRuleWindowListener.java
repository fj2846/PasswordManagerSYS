package com.liyuanhong.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JList;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.ui.CreateMapRuleWindow;
import com.liyuanhong.util.RulesBean;

public class MenuShowCreateRuleWindowListener implements ActionListener{
	private CreateMapRuleWindow createWindow;
	private JList rulesListArea;
	private RulesBean rulesBean;
	private JComboBox specifyRuleComboBox;
	
	public MenuShowCreateRuleWindowListener(JList rulesListArea,RulesBean rulesBean,
			JComboBox specifyRuleComboBox) {
		this.rulesListArea = rulesListArea;
		this.rulesBean = rulesBean;
		this.specifyRuleComboBox = specifyRuleComboBox;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		createWindow = CreateMapRuleWindow.getInstance(rulesListArea,rulesBean,specifyRuleComboBox);
		createWindow.frame.setVisible(true);		
	}
}
