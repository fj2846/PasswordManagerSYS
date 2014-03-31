package com.liyuanhong.listener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.liyuanhong.util.CurrentAcountItem;
import com.liyuanhong.util.SearchListNum;
import com.liyuanhong.util.SearchTextState;
import com.liyuanhong.util.SearchWay;

public class MenuRightDelete implements ActionListener{
	private JFrame frame;	
	private JTextField searchTextfield;
	private CurrentAcountItem itemAnchor;
	private JTextField detailsAccount;
	private JTextField detailsDetails;
	private JTextField detailsAttribute;
	private JTextField detailsPassword;
	private JTextField detailsCipherText;
	private JTextArea detailsComment;
	private JLabel counter;
	private JList searchReasults;
	private SearchListNum searchResultNumList;
	private SearchWay searchWay;
	private SearchTextState searchTextState;
	
	private Element currentElement;
	private List<Element> accountsList;
	private Vector<String> results = new Vector<String>();
	private int okOrCancle;

	public MenuRightDelete(JFrame frame, CurrentAcountItem itemAnchor,
			JTextField detailsAccount, JTextField detailsDetails,
			JTextField detailsAttribute, JTextField detailsPassword,
			JTextField detailsCipherText, JTextArea detailsComment, JLabel counter,
			JList searchReasults, SearchListNum searchResultNumList,JTextField searchTextfield,
			SearchWay searchWay,SearchTextState searchTextState) {
		super();
		this.frame = frame;
		this.itemAnchor = itemAnchor;
		this.detailsAccount = detailsAccount;
		this.detailsDetails = detailsDetails;
		this.detailsAttribute = detailsAttribute;
		this.detailsPassword = detailsPassword;
		this.detailsCipherText = detailsCipherText;
		this.detailsComment = detailsComment;
		this.counter = counter;
		this.searchReasults = searchReasults;
		this.searchResultNumList = searchResultNumList;
		this.searchTextfield = searchTextfield;
		this.searchWay = searchWay;
		this.searchTextState = searchTextState;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().beep();
		Object[] options = { "确定", "取消" };   
		okOrCancle = JOptionPane.showOptionDialog(null, "确定要删除该账号吗！", "警告",    
		    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,    
		    null, options, options[0]);  
				
		if(okOrCancle == JOptionPane.OK_OPTION){
			//删除一个用户
			int _deleteLocation = (int)searchResultNumList.getSearchResultNum().
					get(searchReasults.getSelectedIndex());
			
			results.clear();
			searchResultNumList.getSearchResultNum().clear();
			
			itemAnchor.getDocument().getRootElement().getChildren().remove(_deleteLocation);			
			accountsList = itemAnchor.getDocument().getRootElement().getChildren();
			itemAnchor.setAccountsList(accountsList);
			changeCurrentStation(_deleteLocation, accountsList);
			
			
			//重新设置列表框	
			RefreshSearchResults();
			searchReasults.setListData(results);
			//将删除后的用户列表写入文件			
			if(accountsList.size() != 0){
				counter.setText(String.valueOf(itemAnchor.getAccountAnchor() + 1));
				itemAnchor.setAccountsList(itemAnchor.getDocument().
						getRootElement().getChildren());
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
			}else{
				detailsAccount.setText("");
				detailsDetails.setText("");
				detailsAttribute.setText("");
				detailsCipherText.setText("");
				detailsComment.setText("");
				counter.setText("0");
				
				XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		        try {
					outputter.output(itemAnchor.getDocument(),new FileWriter(
							itemAnchor.getAccountFile()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}	
		}else{
			
		}
	}
	
	private void changeCurrentStation(int _deleteLocation,List<Element> accountsList){
		if(_deleteLocation > itemAnchor.getAccountAnchor()){
			itemAnchor.setMaxSize(accountsList.size());
		}else if(_deleteLocation <= itemAnchor.getAccountAnchor()){
			itemAnchor.setMaxSize(accountsList.size());
			if(itemAnchor.getAccountAnchor() == 0){
				if(accountsList.size() != 0){
					itemAnchor.setAccountAnchor(itemAnchor.getAccountAnchor());
					counter.setText(String.valueOf(itemAnchor.getAccountAnchor() + 1));
				}				
			}else{
				itemAnchor.setAccountAnchor(itemAnchor.getAccountAnchor() - 1);
				counter.setText(String.valueOf(itemAnchor.getAccountAnchor() + 1));
			}
		}
	}
	
	private void RefreshSearchResults(){
		String keyword = "";
		if(searchTextState.isEmpty()){
			for(int i = 0;i < accountsList.size();i++){
				currentElement = accountsList.get(i);
				if(searchWay.getSearchWay() == 1){
					String _getText = currentElement.getChildText("accont");
					if(_getText.contains(keyword)){
						searchResultNumList.getSearchResultNum().add(i);
						results.add(_getText);
					}
				}else if(searchWay.getSearchWay() == 2){
					String _getText = currentElement.getChildText("description");
					if(_getText.contains(keyword)){
						searchResultNumList.getSearchResultNum().add(i);
						results.add(_getText);
					}
				}				
			}	
		}else{
			keyword = searchTextfield.getText();
			for(int i = 0;i < accountsList.size();i++){
				currentElement = accountsList.get(i);
				if(searchWay.getSearchWay() == 1){
					String _getText = currentElement.getChildText("accont");
					if(_getText.contains(keyword)){
						searchResultNumList.getSearchResultNum().add(i);
						results.add(_getText);
					}
				}else if(searchWay.getSearchWay() == 2){
					String _getText = currentElement.getChildText("description");
					if(_getText.contains(keyword)){
						searchResultNumList.getSearchResultNum().add(i);
						results.add(_getText);
					}
				}				
			}	
		}
	}
}
