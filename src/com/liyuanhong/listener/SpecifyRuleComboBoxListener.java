package com.liyuanhong.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.liyuanhong.util.RulesBean;
import com.liyuanhong.util.TransformRuleUtil;

public class SpecifyRuleComboBoxListener implements ActionListener{
	private JFrame frame;
	private JComboBox  specifyRuleComboBox;	
	private RulesBean rulesBean;
	private TransformRuleUtil transformRule;
	
	public SpecifyRuleComboBoxListener(JFrame frame,
			JComboBox specifyRuleComboBox, RulesBean rulesBean,
			TransformRuleUtil transformRule) {
		super();
		this.frame = frame;
		this.specifyRuleComboBox = specifyRuleComboBox;
		this.rulesBean = rulesBean;
		this.transformRule = transformRule;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectItem = specifyRuleComboBox.getSelectedItem().toString();
		transformRule.setTransformRule(rulesBean.getRulesMap().get(selectItem));
	}
}
