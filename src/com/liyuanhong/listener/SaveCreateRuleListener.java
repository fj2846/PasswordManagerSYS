package com.liyuanhong.listener;

import java.awt.FileDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import javax.swing.JFrame;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.rules.ListRuleExport;
import com.liyuanhong.util.RulesBean;

public class SaveCreateRuleListener extends MouseAdapter{
	private JFrame frame;
	private RulesBean rulesBean;
	
	private Map<String, AbstrackRule> addedRulesMap;
	private FileDialog fileDialog;
	private String filePath;
	private String fileName;
	
	public SaveCreateRuleListener(JFrame frame, RulesBean rulesBean) {
		super();
		this.frame = frame;
		this.rulesBean = rulesBean;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			fileDialog = new FileDialog(frame, "", FileDialog.SAVE);
			fileDialog.show();
			filePath = fileDialog.getDirectory();
			fileName = fileDialog.getFile();
			
			if(fileName == null || filePath == null){
				
			}else{
				addedRulesMap = rulesBean.getAddedRulesMap();
				File file = new File(filePath + fileName);
				ListRuleExport exportRule = new ListRuleExport(addedRulesMap);
				exportRule.setName(fileName);
				FileOutputStream os;
				try {
					os = new FileOutputStream(file);
					ObjectOutputStream oos=new ObjectOutputStream(os);
				    oos.writeObject(exportRule);
				    oos.close();
				    os.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
			}		
		}
	}
	

}
