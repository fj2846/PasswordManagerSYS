package com.liyuanhong.listener;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.util.RulesBean;
import com.liyuanhong.util.Win2SelectCategory;

public class Win2SetDefaultButtonListener extends MouseAdapter{
	private JFrame frame;
	private RulesBean rulesBean;
	private Win2SelectCategory selectCategory;
	private JLabel currentRuleLabel;
	private JList list;
	
	private Map<String, AbstrackRule> rulesMap;
	private Document document;
	private SAXBuilder bulider;
	private List<Element> rulesList;
	
	public Win2SetDefaultButtonListener(JFrame frame, RulesBean rulesBean,
			Win2SelectCategory selectCategory, JLabel currentRuleLabel,
			JList list) {
		super();
		this.frame = frame;
		this.rulesBean = rulesBean;
		this.selectCategory = selectCategory;
		this.currentRuleLabel = currentRuleLabel;
		this.list = list;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			rulesMap = rulesBean.getSysRulesMap();
			if(selectCategory.getCategory() == 0){
				if(list.getSelectedIndex() == -1){
					
				}else{
					AbstrackRule defaultRule = rulesMap.get(list.getSelectedValue());				
					rulesBean.setDefaultRuleClass(defaultRule);
					currentRuleLabel.setText(rulesMap.get(list.getSelectedValue()).getName());
					rulesBean.setDefaultRule(defaultRule.getClass().getName());
					
					File file;
					bulider = new SAXBuilder(); 
					
					try {
						file = new File("config/sysRules.xml");
						try{
							document = bulider.build(new FileReader(file));
						}catch(Exception ee){
							document = bulider.build(file);
						}	
						Element rootElement = document.getRootElement();
						rootElement.getChild("default").setText(rulesBean.getDefaultRule());
						
						XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
				        try {
							outputter.output(document,new FileWriter(file));
						} catch (IOException e1) {
							e1.printStackTrace();
						}	
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(frame, "修改成功！", "ok", 
								JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception ee1){
						
					}
				}				
			}else if(selectCategory.getCategory() == 1){
				File file;
				bulider = new SAXBuilder(); 
				
				try {
					file = new File("config/sysRules.xml");
					try{
						document = bulider.build(new FileReader(file));
					}catch(Exception ee){
						document = bulider.build(file);
					}	
					Element rootElement = document.getRootElement();
					rootElement.getChild("default").setText(rulesBean.getDefaultRule());
					
					XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
			        try {
						outputter.output(document,new FileWriter(file));
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(frame, "修改成功！", "ok", 
							JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception ee1){
					
				}
			}
		}
	}
}
