package com.liyuanhong.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.rules.MapRule;

public class Win1LoadSelfRule {
	private JFrame frame;
	private JList list;
	private Map<String, AbstrackRule> selfRules;
	private Map<String, File> selfFiles;
	
	public Win1LoadSelfRule(JFrame frame, JList list,
			Map<String, AbstrackRule> selfRules,Map<String, File> selfFiles) {
		super();
		this.frame = frame;
		this.list = list;
		this.selfRules = selfRules;
		this.selfFiles = selfFiles;
	}
	
	public void loadDefaultRule(){
		File mapFile = new File("mapRule/");
		if(!mapFile.exists()){
			mapFile.mkdirs();
		}
		File[] fileList = mapFile.listFiles();
		if(fileList.length == 0){
			
		}else{
			Vector<String> rules = null;
			for(int j = 0;j < fileList.length;j++){
				InputStream is;
				try {
					is = new FileInputStream(fileList[j]);
					ObjectInputStream ois = new ObjectInputStream(is);		    
				    AbstrackRule rule = (AbstrackRule)ois.readObject();
				    selfRules.put(rule.getName(),rule);
				    selfFiles.put(rule.getName(),fileList[j]);
				    is.close();
				    ois.close();
				    
				    Set<String> set = selfRules.keySet();
				    rules = new Vector<String>();
					int k = 0;
					for(Iterator<String> ite = set.iterator();ite.hasNext();k++){
						rules.add(ite.next());
					}				
				} catch (Exception e) {
					e.printStackTrace();
				}					
			}
			list.setListData(rules);
		}		
	}
}
