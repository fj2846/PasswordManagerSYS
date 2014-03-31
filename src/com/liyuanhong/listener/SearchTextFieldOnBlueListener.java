package com.liyuanhong.listener;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.liyuanhong.util.SearchTextState;

public class SearchTextFieldOnBlueListener extends FocusAdapter{
	private JFrame frame;
	private JTextField searchTextfield;
	private SearchTextState searchTextState;
	
	public SearchTextFieldOnBlueListener(JFrame frame,JTextField searchTextfield,
			SearchTextState searchTextState) {
		this.frame = frame;
		this.searchTextfield = searchTextfield;
		this.searchTextState = searchTextState;
	}
	@Override
	public void focusLost(FocusEvent e) {
		super.focusLost(e);
		super.focusGained(e);
		if(searchTextState.isEmpty()){
			searchTextfield.setText("ËÑË÷");
			searchTextfield.setForeground(Color.LIGHT_GRAY);
			searchTextState.setEmpty(true);
		}else{
			
		}
	}
}
