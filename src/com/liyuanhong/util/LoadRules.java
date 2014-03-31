package com.liyuanhong.util;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.rules.MapRule;

public class LoadRules {
	private RulesBean rulesBean;
	private JList rulesListArea;
	private JList addedListArea;
	private JComboBox specifyRuleComboBox;
	private JFrame frame;
	private TransformRuleUtil transformRule;
	
	private Document document;
	private SAXBuilder bulider;
	private List<Element> rulesList;
	private Map<String, AbstrackRule> rulesMap;
	private String className;
	private Vector<String> rules;
	private AbstrackRule defaultRule;
	
	public LoadRules(RulesBean rulesBean, JList rulesListArea,
			JList addedListArea,JComboBox specifyRuleComboBox,
			JFrame frame,TransformRuleUtil transformRule) {
		super();
		this.rulesBean = rulesBean;
		this.rulesListArea = rulesListArea;
		this.addedListArea = addedListArea;
		this.specifyRuleComboBox = specifyRuleComboBox;
		this.frame = frame;
		this.transformRule = transformRule;
	}
	
	public void loadSysRules(){
		File file;
		defaultRule = rulesBean.getDefaultRuleClass();
		rulesMap = rulesBean.getRulesMap();
		bulider = new SAXBuilder(); 
		try {
			file = new File("config/sysRules.xml");
			System.out.println(file.getAbsolutePath());
			try{
				document = bulider.build(new FileReader(file));
			}catch(Exception ee){
				document = bulider.build(file);
			}	
			Element rootElement = document.getRootElement();
			rulesList = rootElement.getChildren("rule");
			rulesBean.setDefaultRule(rootElement.getChild("default").getText());
			loadDefaultRule(rulesBean.getDefaultRule());
			
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
			rulesBean.setSysRulesMap(rulesMap);
			//加载自定义规则
			File mapFile = new File("mapRule/");
			if(!mapFile.exists()){
				mapFile.mkdirs();
			}
			File[] fileList = mapFile.listFiles();
			for(int j = 0;j < fileList.length;j++){
				InputStream is = new FileInputStream(fileList[j]);
			    ObjectInputStream ois = new ObjectInputStream(is);		    
			    AbstrackRule rule = (AbstrackRule)ois.readObject();
			    rulesMap.put(rule.getName(),rule);
			    is.close();
			    ois.close();
			}
			//让加载的rule倒序
			Set<String> set = rulesMap.keySet();
			String[] str = new String[set.size()]; 
			rules = new Vector<String>();
			int k = 0;
			for(Iterator<String> ite = set.iterator();ite.hasNext();k++){
//				str[k] = ite.next();
				rules.add(ite.next());
			}
//			k = str.length - 1;
//			for(;k >= 0;k--){
//				rules.add(str[k]);
//			}		
			rulesListArea.setListData(rules);
			specifyRuleComboBox.setModel(new DefaultComboBoxModel(rules));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void loadDefaultRule(String defaultRuleText){
		Class<AbstrackRule> cla;
		AbstrackRule obj;
		try {
			cla = (Class<AbstrackRule>) Class.forName(defaultRuleText);
			obj = cla.newInstance();
			defaultRule = obj;
			transformRule.setTransformRule(defaultRule);
			rulesBean.setDefaultRuleClass(defaultRule);
		} catch (Exception e1) {
			e1.printStackTrace();
			File file = new File(defaultRuleText);
			FileInputStream is;
			try {
				is = new FileInputStream(file);
				ObjectInputStream iis=new ObjectInputStream(is);
				defaultRule = (AbstrackRule) iis.readObject();
				transformRule.setTransformRule(defaultRule);
				rulesBean.setDefaultRuleClass(defaultRule);
			    iis.close();
			    is.close();
			} catch (Exception e3) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(frame, "默认规则加载失败，请检查您的配置文件，或更换默认规则！", "ok", 
						JOptionPane.CANCEL_OPTION);
			}
		}
	}
}
