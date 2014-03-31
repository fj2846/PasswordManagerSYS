package com.liyuanhong.listener;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.liyuanhong.util.CurrentAcountItem;

public class MenuNewAccountListener implements ActionListener{
	private File accountFile;
	private JFrame frame;
	private CurrentAcountItem itemAnchor;
	private JTextField detailsAccount;
	private JTextField detailsDetails;
	private JTextField detailsAttribute;
	private JTextField detailsPassword;
	private JTextField detailsCipherText;
	private JTextArea detailsComment;
	private JLabel counter;
	
	private File newFile;	
	private FileDialog fileDialog;
	private String filePath;
	private String fileName;
	private SAXBuilder bulider;
	private Document document;
	
	public MenuNewAccountListener(JFrame frame,CurrentAcountItem itemAnchor,
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
	public void actionPerformed(ActionEvent e) {
		fileDialog = new FileDialog(frame, "", FileDialog.SAVE);
		fileDialog.show();
		filePath = fileDialog.getDirectory();
		fileName = fileDialog.getFile();
		
		if(fileName == null || filePath == null){
			
		}else{
			try {
				newFile = new File(filePath + fileName);
				itemAnchor.setAccountFile(newFile);
				bulider = new SAXBuilder();
//				bulider.setFeature("\\accounts\\acountsDTD.dtd", true);
				document = new Document();			
				Element rootElement = new Element("acconts");
				Element acconterElement = new Element("acconter");
				Element accontElement = new Element("accont");
				Element descriptionElement = new Element("description");
				Element ciphertextElement = new Element("ciphertext");
				Element attributeElement = new Element("attribute");
				Element commentElement = new Element("comment");
				
				accontElement.setText("zhuoyue@me.com");
				descriptionElement.setText("这是一个测试账号");
				ciphertextElement.setText("knjhknh^*&yuuh%Rhj)_676GhjgUgt876UGbj%^*&g*%&g");
				attributeElement.setText("个人重要账户");
				commentElement.setText("每次新建文件会自动创建一个事例账户，可以在新建之后将其删掉");
				
				detailsAccount.setEditable(false);
				detailsDetails.setEditable(false);
				detailsAttribute.setEditable(false);
				detailsPassword.setEditable(false);
				detailsCipherText.setEditable(false);
				detailsComment.setEditable(false);
				detailsComment.setBackground(new Color(240, 240, 240));
				
				rootElement.addContent(acconterElement);
				acconterElement.addContent(accontElement);
				acconterElement.addContent(descriptionElement);
				acconterElement.addContent(ciphertextElement);
				acconterElement.addContent(attributeElement);
				acconterElement.addContent(commentElement);						
				document.setRootElement(rootElement);	
		
				itemAnchor.setDocument(document);			
				itemAnchor.setAccountFile(newFile);
				itemAnchor.setAccountsList(document.getRootElement().getChildren());
				
				Element firstElement = itemAnchor.getAccountsList().get(0);
				itemAnchor.setAccountAnchor(0);
				counter.setText(String.valueOf(itemAnchor.getAccountAnchor() + 1));
				
				detailsAccount.setText(firstElement.getChildText("accont"));
				detailsDetails.setText(firstElement.getChildText("description"));
				detailsAttribute.setText(firstElement.getChildText("attribute"));
				detailsCipherText.setText(firstElement.getChildText("ciphertext"));
				detailsComment.setText(firstElement.getChildText("comment"));
				detailsPassword.setText("");
				
				XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
	            outputter.output(document,new FileWriter(newFile));	
			} catch (Exception e1) {
				e1.printStackTrace();
			}	
		}
	}

}
