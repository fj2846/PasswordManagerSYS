package com.liyuanhong.listener;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.liyuanhong.util.SearchTextState;

public class SearchTextFieldFocusListener extends FocusAdapter{
	private JFrame frame;
	private JTextField searchTextfield;
	private SearchTextState searchTextState;
	
	public SearchTextFieldFocusListener(JFrame frame,JTextField searchTextfield,
			SearchTextState searchTextState) {
		this.frame = frame;
		this.searchTextfield = searchTextfield;
		this.searchTextState = searchTextState;
	}
	@Override
	public void focusGained(FocusEvent e) {
		super.focusGained(e);
		if(searchTextState.isEmpty()){
			searchTextfield.setText("");
			searchTextfield.setForeground(Color.BLACK);
		}else{
			
		}	
	}
}
