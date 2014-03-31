package com.liyuanhong.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.liyuanhong.util.TransformRuleUtil;

public class OrigToCipherButtonListener extends MouseAdapter{
	private JFrame frame;
	private JTextArea origTextArea;
	private JTextArea cipherTextArea;
	private TransformRuleUtil transformRule;
	
	public OrigToCipherButtonListener(JFrame frame, JTextArea origTextArea,
			JTextArea cipherTextArea,TransformRuleUtil transformRule) {
		super();
		this.frame = frame;
		this.origTextArea = origTextArea;
		this.cipherTextArea = cipherTextArea;
		this.transformRule = transformRule;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		if(e.getButton() == MouseEvent.BUTTON1){
			String str = origTextArea.getText();
			cipherTextArea.setText(transformRule.getTransformRule().changeToCiphertext(str));
		}		
	}
}
