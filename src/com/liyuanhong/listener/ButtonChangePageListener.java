package com.liyuanhong.listener;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonChangePageListener extends MouseAdapter{
	private JButton accDetails;
	private JButton accAdd;
	private JButton accTranslate;
	private JButton accCreateRules;
	private JPanel panel;
	private CardLayout cardLayout;
	
	public ButtonChangePageListener(JButton accDetails,JButton accAdd,JButton accTranslate,
			JButton accCreateRules,CardLayout cardLayout,JPanel panel) {
		this.accDetails = accDetails;
		this.accAdd = accAdd;
		this.accTranslate = accTranslate;
		this.accCreateRules = accCreateRules;
		this.cardLayout = cardLayout;
		this.panel = panel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			if(e.getSource().equals(accDetails)){
				accDetails.setForeground(Color.RED);
				accAdd.setForeground(Color.BLACK);
				accTranslate.setForeground(Color.BLACK);
				accCreateRules.setForeground(Color.BLACK);
				cardLayout.show(panel, "accDetailsPanel");
			}else if(e.getSource().equals(accAdd)){
				accDetails.setForeground(Color.BLACK);
				accAdd.setForeground(Color.RED);
				accTranslate.setForeground(Color.BLACK);
				accCreateRules.setForeground(Color.BLACK);
				cardLayout.show(panel, "accAddPanel");
			}else if(e.getSource().equals(accTranslate)){
				accDetails.setForeground(Color.BLACK);
				accAdd.setForeground(Color.BLACK);
				accTranslate.setForeground(Color.RED);
				accCreateRules.setForeground(Color.BLACK);
				cardLayout.show(panel, "accTranslatePanel");
			}else if(e.getSource().equals(accCreateRules)){
				accDetails.setForeground(Color.BLACK);
				accAdd.setForeground(Color.BLACK);
				accTranslate.setForeground(Color.BLACK);
				accCreateRules.setForeground(Color.RED);
				cardLayout.show(panel, "accCreateRulesPanel");
			}
		}
	}
}
