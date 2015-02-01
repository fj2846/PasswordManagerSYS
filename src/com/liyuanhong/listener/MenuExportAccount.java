package com.liyuanhong.listener;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

import javax.swing.JFrame;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.liyuanhong.util.CurrentAcountItem;

public class MenuExportAccount implements ActionListener{
	private JFrame frame;	
	private CurrentAcountItem itemAnchor;
	private File newFile;	
	private FileDialog fileDialog;
	private String filePath;
	private String fileName;
	private Document doc;
	
	public MenuExportAccount(JFrame frame,CurrentAcountItem itemAnchor) {
		this.frame = frame;
		this.itemAnchor = itemAnchor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fileDialog = new FileDialog(frame, "", FileDialog.SAVE);
		fileDialog.show();
		filePath = fileDialog.getDirectory();
		fileName = fileDialog.getFile();
		
		if(fileName == null || filePath == null){
			
		}else{			
			createExcel(filePath + fileName + ".xls");	
		}			
	}
	
	private void createExcel(String file){
		Workbook wb = new HSSFWorkbook();
	    FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream(file);
			CreationHelper createHelper = wb.getCreationHelper();
		    Sheet sheet1 = wb.createSheet("sheet1");
		    
		    Row row = sheet1.createRow((short)0);
		    
		    Font font = wb.createFont();
		    font = wb.createFont();
		    font.setBold(true);
		    CellStyle style = wb.createCellStyle();
		    style.setFont(font);
		    
		    // Create a cell and put a value in it.
		    Cell account = row.createCell(0);
		    account.setCellStyle(style);
		    account.setCellValue("账号");

		    // Or do it on one line.
		    Cell illustrate = row.createCell(1);
		    illustrate.setCellStyle(style);
		    illustrate.setCellValue("说明");
		    
		    Cell attribute = row.createCell(2);
		    attribute.setCellStyle(style);
		    attribute.setCellValue("属性");
		    
		    Cell ciphertext = row.createCell(3);
		    ciphertext.setCellStyle(style);
		    ciphertext.setCellValue("密文");
		    
		    Cell more = row.createCell(4);
		    more.setCellStyle(style);
		    more.setCellValue("备注");
		    
		    parseFile(sheet1);
		    
			wb.write(fileOut);
		    fileOut.close();    
		    
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("aaaaaaaaaa");
		}  
	}
	
	public void parseFile(Sheet sheet1){
		SAXBuilder builder = new SAXBuilder();
		File file = new File("accont.xml");
		Document document = itemAnchor.getDocument();
		if(document == null){
			
		}else{
			Element root = document.getRootElement();
			try {
				root = document.getRootElement();
				Iterator<Element> ite = root.getChildren().iterator();
				
				for(int i = 0;ite.hasNext();){
					Element ele = ite.next();
					Iterator<Element> ite1 = ele.getChildren().iterator();
					Row row = sheet1.createRow((short)++i);
					for(;ite1.hasNext();){
						Element ele1 = ite1.next();
						writeToExcel(row, ele1);
//						System.out.println(ele1.getText());
					}
				}
		} catch (Exception e) {
				e.printStackTrace();
			}
		}			
	}
		
		public static void writeToExcel(Row row,Element ele1){
			if(ele1.getName() == "description"){
				Cell illustrate = row.createCell(1);
			    illustrate.setCellValue(ele1.getText());
			}else if(ele1.getName() == "accont"){
				Cell account = row.createCell(0);
			    account.setCellValue(ele1.getText());
			}else if(ele1.getName() == "ciphertext"){
				Cell ciphertext = row.createCell(3);
			    ciphertext.setCellValue(ele1.getText());
			}else if(ele1.getName() == "attribute"){
				Cell attribute = row.createCell(2);
			    attribute.setCellValue(ele1.getText());
			}else if(ele1.getName() == "comment"){
				Cell more = row.createCell(4);
			    more.setCellValue(ele1.getText());
			}
		}

}
