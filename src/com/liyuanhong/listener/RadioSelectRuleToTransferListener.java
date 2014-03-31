package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.util.RulesBean;
import com.liyuanhong.util.TransformRuleUtil;

public class RadioSelectRuleToTransferListener extends MouseAdapter{
	private JFrame frame;
	private JRadioButton defaultRule;
	private JRadioButton specifiedRule;
	private JRadioButton otherRule;
	private JComboBox  specifyRuleComboBox;
	private JTextField otherRuleFiled;
	private JButton otherRuleButton;	
	private RulesBean rulesBean;
	private TransformRuleUtil transformRule;
	
	private JRadioButton radioButton;
	
	public RadioSelectRuleToTransferListener(JFrame frame, JRadioButton defaultRule,
			JRadioButton specifiedRule, JRadioButton otherRule,
			JComboBox specifyRuleComboBox, JTextField otherRuleFiled,
			JButton otherRuleButton, RulesBean rulesBean,TransformRuleUtil transformRule) {
		super();
		this.frame = frame;
		this.defaultRule = defaultRule;
		this.specifiedRule = specifiedRule;
		this.otherRule = otherRule;
		this.specifyRuleComboBox = specifyRuleComboBox;
		this.otherRuleFiled = otherRuleFiled;
		this.otherRuleButton = otherRuleButton;
		this.rulesBean = rulesBean;
		this.transformRule = transformRule;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		radioButton = (JRadioButton)e.getSource();
		if(e.getButton() == MouseEvent.BUTTON1){		
			if(defaultRule.equals(radioButton)){
				specifyRuleComboBox.setEnabled(false);
				otherRuleFiled.setEnabled(false);
				otherRuleFiled.setText("");
				otherRuleButton.setEnabled(false);
				transformRule.setTransformRule(rulesBean.getDefaultRuleClass());
			}else if(specifiedRule.equals(radioButton)){
				specifyRuleComboBox.setEnabled(true);
				otherRuleFiled.setEnabled(false);
				otherRuleFiled.setText("");
				otherRuleButton.setEnabled(false);
				initSpecifiedRule();
			}else if(otherRule.equals(radioButton)){
				specifyRuleComboBox.setEnabled(false);
				otherRuleFiled.setEnabled(true);
				otherRuleButton.setEnabled(true);
			}			
		}
	}
	
	public void initSpecifiedRule(){
		if(specifyRuleComboBox.getSelectedIndex() == -1){
			
		}else{
			String selectItem = specifyRuleComboBox.getSelectedItem().toString();
			transformRule.setTransformRule(rulesBean.getRulesMap().get(selectItem));
		}		
	}
}
