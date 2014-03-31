package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdom2.Element;

import com.liyuanhong.util.CurrentAcountItem;
import com.liyuanhong.util.SearchListNum;
import com.liyuanhong.util.SearchTextState;
import com.liyuanhong.util.SearchWay;

public class ButtonSearchListener extends MouseAdapter{
	private JFrame frame;
	private JTextField searchTextfield;
	private CurrentAcountItem itemAnchor;
	private JList searchReasults;
	private SearchTextState searchTextState;
	private SearchListNum searchResultNumList;
	private SearchWay searchWay;
	
	private Element currentElement;
	private List<Element> accountsList;
	private Vector<String> results = new Vector<String>();
	private String keyword;
	
	public ButtonSearchListener(JFrame frame,JTextField searchTextfield,
			CurrentAcountItem itemAnchor,JList searchReasults,
			SearchTextState searchTextState,SearchListNum searchResultNumList,
			SearchWay searchWay) {
		this.frame = frame;
		this.searchTextfield = searchTextfield;
		this.itemAnchor = itemAnchor;
		this.searchReasults =searchReasults;
		this.searchTextState = searchTextState;
		this.searchResultNumList = searchResultNumList;
		this.searchWay = searchWay;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			if(itemAnchor.getAccountFile() == null){
				//没有打开文件的时候什么也不做
			}else{
				if(searchTextState.isEmpty()){
					searchResultNumList.getSearchResultNum().clear();
					results.clear();
					accountsList = itemAnchor.getAccountsList();
					keyword = "";
					
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
				}else{
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
}
