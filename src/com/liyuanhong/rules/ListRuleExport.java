package com.liyuanhong.rules;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ListRuleExport extends AbstrackRule{
	public String name = "";
	public Map<String, AbstrackRule> addedRulesMap;
	
	public ListRuleExport(Map<String, AbstrackRule> addedRulesMap) {
		this.addedRulesMap = addedRulesMap;
	}
	
	public Map<String, AbstrackRule> getAddedRulesMap() {
		return addedRulesMap;
	}
	public void setAddedRulesMap(Map<String, AbstrackRule> addedRulesMap) {
		this.addedRulesMap = addedRulesMap;
	}
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
		if(addedRulesMap == null){
			
		}else{
			if(addedRulesMap.size() != 0){
				_result = doCiphertextRuleGroup(origenalStr);
			}			
		}					
		return _result;
	}

	@Override
	public String changeToOrigenalText(String ciphertextStr) {
		String _result = "";				
		if(addedRulesMap == null){
			
		}else{
			if(addedRulesMap.size() != 0){
				_result = doOrigenalTextRuleGroup(ciphertextStr);	
			}			
		}						
		return _result;
	}

	@Override
	public String doCiphertextRuleGroup(String origenalStr) {
		Set<String> set = addedRulesMap.keySet();
		AbstrackRule rule;
		for(Iterator<String> ite = set.iterator();ite.hasNext();){
			String str = ite.next();
			rule = (AbstrackRule)addedRulesMap.get(str);
			origenalStr = rule.changeToCiphertext(origenalStr);
		}
		return origenalStr;
	}

	@Override
	public String doOrigenalTextRuleGroup(String ciphertextStr) {
		Set set = addedRulesMap.keySet();
		String[] rules = new String[set.size()];
		AbstrackRule rule;
		int i = 0;
		for(Iterator<String> ite = set.iterator();ite.hasNext();i++){
			rules[i] = ite.next();
		}
		for(int j = 0;j < rules.length;j++){
			rule = (AbstrackRule)addedRulesMap.get(rules[j]);
			ciphertextStr = rule.changeToOrigenalText(ciphertextStr);
		}
		return ciphertextStr;
	}
	//-------------------------------------
}
