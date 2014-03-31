package com.liyuanhong.rules;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MapRule extends MapRuleTemplate{
	public String name = "";
	private char[] orgMatrix;
	private char[] cipMatrix;
	
	private JFrame frame;
	private JTextArea orgTextArea;
	private JTextArea oppTextArea;
	private JTextField ruleNameFiled;
	private String orgText = "";
	private String oppText = "";
	
	public MapRule() {
		
	}
	public JTextArea getOrgTextArea() {
		return orgTextArea;
	}
	public void setOrgTextArea(JTextArea orgTextArea) {
		this.orgTextArea = orgTextArea;
	}
	public JTextArea getOppTextArea() {
		return oppTextArea;
	}
	public void setOppTextArea(JTextArea oppTextArea) {
		this.oppTextArea = oppTextArea;
	}
	public JTextField getRuleNameFiled() {
		return ruleNameFiled;
	}
	public void setRuleNameFiled(JTextField ruleNameFiled) {
		this.ruleNameFiled = ruleNameFiled;
	}
	public String getOrgText() {
		return orgText;
	}
	public void setOrgText(String orgText) {
		this.orgText = orgText;
		this.orgMatrix = orgText.trim().toCharArray();
	}
	public String getOppText() {
		return oppText;
	}
	public void setOppText(String oppText) {
		this.oppText = oppText;
		this.cipMatrix = oppText.trim().toCharArray();
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	public char[] getOrgMatrix() {
		return orgMatrix;
	}
	public void setOrgMatrix(char[] orgMatrix) {
		this.orgMatrix = orgMatrix;
	}
	public char[] getCipMatrix() {
		return cipMatrix;
	}

	public void setCipMatrix(char[] cipMatrix) {
		this.cipMatrix = cipMatrix;
	}

	
	//-------------加密解密方法--------------
	@Override
	public String changeToCiphertext(String origenalStr) {
		String _result = "";
//		createTwinsArray();
		char[] _origenalStr = origenalStr.toCharArray();
		for(int i =0;i < _origenalStr.length;i++){
			for(int j = 0;j < orgMatrix.length;j++){
				if(_origenalStr[i] == orgMatrix[j]){
					_result = _result + cipMatrix[j];
				}
			}
		}		
		return _result;
	}

	@Override
	public String changeToOrigenalText(String ciphertextStr) {
		String _result = "";
//		createTwinsArray();
		char[] _cipgenalStr = ciphertextStr.toCharArray();
		for(int i =0;i < _cipgenalStr.length;i++){
			for(int j = 0;j < cipMatrix.length;j++){
				if(_cipgenalStr[i] == cipMatrix[j]){
					_result = _result + orgMatrix[j];
				}
			}
		}		
		return _result;
	}

	@Override
	public String doCiphertextRuleGroup(String origenalStr) {
		return origenalStr;
	}

	@Override
	public String doOrigenalTextRuleGroup(String ciphertextStr) {
		return ciphertextStr;
	}
	//-------------------------------------
	
//	public void createTwinsArray(){		
//		orgMatrix = orgText.trim().toCharArray();
//		cipMatrix = oppText.trim().toCharArray();
//	}
}
