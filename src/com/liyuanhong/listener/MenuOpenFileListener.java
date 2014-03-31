package com.liyuanhong.listener;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.liyuanhong.util.CurrentAcountItem;

public class MenuOpenFileListener implements ActionListener{
	private File accountFile;
	private JFrame frame;
	private JTextField detailsAccount;
	private JTextField detailsDetails;
	private JTextField detailsAttribute;
	private JTextField detailsPassword;
	private JTextField detailsCipherText;
	private JTextArea detailsComment;
	private CurrentAcountItem itemAnchor;
	private JLabel counter;
	
	
	private FileDialog fileDialog;
	private String filePath;
	private String fileName;
	private SAXBuilder bulider;
	private Document document;
	private List<Element> accountsList;
	
	
	private JButton accDetails;
	private JButton accAdd;
	private JButton accTranslate;
	private JButton accCreateRules;
	private JPanel panel;
	private CardLayout cardLayout;
	
	
	public MenuOpenFileListener(JFrame frame,JTextField detailsAccount,
			JTextField detailsDetails,JTextField detailsAttribute,JTextField detailsPassword,
			JTextField detailsCipherText,JTextArea detailsComment,
			JButton accDetails,JButton accAdd,JButton accTranslate,JButton accCreateRules,
			JPanel panel,CardLayout cardLayout,CurrentAcountItem itemAnchor,
			JLabel counter) {
		this.frame = frame;
		this.detailsAccount = detailsAccount;
		this.detailsDetails = detailsDetails;
		this.detailsAttribute = detailsAttribute;
		this.detailsPassword = detailsPassword;
		this.detailsCipherText = detailsCipherText;
		this.detailsComment = detailsComment;
		this.accDetails = accDetails;
		this.accAdd = accAdd;
		this.panel = panel;
		this.accTranslate = accTranslate;
		this.accCreateRules = accCreateRules;
		this.cardLayout = cardLayout;
		this.itemAnchor = itemAnchor;
		this.counter = counter;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		fileDialog = new FileDialog(frame);
		fileDialog.show();
		filePath = fileDialog.getDirectory();
		fileName = fileDialog.getFile();
		bulider = new SAXBuilder();  
		if(filePath == null || fileName == null){
			
		}else{
			File file;
			try {
				file = new File(filePath + fileName);
				try{
					document = bulider.build(new FileReader(file));
				}catch(Exception ee){
					document = bulider.build(file);
				}		
				itemAnchor.setAccountFile(file);
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(frame, "文件格式错误！", "错误", JOptionPane.ERROR_MESSAGE);
			}  
			
			Element rootElement = document.getRootElement();
			accountsList = rootElement.getChildren();
			itemAnchor.setMaxSize(accountsList.size());
			itemAnchor.setAccountAnchor(0);
			itemAnchor.setDocument(document);
			itemAnchor.setAccountsList(accountsList);
			if(accountsList.size() == 0){
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(frame, "您目前没有账号！", 
						"信息", JOptionPane.INFORMATION_MESSAGE);
			}else{
				Element firstElement = accountsList.get(0);
				counter.setText(String.valueOf(itemAnchor.getAccountAnchor() + 1));
				
				detailsAccount.setText(firstElement.getChildText("accont"));
				detailsDetails.setText(firstElement.getChildText("description"));
				detailsAttribute.setText(firstElement.getChildText("attribute"));
				detailsCipherText.setText(firstElement.getChildText("ciphertext"));
				detailsComment.setText(firstElement.getChildText("comment"));
				detailsPassword.setText("");
				
				detailsAccount.setEditable(false);
				detailsDetails.setEditable(false);
				detailsAttribute.setEditable(false);
				detailsPassword.setEditable(false);
				detailsCipherText.setEditable(false);
				detailsComment.setEditable(false);
				detailsComment.setBackground(new Color(240, 240, 240));
				
				accDetails.setForeground(Color.RED);
				accAdd.setForeground(Color.BLACK);
				accTranslate.setForeground(Color.BLACK);
				accCreateRules.setForeground(Color.BLACK);
				cardLayout.show(panel, "accDetailsPanel");
			}
		}       
	}
}
