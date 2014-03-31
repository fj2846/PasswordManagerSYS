package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.liyuanhong.util.CurrentAcountItem;
import com.liyuanhong.util.SearchListNum;

public class SearchResultsRightClickListener extends MouseAdapter{
	private JFrame frame;
	private SearchListNum searchResultNumList;
	private JList searchReasults;
	private JPopupMenu popupMenu;
	
	
	
	public SearchResultsRightClickListener(JFrame frame,SearchListNum searchResultNumList, 
			JList searchReasults,JPopupMenu popupMenu) {
		super();
		this.frame = frame;
		this.searchResultNumList = searchResultNumList;
		this.searchReasults = searchReasults;
		this.popupMenu = popupMenu;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		if(e.getButton() == MouseEvent.BUTTON3){
			if (e.isPopupTrigger()) {
				if(searchReasults.getSelectedIndex() != -1){
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}			
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		if(e.getButton() == MouseEvent.BUTTON3){
			if (e.isPopupTrigger()) {
				if(searchReasults.getSelectedIndex() != -1){
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		}
	}
}