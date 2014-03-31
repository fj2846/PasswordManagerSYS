package com.liyuanhong.util;

import java.io.File;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;

public class CurrentAcountItem {
	private int accountAnchor;
	private int maxSize;
	private Document document;
	private File accountFile;
	private List<Element> accountsList;
	
	public int getAccountAnchor() {
		return accountAnchor;
	}
	public void setAccountAnchor(int accountAnchor) {
		this.accountAnchor = accountAnchor;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public List<Element> getAccountsList() {
		return accountsList;
	}
	public void setAccountsList(List<Element> accountsList) {
		this.accountsList = accountsList;
	}
	public File getAccountFile() {
		return accountFile;
	}
	public void setAccountFile(File accountFile) {
		this.accountFile = accountFile;
	}
}
