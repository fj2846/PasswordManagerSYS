package com.liyuanhong.util;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.liyuanhong.rules.AbstrackRule;

public class Win2LoadSysRules {
	private JFrame frame;
	private JList list;
	private Win2SelectCategory selectCategory;
	private Map<String, AbstrackRule> rulesMap;
	private RulesBean rulesBean;
	private JLabel currentRuleLabel;
	
	private Document document;
	private SAXBuilder bulider;
	private List<Element> rulesList;	
	private String className;
	private Vector<String> rules;
	private AbstrackRule sysDefaultRule;
	
	public Win2LoadSysRules(JFrame frame, JList list,
			Win2SelectCategory selectCategory,Map<String, AbstrackRule> rulesMap,
			RulesBean rulesBean,JLabel currentRuleLabel) {
		super();
		this.frame = frame;
		this.list = list;
		this.selectCategory = selectCategory;
		this.rulesMap = rulesMap;
		this.rulesBean = rulesBean;
		this.currentRuleLabel = currentRuleLabel;
	}
	
	public void loadSysRules(){
		File file;
		bulider = new SAXBuilder(); 
		sysDefaultRule = rulesBean.getDefaultRuleClass();
		
		currentRuleLabel.setText(sysDefaultRule.getName());
		try {
			file = new File("config/sysRules.xml");
			try{
				document = bulider.build(new FileReader(file));
			}catch(Exception ee){
				document = bulider.build(file);
			}	
			Element rootElement = document.getRootElement();
			rulesList = rootElement.getChildren("rule");
			
			//加载系统规则
			for(int i = 0;i < rulesList.size();i++){
				Class<AbstrackRule> cla;
				AbstrackRule obj;
				try {				
					className = rulesList.get(i).getText();
					cla = (Class<AbstrackRule>) Class.forName(className);
					obj = cla.newInstance();
					rulesMap.put(obj.getName(),obj);
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
			}
			Set<String> set = rulesMap.keySet();
			rulesBean.setSysRulesMap(rulesMap);
			rules = new Vector<String>();
			int k = 0;
			for(Iterator<String> ite = set.iterator();ite.hasNext();k++){
				rules.add(ite.next());
			}
			list.setListData(rules);
		}catch(Exception e2){
			e2.printStackTrace();
		}		
	}
}
