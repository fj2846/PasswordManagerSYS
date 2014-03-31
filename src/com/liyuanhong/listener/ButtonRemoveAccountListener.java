package com.liyuanhong.listener;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.liyuanhong.util.CurrentAcountItem;

public class ButtonRemoveAccountListener extends MouseAdapter{
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
	private int removedItem;
	
	public ButtonRemoveAccountListener(JFrame frame,CurrentAcountItem itemAnchor,
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
				JOptionPane.showMessageDialog(frame, "û�д��κ��ļ���", 
						"������Ϣ", JOptionPane.ERROR_MESSAGE);
			}else{
				if(itemAnchor.getDocument().getRootElement().getChildren().size() == 0){
					
				}else{
					Object[] options = { "ȷ��", "ȡ��" };   
					int okOrCancl = JOptionPane.showOptionDialog(null, "ȷ��Ҫɾ�����˺���", "����",    
					    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,    
					    null, options, options[0]);
					if(okOrCancl == JOptionPane.OK_OPTION){
						removedItem = itemAnchor.getAccountAnchor();
						itemAnchor.getDocument().getRootElement().getChildren().remove(removedItem);
						accountsList = itemAnchor.getDocument().getRootElement().getChildren();
						itemAnchor.setMaxSize(accountsList.size());
						if(itemAnchor.getMaxSize() > itemAnchor.getAccountAnchor() + 1){	
							counter.setText(String.valueOf(itemAnchor.getAccountAnchor() + 1));
							itemAnchor.setAccountsList(itemAnchor.getDocument().
									getRootElement().getChildren());
							accountsList = itemAnchor.getDocument().getRootElement().getChildren();
							currentElement = accountsList.get(itemAnchor.getAccountAnchor());
							
							detailsAccount.setText(currentElement.getChildText("accont"));
							detailsDetails.setText(currentElement.getChildText("description"));
							detailsAttribute.setText(currentElement.getChildText("attribute"));
							detailsCipherText.setText(currentElement.getChildText("ciphertext"));
							detailsComment.setText(currentElement.getChildText("comment"));
							
							XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
					        try {
								outputter.output(itemAnchor.getDocument(),new FileWriter(
										itemAnchor.getAccountFile()));
							} catch (IOException e1) {
								e1.printStackTrace();
							}	
							Toolkit.getDefaultToolkit().beep();
							JOptionPane.showMessageDialog(frame, "�˺�ɾ���ɹ���", "ok", 
									JOptionPane.INFORMATION_MESSAGE);
						}else{
							if(itemAnchor.getMaxSize() == 0){	
								itemAnchor.setAccountAnchor(itemAnchor.getMaxSize() - 1);					
								counter.setText(String.valueOf(itemAnchor.getAccountAnchor() + 1));
								
								detailsAccount.setText("");
								detailsDetails.setText("");
								detailsAttribute.setText("");
								detailsCipherText.setText("");
								detailsComment.setText("");
								
								XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
						        try {
									outputter.output(itemAnchor.getDocument(),new FileWriter(
											itemAnchor.getAccountFile()));
								} catch (IOException e1) {
									e1.printStackTrace();
								}	
						        
								Toolkit.getDefaultToolkit().beep();
								JOptionPane.showMessageDialog(frame, "�˺�ɾ���ɹ�,Ŀǰû���˺��ˣ�", 
										"��Ϣ", JOptionPane.INFORMATION_MESSAGE);
							}else{
								itemAnchor.setAccountAnchor(itemAnchor.getMaxSize() - 1);
								itemAnchor.setAccountsList(itemAnchor.getDocument().
										getRootElement().getChildren());
								accountsList = itemAnchor.getDocument().getRootElement().getChildren();
								counter.setText(String.valueOf(itemAnchor.getAccountAnchor() + 1));
								currentElement = accountsList.get(itemAnchor.getAccountAnchor());
								
								detailsAccount.setText(currentElement.getChildText("accont"));
								detailsDetails.setText(currentElement.getChildText("description"));
								detailsAttribute.setText(currentElement.getChildText("attribute"));
								detailsCipherText.setText(currentElement.getChildText("ciphertext"));
								detailsComment.setText(currentElement.getChildText("comment"));
								
								XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
						        try {
									outputter.output(itemAnchor.getDocument(),new FileWriter(
											itemAnchor.getAccountFile()));
								} catch (IOException e1) {
									e1.printStackTrace();
								}	
								Toolkit.getDefaultToolkit().beep();
								JOptionPane.showMessageDialog(frame, "�˺�ɾ���ɹ���", "ok", 
										JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}else{
						
					}					
				}			
			}
		}
	}
}
