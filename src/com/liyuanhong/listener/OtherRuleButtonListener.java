package com.liyuanhong.listener;

import java.awt.FileDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.util.RulesBean;
import com.liyuanhong.util.TransformRuleUtil;

public class OtherRuleButtonListener extends MouseAdapter{
	private JFrame frame;
	private JTextField otherRuleFiled;
	private JButton otherRuleButton;	
	private RulesBean rulesBean;
	private TransformRuleUtil transformRule;
	
	private FileDialog fileDialog;
	private String filePath;
	private String fileName;
	
	public OtherRuleButtonListener(JFrame frame, JTextField otherRuleFiled,
			JButton otherRuleButton, RulesBean rulesBean,
			TransformRuleUtil transformRule) {
		super();
		this.frame = frame;
		this.otherRuleFiled = otherRuleFiled;
		this.otherRuleButton = otherRuleButton;
		this.rulesBean = rulesBean;
		this.transformRule = transformRule;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			fileDialog = new FileDialog(frame);
			fileDialog.show();
			filePath = fileDialog.getDirectory();
			fileName = fileDialog.getFile();
			if(filePath == null || fileName == null){
				
			}else{
				File file;
				try {
					file = new File(filePath + fileName);
					FileInputStream is;
					otherRuleFiled.setText(filePath + fileName);
					try {
						is = new FileInputStream(file);
						ObjectInputStream iis=new ObjectInputStream(is);
						transformRule.setTransformRule((AbstrackRule) iis.readObject());
					    iis.close();
					    is.close();
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(frame, "文件格式错误！", "错误", JOptionPane.ERROR_MESSAGE);
					}	
				} catch (Exception e1) {
					e1.printStackTrace();					
				}  
			}       
		}
	}
}
