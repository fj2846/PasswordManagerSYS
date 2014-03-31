package com.liyuanhong.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import com.liyuanhong.rules.AbstrackRule;

public class RulesBean {
	private boolean isDefault = true;
	private Map<String, AbstrackRule> rulesMap = new LinkedHashMap<String, AbstrackRule>();
	private String specifyRule = "";
	private Map<String, AbstrackRule> addedRulesMap = new LinkedHashMap<String, AbstrackRule>();
	private String defaultRule = "";
	private AbstrackRule defaultRuleClass;
	private Map<String, AbstrackRule> sysRulesMap;
	
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	public Map<String, AbstrackRule> getRulesMap() {
		return rulesMap;
	}
	public void setRulesMap(Map<String, AbstrackRule> rulesMap) {
		this.rulesMap = rulesMap;
	}
	public String getSpecifyRule() {
		return specifyRule;
	}
	public void setSpecifyRule(String specifyRule) {
		this.specifyRule = specifyRule;
	}
	public Map<String, AbstrackRule> getAddedRulesMap() {
		return addedRulesMap;
	}
	public void setAddedRulesMap(Map<String, AbstrackRule> addedRulesMap) {
		this.addedRulesMap = addedRulesMap;
	}
	public String getDefaultRule() {
		return defaultRule;
	}
	public void setDefaultRule(String defaultRule) {
		this.defaultRule = defaultRule;
	}
	public AbstrackRule getDefaultRuleClass() {
		return defaultRuleClass;
	}
	public void setDefaultRuleClass(AbstrackRule defaultRuleClass) {
		this.defaultRuleClass = defaultRuleClass;
	}
	public Map<String, AbstrackRule> getSysRulesMap() {
		return sysRulesMap;
	}
	public void setSysRulesMap(Map<String, AbstrackRule> sysRulesMap) {
		this.sysRulesMap = sysRulesMap;
	}
}
