package com.liyuanhong.listener;

import java.awt.FileDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.rules.ListRuleExport;
import com.liyuanhong.util.RulesBean;
import com.liyuanhong.util.Win2SelectCategory;

public class Win2SelectRuleButtonListener extends MouseAdapter{
	private JFrame frame;
	private RulesBean rulesBean;
	private Win2SelectCategory selectCategory;
	private JLabel currentRuleLabel;
	private JTextField rulePathField;
	
	private FileDialog fileDialog;
	private String filePath;
	private String fileName;
	private AbstrackRule defaultRule;
	private String defaultRulePath;
	
	public Win2SelectRuleButtonListener(JFrame frame, RulesBean rulesBean,
			Win2SelectCategory selectCategory, JLabel currentRuleLabel,
			JTextField rulePathField) {
		super();
		this.frame = frame;
		this.rulesBean = rulesBean;
		this.selectCategory = selectCategory;
		this.currentRuleLabel = currentRuleLabel;
		this.rulePathField = rulePathField;
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
					defaultRule = (AbstrackRule) iis.readObject();
					rulesBean.setDefaultRuleClass(defaultRule);
					currentRuleLabel.setText(defaultRule.getName());
					rulesBean.setDefaultRule(filePath + fileName);
					rulePathField.setText(filePath + fileName);
				    iis.close();
				    is.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
