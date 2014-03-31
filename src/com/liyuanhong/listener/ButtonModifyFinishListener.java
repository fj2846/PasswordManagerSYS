package com.liyuanhong.listener;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.liyuanhong.util.CurrentAcountItem;
import com.liyuanhong.util.RulesBean;

public class ButtonModifyFinishListener extends MouseAdapter{
	private JFrame frame;	
	private CurrentAcountItem itemAnchor;
	private JTextField detailsAccount;
	private JTextField detailsDetails;
	private JTextField detailsAttribute;
	private JTextField detailsPassword;
	private JTextField detailsCipherText;
	private JTextArea detailsComment;
	private RulesBean rulesBean;
	
	private Element currentElement;
	private List<Element> accountsList;
	
	public ButtonModifyFinishListener(JFrame frame,
			CurrentAcountItem itemAnchor, JTextField detailsAccount,
			JTextField detailsDetails, JTextField detailsAttribute,
			JTextField detailsPassword, JTextField detailsCipherText,
			JTextArea detailsComment,RulesBean rulesBean) {
		super();
		this.frame = frame;
		this.itemAnchor = itemAnchor;
		this.detailsAccount = detailsAccount;
		this.detailsDetails = detailsDetails;
		this.detailsAttribute = detailsAttribute;
		this.detailsPassword = detailsPassword;
		this.detailsCipherText = detailsCipherText;
		this.detailsComment = detailsComment;
		this.rulesBean = rulesBean;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			if(itemAnchor.getDocument() == null){
				
			}else{
				if(detailsAccount.isEditable() == false){
					
				}else{
					if(detailsAccount.getText().equals("") || detailsDetails.getText().equals("")
							|| detailsPassword.getText().equals("")){
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(frame, "账号、说明、原文不能为空！", "ok", 
								JOptionPane.WARNING_MESSAGE);
					}else{
						accountsList = itemAnchor.getAccountsList();
						currentElement = accountsList.get(itemAnchor.getAccountAnchor());
						
						currentElement.getChild("accont").setText(detailsAccount.getText());
						currentElement.getChild("description").setText(detailsDetails.getText());
						try{
							currentElement.getChild("attribute").setText(detailsAttribute.getText());
						}catch(Exception e1){
							Element attributeElement = new Element("attribute");
							currentElement.addContent(attributeElement);
							currentElement.getChild("attribute").setText(detailsAttribute.getText());
						}					
						try{
							currentElement.getChild("comment").setText(detailsComment.getText());
						}catch(Exception e1){
							Element commentElement = new Element("comment");
							currentElement.addContent(commentElement);
							currentElement.getChild("comment").setText(detailsComment.getText());
						}				
						
						String ciphertext = getChphertext(detailsPassword.getText());
						currentElement.getChild("ciphertext").setText(ciphertext);
						
						detailsAccount.setEditable(false);
						detailsDetails.setEditable(false);
						detailsAttribute.setEditable(false);
						detailsPassword.setEditable(false);
						detailsCipherText.setEditable(false);
						detailsComment.setEditable(false);
						detailsComment.setBackground(new Color(240, 240, 240));
						
						XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
				        try {
							outputter.output(itemAnchor.getDocument(),new FileWriter(
									itemAnchor.getAccountFile()));
						} catch (IOException e1) {
							e1.printStackTrace();
						}	
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(frame, "账号修改成功！", "ok", 
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}
	}
	
	private String getChphertext(String password){
		password = rulesBean.getDefaultRuleClass().changeToCiphertext(password);
		return password;
	}
}
