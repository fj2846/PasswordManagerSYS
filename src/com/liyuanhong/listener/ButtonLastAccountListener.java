package com.liyuanhong.listener;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdom2.Element;

import com.liyuanhong.util.CurrentAcountItem;

public class ButtonLastAccountListener extends MouseAdapter{
	private JFrame frame;	
	private CurrentAcountItem itemAnchor;
	private JTextField detailsAccount;
	private JTextField detailsDetails;
	private JTextField detailsAttribute;
	private JTextField detailsPassword;
	private JTextField detailsCipherText;
	private JTextArea detailsComment;
	private JLabel counter;
	
	private Element currentElement;
	private List<Element> accountsList;
	
	public ButtonLastAccountListener(JFrame frame,CurrentAcountItem itemAnchor,
			JTextField detailsAccount,JTextField detailsDetails,JTextField detailsAttribute,
			JTextField detailsPassword,JTextField detailsCipherText,JTextArea detailsComment
			,JLabel counter) {
		this.frame = frame;
		this.itemAnchor = itemAnchor;
		this.detailsAccount = detailsAccount;
		this.detailsDetails = detailsDetails;
		this.detailsAttribute = detailsAttribute;
		this.detailsPassword = detailsPassword;
		this.detailsCipherText = detailsCipherText;
		this.detailsComment = detailsComment;
		this.counter = counter;
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
				accountsList = itemAnchor.getAccountsList();
				if(accountsList.size() == 0){
					
				}else{
					if(itemAnchor.getAccountAnchor() > 0){
						itemAnchor.setAccountAnchor(itemAnchor.getAccountAnchor() - 1);
						currentElement = accountsList.get(itemAnchor.getAccountAnchor());
						
						detailsAccount.setText(currentElement.getChildText("accont"));
						detailsDetails.setText(currentElement.getChildText("description"));
						detailsAttribute.setText(currentElement.getChildText("attribute"));
						detailsCipherText.setText(currentElement.getChildText("ciphertext"));
						detailsComment.setText(currentElement.getChildText("comment"));
						detailsPassword.setText("");
						
						detailsAccount.setEditable(false);
						detailsDetails.setEditable(false);
						detailsAttribute.setEditable(false);
						detailsPassword.setEditable(false);
						detailsCipherText.setEditable(false);
						detailsComment.setEditable(false);
						detailsComment.setBackground(new Color(240, 240, 240));
						counter.setText(String.valueOf(itemAnchor.getAccountAnchor() + 1));
					}else if(itemAnchor.getAccountAnchor() == 0){
						counter.setText(String.valueOf(itemAnchor.getAccountAnchor() + 1));
						Toolkit.getDefaultToolkit().beep();
						JOptionPane.showMessageDialog(frame, "这是第一个账号！", 
								"信息", JOptionPane.INFORMATION_MESSAGE);
					}
				}				
			}
		}	
	}
}
