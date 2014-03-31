package com.liyuanhong.rules;


public class MapRuleTemplate extends AbstrackRule{
	public String name = "";
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String changeToCiphertext(String origenalStr) {

		return origenalStr;
	}

	@Override
	public String changeToOrigenalText(String ciphertextStr) {

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
