package com.liyuanhong.rules;


public class CrussRule extends AbstrackRule{
//	public static String NAME = "基偶交叉规则";
	public String name = "基偶交叉规则";
	
	public String getName(){
		return this.name;
	}

	@Override
	public String changeToCiphertext(String origenalStr) {		
		char[] _cha = origenalStr.toCharArray();
		int _len = _cha.length;
		char temp;
		for(int i = 0;i + 1 < _len;i+=2){
			temp = _cha[i + 1];
			_cha[i + 1] = _cha[i];
			_cha[i] = temp;
		}
		origenalStr = String.valueOf(_cha);
		return origenalStr;
	}

	@Override
	public String changeToOrigenalText(String ciphertextStr) {
		char[] _cha = ciphertextStr.toCharArray();
		int _len = _cha.length;
		char temp;
		for(int i = 0;i + 1 < _len;i+=2){
			temp = _cha[i + 1];
			_cha[i + 1] = _cha[i];
			_cha[i] = temp;
		}
		ciphertextStr = String.valueOf(_cha);
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
