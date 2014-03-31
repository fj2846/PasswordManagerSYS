package com.liyuanhong.rules;

public interface Rule {
	public String changeToCiphertext(String origenalStr);	
	public String changeToOrigenalText(String ciphertextStr);
	public String doCiphertextRuleGroup(String origenalStr);
	public String doOrigenalTextRuleGroup(String ciphertextStr);
}
