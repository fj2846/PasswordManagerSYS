package com.liyuanhong.rules;

import java.io.Serializable;


public class AbstrackRule implements Rule,Serializable {
	private static final long serialVersionUID = 1L;
	public String name = "";
	
	public String getName(){
		return this.name;
	}	
	public void setName(String name){
		this.name = name;
	}	
	
	//-------------加密解密方法--------------
	@Override
	public String changeToCiphertext(String origenalStr) {
		String _result = "";		
		
				
		_result = doCiphertextRuleGroup(_result);	
		return _result;
	}

	@Override
	public String changeToOrigenalText(String ciphertextStr) {
		String _result = "";
		
		_result = doOrigenalTextRuleGroup(_result);		
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
}
