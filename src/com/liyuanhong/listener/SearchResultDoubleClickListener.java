package com.liyuanhong.listener;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdom2.Element;

import com.liyuanhong.util.CurrentAcountItem;
import com.liyuanhong.util.SearchListNum;

public class SearchResultDoubleClickListener extends MouseAdapter{
	private JFrame frame;
	private JButton accDetails;
	private JButton accAdd;
	private JButton accTranslate;
	private JButton accCreateRules;
	private JPanel panel;
	private CardLayout cardLayout;
	private CurrentAcountItem itemAnchor;
	private JTextField detailsAccount;
	private JTextField detailsDetails;
	private JTextField detailsAttribute;
	private JTextField detailsPassword;
	private JTextField detailsCipherText;
	private JTextArea detailsComment;
	private JLabel counter;
	private SearchListNum searchResultNumList;
	private JList searchReasults;
	
	private Element currentElement;
	private List<Element> accountsList;
	
	public SearchResultDoubleClickListener(JFrame frame,JButton accDetails,JButton accAdd,
			JButton accTranslate,JButton accCreateRules,JPanel panel,
			CardLayout cardLayout,CurrentAcountItem itemAnchor,JTextField detailsAccount,
			JTextField detailsDetails,JTextField detailsAttribute,JTextField detailsPassword
			,JTextField detailsCipherText,JTextArea detailsComment,JLabel counter,
			SearchListNum searchResultNumList,JList searchReasults) {
		this.frame = frame;
		this.accDetails = accDetails;
		this.accAdd = accAdd;
		this.accTranslate = accTranslate;
		this.accCreateRules = accCreateRules;
		this.panel = panel;
		this.cardLayout = cardLayout;
		this.itemAnchor = itemAnchor;
		this.detailsAccount = detailsAccount;
		this.detailsDetails = detailsDetails;
		this.detailsAttribute = detailsAttribute;
		this.detailsPassword = detailsPassword;
		this.detailsCipherText = detailsCipherText;
		this.detailsComment = detailsComment;
		this.counter = counter;
		this.searchResultNumList = searchResultNumList;
		this.searchReasults = searchReasults;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			if(e.getButton() == MouseEvent.BUTTON1){
				if(e.getClickCount() == 2){
					if(searchResultNumList.getSearchResultNum().size() != 0){
						int _listNum = searchReasults.getSelectedIndex();
						int _whereInResults = (Integer)searchResultNumList.getSearchResultNum().
								get(_listNum);
						accDetails.setForeground(Color.RED);
						accAdd.setForeground(Color.BLACK);
						accTranslate.setForeground(Color.BLACK);
						accCreateRules.setForeground(Color.BLACK);
						if(e.getSource().equals(accDetails)){
							cardLayout.show(panel, "accDetailsPanel");
						}else if(e.getSource().equals(accAdd)){
							cardLayout.show(panel, "accAddPanel");
						}else if(e.getSource().equals(accTranslate)){
							cardLayout.show(panel, "accTranslatePanel");
						}else if(e.getSource().equals(accCreateRules)){
							cardLayout.show(panel, "accCreateRulesPanel");
						}
						
						accountsList = itemAnchor.getAccountsList();
						currentElement = accountsList.get(_whereInResults);
						itemAnchor.setAccountAnchor(_whereInResults);
						
						detailsAccount.setText(currentElement.getChildText("accont"));
						detailsDetails.setText(currentElement.getChildText("description"));
						detailsAttribute.setText(currentElement.getChildText("attribute"));
						detailsCipherText.setText(currentElement.getChildText("ciphertext"));
						detailsComment.setText(currentElement.getChildText("comment"));
						
						detailsAccount.setEditable(false);
						detailsDetails.setEditable(false);
						detailsAttribute.setEditable(false);
						detailsPassword.setEditable(false);
						detailsCipherText.setEditable(false);
						detailsComment.setEditable(false);
						detailsComment.setBackground(new Color(240, 240, 240));
						counter.setText(String.valueOf(itemAnchor.getAccountAnchor() + 1));
						
						cardLayout.show(panel, "accDetailsPanel");
					}
				}
			}	
		}
	}
}
