package com.liyuanhong.listener;

import java.awt.FileDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

import org.jdom2.input.SAXBuilder;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.rules.ListRuleExport;
import com.liyuanhong.util.RulesBean;

public class ImportCreateRuleListener extends MouseAdapter{
	private JFrame frame;
	private RulesBean rulesBean;
	private JList addedListArea;
	private JTextArea orgMapTextArea;
	private JTextArea cipMapTextArea;
	
	private Map<String, AbstrackRule> addedRulesMap;
	private FileDialog fileDialog;
	private String filePath;
	private String fileName;
	private ListRuleExport listRuleExpot;
	
	public ImportCreateRuleListener(JFrame frame, RulesBean rulesBean,JList addedListArea,
			JTextArea orgMapTextArea,JTextArea cipMapTextArea) {
		super();
		this.frame = frame;
		this.rulesBean = rulesBean;
		this.addedListArea = addedListArea;
		this.orgMapTextArea = orgMapTextArea;
		this.cipMapTextArea = cipMapTextArea;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			fileDialog = new FileDialog(frame);
			fileDialog.show();
			filePath = fileDialog.getDirectory();
			fileName = fileDialog.getFile();
			if(filePath == null || fileName == null){
				
			}else{
				File file = new File(filePath + fileName);
				FileInputStream is;
				try {
					is = new FileInputStream(file);
					ObjectInputStream iis=new ObjectInputStream(is);
					listRuleExpot = (ListRuleExport) iis.readObject();
					addedRulesMap = listRuleExpot.getAddedRulesMap();
				    iis.close();
				    is.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}	
				
				Set<String> set = addedRulesMap.keySet();
				rulesBean.setAddedRulesMap(addedRulesMap);
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
