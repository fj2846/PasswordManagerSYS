package com.liyuanhong.listener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.liyuanhong.util.CurrentAcountItem;

public class MenuCurrentFileListener implements ActionListener{
	private JFrame frame;
	private CurrentAcountItem itemAnchor;
	
	private File accountFile;

	public MenuCurrentFileListener(JFrame frame, CurrentAcountItem itemAnchor) {
		super();
		this.frame = frame;
		this.itemAnchor = itemAnchor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		accountFile = itemAnchor.getAccountFile();
		if(accountFile == null){
			
		}else{
			String fileInfo = accountFile.getAbsolutePath();
			Toolkit.getDefaultToolkit().beep();
			JOptionPane.showMessageDialog(frame, "当前文件：" + fileInfo, 
					"信息", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
