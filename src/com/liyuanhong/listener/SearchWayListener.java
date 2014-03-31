package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import com.liyuanhong.util.SearchWay;

public class SearchWayListener extends MouseAdapter{
	private JFrame frame;
	private JRadioButton searchByAccountRadioButton;
	private JRadioButton searchBySpecifyRadioButton;
	
	//1,2分别表示按账号和按说明
	private SearchWay searchWay;
	
	private JRadioButton radioButton;
	
	public SearchWayListener(JFrame frame,JRadioButton searchByAccountRadioButton,
			JRadioButton searchBySpecifyRadioButton,SearchWay searchWay) {
		this.frame = frame;
		this.searchByAccountRadioButton = searchByAccountRadioButton;
		this.searchBySpecifyRadioButton = searchBySpecifyRadioButton;
		this.searchWay = searchWay;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		radioButton = (JRadioButton)e.getSource();
		
		if(searchByAccountRadioButton.equals(radioButton)){
			searchWay.setSearchWay(1);
		}else if(searchBySpecifyRadioButton.equals(radioButton)){
			searchWay.setSearchWay(2);
		}
	}
}
