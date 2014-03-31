package com.liyuanhong.rules;


public class ReversalRule extends AbstrackRule{
//	public static String NAME = "倒序规则";
	public String name = "倒序规则";
	
	public String getName(){
		return this.name;
	}

	@Override
	public String changeToCiphertext(String origenalStr) {
		char[] str = origenalStr.toCharArray();
		char[] temp = new char[str.length];
		
		for(int i = 0;i < str.length;i++){
			temp[i] = str[str.length - 1 - i];
		}
		
		origenalStr = String.valueOf(temp);		
		return origenalStr;
	}

	@Override
	public String changeToOrigenalText(String ciphertextStr) {
		char[] str = ciphertextStr.toCharArray();
		char[] temp = new char[str.length];
		
		for(int i = 0;i < str.length;i++){
			temp[i] = str[str.length - 1 - i];
		}
		
		ciphertextStr = String.valueOf(temp);		
		return ciphertextStr;
	}

	@Override
	public String doCiphertextRuleGroup(String origenalStr) {
		
		return origenalStr;
	}

	@Override
	public String doOrigenalTextRuleGroup(String ciphertextStr) {
		
		return ciphertextStr;
	}
	
}
