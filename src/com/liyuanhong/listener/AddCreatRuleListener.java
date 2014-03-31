package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.rules.ListRuleExport;
import com.liyuanhong.util.RulesBean;

public class AddCreatRuleListener extends MouseAdapter{
	private JFrame frame;
	private RulesBean rulesBean;
	private JList addedListArea;
	private JList rulesListArea;
	private JTextArea orgMapTextArea;
	private JTextArea cipMapTextArea;
	
	private Map<String, AbstrackRule> addedRulesMap;
	private Map<String, AbstrackRule> rulesMap;
	private String selectKey;
	
	public AddCreatRuleListener(JFrame frame, RulesBean rulesBean,JList addedListArea,
			JList rulesListArea,JTextArea orgMapTextArea,JTextArea cipMapTextArea) {
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
				addedRulesMap = rulesBean.getAddedRulesMap();
				rulesMap = rulesBean.getRulesMap();
				selectKey = rulesListArea.getSelectedValue().toString();
				int p = 0;
				if(addedRulesMap.keySet().contains(selectKey)){
					++p;
					while(addedRulesMap.keySet().contains(selectKey + p)){
						++p;
					}
					addedRulesMap.put(selectKey + p, rulesMap.get(selectKey));
				}else{
					addedRulesMap.put(selectKey, rulesMap.get(selectKey));
				}	
				Set<String> set = addedRulesMap.keySet();
				String[] str = new String[set.size()]; 
				Vector<String> rules = new Vector<String>();
				int k = 0;
				for(Iterator<String> ite = set.iterator();ite.hasNext();k++){
//					str[k] = ite.next();
					rules.add(ite.next());
				}
//				k = str.length - 1;
//				for(;k >= 0;k--){
//					rules.add(str[k]);
//				}		
				addedListArea.setListData(rules);
				excuteRulesList(orgMapTextArea, cipMapTextArea);
			}
		}
	}
	
	public void excuteRulesList(JTextArea orgMapTextArea,JTextArea cipMapTextArea){
		ListRuleExport listRule = new ListRuleExport(rulesBean.getAddedRulesMap());
		cipMapTextArea.setText(listRule.doCiphertextRuleGroup(orgMapTextArea.getText()));
	}
}
