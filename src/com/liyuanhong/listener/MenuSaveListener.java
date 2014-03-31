package com.liyuanhong.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.liyuanhong.util.CurrentAcountItem;

public class MenuSaveListener implements ActionListener{
	private JFrame frame;	
	private CurrentAcountItem itemAnchor;
	
	public MenuSaveListener(JFrame frame, CurrentAcountItem itemAnchor) {
		super();
		this.frame = frame;
		this.itemAnchor = itemAnchor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(itemAnchor.getDocument() == null){
			
		}else{
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
	        try {
				outputter.output(itemAnchor.getDocument(),new FileWriter(
						itemAnchor.getAccountFile()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
		}				
	}
}
