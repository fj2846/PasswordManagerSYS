package com.liyuanhong.listener;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFrame;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.liyuanhong.util.CurrentAcountItem;

public class MenuSaveAsListener implements ActionListener{
	private JFrame frame;	
	private CurrentAcountItem itemAnchor;
	
	private File newFile;	
	private FileDialog fileDialog;
	private String filePath;
	private String fileName;
	private SAXBuilder bulider;
	private Document document;

	public MenuSaveAsListener(JFrame frame, CurrentAcountItem itemAnchor) {
		super();
		this.frame = frame;
		this.itemAnchor = itemAnchor;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		document = itemAnchor.getDocument();
		if(document == null){
			
		}else{
			fileDialog = new FileDialog(frame, "", FileDialog.SAVE);
			fileDialog.show();
			filePath = fileDialog.getDirectory();
			fileName = fileDialog.getFile();
			
			if(fileName == null || filePath == null){
				
			}else{			
				try {
					newFile = new File(filePath + fileName);
					itemAnchor.setAccountFile(newFile);
					bulider = new SAXBuilder();
					XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		            outputter.output(document,new FileWriter(newFile));		
				} catch (Exception e1) {
					e1.printStackTrace();
				}			
			}	
		}
	}
}
