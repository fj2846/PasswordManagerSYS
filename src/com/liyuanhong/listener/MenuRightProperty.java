package com.liyuanhong.listener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import org.jdom2.Element;

import com.liyuanhong.util.CurrentAcountItem;

public class MenuRightProperty implements ActionListener{
	private JFrame frame;
	private CurrentAcountItem itemAnchor;
	private JList searchReasults;
	
	private Element currentElement;
	private List<Element> accountsList;
	private String accountText = "";
	private String detailsText = "";
	private String propertyText = "";
	
	public MenuRightProperty(JFrame frame, CurrentAcountItem itemAnchor,
			JList searchReasults) {
		super();
		this.frame = frame;
		this.itemAnchor = itemAnchor;
		this.searchReasults = searchReasults;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		accountsList = itemAnchor.getDocument().getRootElement().getChildren();
		currentElement = accountsList.get(searchReasults.getSelectedIndex());
		
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(frame, 
				"账号：" + currentElement.getChildText("accont") + "\n" 
				+ "说明：" + currentElement.getChildText("description") + "\n" 
				+ "属性：" + currentElement.getChildText("attribute") + "\n" ,
				"信息", JOptionPane.INFORMATION_MESSAGE);
	}

}
