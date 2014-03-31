package com.liyuanhong.listener;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.rules.MapRule;
import com.liyuanhong.util.RulesBean;

public class Win1DeleteSelfRuleButtonListener extends MouseAdapter{
	private JFrame frame;
	private JList list;
	private Map<String, AbstrackRule> selfRules;
	private Map<String, File> selfFiles;
	private JComboBox specifyRuleComboBox;
	private JList rulesListArea;
	private RulesBean rulesBean;
	
	
	private String deleteItem;
	private Class<AbstrackRule> cla;
	private MapRule obj;
	private String name;
	private String orgText;
	private String oppText;
	private Vector<String> rules;
	private Map<String, AbstrackRule> rulesMap;
	
	public Win1DeleteSelfRuleButtonListener(JFrame frame, JList list,
			Map<String, AbstrackRule> selfRules, Map<String, File> selfFiles,
			JComboBox specifyRuleComboBox,JList rulesListArea,RulesBean rulesBean) {
		super();
		this.frame = frame;
		this.list = list;
		this.selfRules = selfRules;
		this.selfFiles = selfFiles;
		this.specifyRuleComboBox = specifyRuleComboBox;
		this.rulesListArea = rulesListArea;
		this.rulesBean = rulesBean;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){			
			//删除一个自定义规则，在创建窗口中
			if(list.getSelectedIndex() == -1){
				
			}else{
				deleteItem = list.getSelectedValue().toString();
				selfRules.remove(deleteItem);
				Set<String> set = selfRules.keySet();
				Vector<String> rules = new Vector<String>();
				int k = 0;
				for(Iterator<String> ite = set.iterator();ite.hasNext();k++){
					rules.add(ite.next());
				}
				list.setListData(rules);
				selfFiles.get(deleteItem).delete();				
			}
			
			rulesMap = rulesBean.getRulesMap();
			try {		    
			    rulesMap.remove(deleteItem);
			    Set<String> set = rulesMap.keySet();
				String[] str = new String[set.size()]; 
				rules = new Vector<String>();
				int k = 0;
				for(Iterator<String> ite = set.iterator();ite.hasNext();k++){
					rules.add(ite.next());
				}
				rulesListArea.setListData(rules);
				specifyRuleComboBox.setModel(new DefaultComboBoxModel(rules));
			} catch (Exception e1) {
				e1.printStackTrace();
			}			
		}
	}
}
