package com.liyuanhong.listener;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.liyuanhong.util.AccountCategory;
import com.liyuanhong.util.CurrentAcountItem;
import com.liyuanhong.util.RulesBean;

public class AccountPanelAddOneListener extends MouseAdapter{
	private JFrame frame;
	private CurrentAcountItem itemAnchor;
	private JTextField accountText;
	private JTextField detailText;
	private JTextField passwordTest;
	private JTextField cipherText;
	private JTextArea commentText;
	private AccountCategory category;
	private RulesBean rulesBean;
	
	private Element rootElement;
	public AccountPanelAddOneListener(JFrame frame,CurrentAcountItem itemAnchor,
			JTextField accountText,JTextField detailText,JTextField passwordTest,
			JTextField cipherText,JTextArea commentText,AccountCategory category,
			RulesBean rulesBean) {
		this.frame = frame;
		this.itemAnchor = itemAnchor;
		this.accountText = accountText;
		this.detailText = detailText;
		this.passwordTest = passwordTest;
		this.cipherText = cipherText;
		this.commentText = commentText;
		this.category = category;
		this.rulesBean = rulesBean;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		
		if(e.getButton() == MouseEvent.BUTTON1){
			if(itemAnchor.getAccountFile() == null){
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(frame, "没有打开任何文件！", 
						"错误息", JOptionPane.ERROR_MESSAGE);
			}else{
				if(accountText.getText().equals("") || detailText.getText().equals("")
						|| passwordTest.getText().equals("")){
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(frame, "账号、说明、原文不能为空！", "ok", 
							JOptionPane.WARNING_MESSAGE);
				}else{
					rootElement = itemAnchor.getDocument().getRootElement();
					
					String account = accountText.getText();
					String detail = detailText.getText();
					String password = passwordTest.getText();
					String cipher = getChphertext(passwordTest.getText());
					String comment = commentText.getText();
					String attribute = getAttributeValue(category);
					
					Element acconterElement = new Element("acconter");
					Element accontElement = new Element("accont");
					Element descriptionElement = new Element("description");
					Element ciphertextElement = new Element("ciphertext");
					Element attributeElement = new Element("attribute");
					Element commentElement = new Element("comment");
					
					accontElement.setText(account);
					descriptionElement.setText(detail);
					ciphertextElement.setText(cipher);
					attributeElement.setText(attribute);
					commentElement.setText(comment);
					
					rootElement.addContent(acconterElement);
					acconterElement.addContent(accontElement);
					acconterElement.addContent(descriptionElement);
					acconterElement.addContent(ciphertextElement);
					acconterElement.addContent(attributeElement);
					acconterElement.addContent(commentElement);
					
					XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
			        try {
						outputter.output(itemAnchor.getDocument(),new FileWriter(
								itemAnchor.getAccountFile()));
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(frame, "账号添加成功！", "ok", 
							JOptionPane.INFORMATION_MESSAGE);
					
					accountText.setText("");
					detailText.setText("");
					passwordTest.setText("");
					cipherText.setText("");
					commentText.setText("");
				}			
			}	
		}		
	}
	
	private String getAttributeValue(AccountCategory category){
		String value = "";
		if(category.getBlongs() == 0){
			value = "个人";
		}else if(category.getBlongs() == 1){
			value = "工作";
		}else if(category.getBlongs() == 2){
			value = "临时";
		}
		if(category.getImportance() == 1){
			value = value + "普通账户";
		}else if(category.getImportance() == 5){
			value = value + "重要账户";
		}	
		return value;
	}
	
	private String getChphertext(String password){
		password = rulesBean.getDefaultRuleClass().changeToCiphertext(passwordTest.getText());
		return password;
	}
}
