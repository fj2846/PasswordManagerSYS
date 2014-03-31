package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.rules.ListRuleExport;
import com.liyuanhong.util.RulesBean;

public class RunAddedRuleButtonListener extends MouseAdapter{
	private JFrame frame;
	private RulesBean rulesBean;
	private JList addedListArea;
	private JList rulesListArea;
	private JTextArea orgMapTextArea;
	private JTextArea cipMapTextArea;
	
	public RunAddedRuleButtonListener(JFrame frame, RulesBean rulesBean,
			JList addedListArea, JList rulesListArea, JTextArea orgMapTextArea,
			JTextArea cipMapTextArea) {
		super();
		this.frame = frame;
		this.rulesBean = rulesBean;
		this.addedListArea = addedListArea;
		this.rulesListArea = rulesListArea;
		this.orgMapTextArea = orgMapTextArea;
		this.cipMapTextArea = cipMapTextArea;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			if(rulesListArea.getSelectedIndex() == -1){
				
			}else{
				excuteRulesList(orgMapTextArea, cipMapTextArea);
			}
		}
	}
	
	public void excuteRulesList(JTextArea orgMapTextArea,JTextArea cipMapTextArea){
		ListRuleExport listRule = new ListRuleExport(rulesBean.getAddedRulesMap());
		cipMapTextArea.setText(listRule.doCiphertextRuleGroup(orgMapTextArea.getText()));
	}
}
