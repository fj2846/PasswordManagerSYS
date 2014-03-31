package com.liyuanhong.listener;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jdom2.Element;

import com.liyuanhong.util.CurrentAcountItem;
import com.liyuanhong.util.SearchListNum;
import com.liyuanhong.util.SearchTextState;
import com.liyuanhong.util.SearchWay;

public class SearchTextFieldInputListener implements DocumentListener{
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
	private SearchTextState searchTextState;
	private SearchListNum searchResultNumList;
	private SearchWay searchWay;
	
	private Element currentElement;
	private List<Element> accountsList;
	private Vector<String> results = new Vector<String>();
	private String keyword;
	
	public SearchTextFieldInputListener(JFrame frame,JTextField searchTextfield,
			CurrentAcountItem itemAnchor,JTextField detailsAccount,JTextField detailsDetails
			,JTextField detailsAttribute,JTextField detailsPassword,JTextField detailsCipherText
			,JTextArea detailsComment,JLabel counter,JList searchReasults,
			SearchTextState searchTextState,SearchListNum searchResultNumList,
			SearchWay searchWay) {
		this.frame = frame;
		this.searchTextfield = searchTextfield;
		this.itemAnchor = itemAnchor;
		this.detailsAccount = detailsAccount;
		this.detailsDetails = detailsDetails;
		this.detailsAttribute = detailsAttribute;
		this.detailsPassword = detailsPassword;
		this.detailsCipherText = detailsCipherText;
		this.detailsComment = detailsComment;
		this.counter = counter;
		this.searchReasults =searchReasults;
		this.searchTextState = searchTextState;
		this.searchResultNumList = searchResultNumList;
		this.searchWay = searchWay;
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		if(itemAnchor.getAccountFile() == null){
			//没有打开文件的时候什么也不做
		}else{
			if(searchTextfield.getText().equals("")){				
				
			}else{
				searchTextState.setEmpty(false);
				searchResultNumList.getSearchResultNum().clear();
				results.clear();
				accountsList = itemAnchor.getAccountsList();
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
				searchReasults.setListData(results);
			}	
		}						
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if(itemAnchor.getAccountFile() == null){
			//没有打开文件的时候什么也不做
		}else{
			if(searchTextfield.getText().equals("")){
				searchTextState.setEmpty(true);
				searchResultNumList.getSearchResultNum().clear();
				results.clear();
				searchReasults.setListData(results);
			}else{
				searchTextState.setEmpty(false);
				searchResultNumList.getSearchResultNum().clear();
				results.clear();
				accountsList = itemAnchor.getAccountsList();
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
				searchReasults.setListData(results);
			}	
		}
	}
}
