package com.liyuanhong.listener;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.ui.SetDefaultRuleWindow;
import com.liyuanhong.util.RulesBean;

public class MenuSetDefaultRuleListener implements ActionListener{
	private RulesBean rulesBean;
	
	private Document document;
	private SAXBuilder bulider;
	private List<Element> rulesList;
	private String className;
	private FileDialog fileDialog;
	private String filePath;
	private String fileName;
	
	public MenuSetDefaultRuleListener(RulesBean rulesBean) {
		super();
		this.rulesBean = rulesBean;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SetDefaultRuleWindow setDefaultRuleWindow = SetDefaultRuleWindow.getInstance(rulesBean);
		setDefaultRuleWindow.frame.setVisible(true);
	}
}
