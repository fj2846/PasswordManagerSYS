package com.liyuanhong.ui;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.liyuanhong.listener.Win1CreateRuleButtonListener;
import com.liyuanhong.listener.Win1DeleteSelfRuleButtonListener;
import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.util.RulesBean;
import com.liyuanhong.util.Win1LoadSelfRule;

public class CreateMapRuleWindow {

	public JFrame frame;
	private JTextField ruleNameFiled;
	private static JList rulesListArea;
	private static RulesBean rulesBean;
	private static CreateMapRuleWindow instance;
	private JComboBox specifyRuleComboBox;
	private Map<String, AbstrackRule> selfRules = new LinkedHashMap<String, AbstrackRule>();
	private Map<String, File> selfFiles = new LinkedHashMap<String, File>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CreateMapRuleWindow window = new CreateMapRuleWindow(rulesListArea,rulesBean);
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	private  CreateMapRuleWindow(JList rulesListArea,RulesBean rulesBean,
			JComboBox specifyRuleComboBox) {
		initialize(rulesListArea,rulesBean,specifyRuleComboBox);
	}
	
	public static CreateMapRuleWindow getInstance(JList rulesListArea,RulesBean rulesBean,
			JComboBox specifyRuleComboBox){		
		if(instance == null){
			instance = new CreateMapRuleWindow(rulesListArea,rulesBean,specifyRuleComboBox);
		}
		return instance;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JList rulesListArea,RulesBean rulesBean,
			JComboBox specifyRuleComboBox) {
		this.rulesListArea = rulesListArea;
		this.rulesBean = rulesBean;
		this.specifyRuleComboBox = specifyRuleComboBox;
		frame = new JFrame();
		frame.setTitle("\u521B\u5EFA\u5BF9\u5E94\u89C4\u5219");
		frame.setResizable(false);
		frame.setBounds(100, 100, 527, 352);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u539F\u59CB\u5B57\u7B26\uFF1A");
		label.setBounds(10, 10, 65, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BF9\u5E94\u5B57\u7B26\uFF1A");
		label_1.setBounds(10, 73, 65, 15);
		frame.getContentPane().add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 10, 416, 60);
		frame.getContentPane().add(scrollPane);
		
		JTextArea orgTextArea = new JTextArea();
		scrollPane.setViewportView(orgTextArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(85, 73, 416, 60);
		frame.getContentPane().add(scrollPane_1);
		
		JTextArea oppTextArea = new JTextArea();
		scrollPane_1.setViewportView(oppTextArea);
		
		JLabel label_2 = new JLabel("\u89C4\u5219\u540D\u5B57\uFF1A");
		label_2.setBounds(10, 289, 65, 15);
		frame.getContentPane().add(label_2);
		
		ruleNameFiled = new JTextField();
		ruleNameFiled.setBounds(85, 286, 323, 21);
		frame.getContentPane().add(ruleNameFiled);
		ruleNameFiled.setColumns(10);
		
		JButton createRuleButton = new JButton("\u751F\u6210\u89C4\u5219");
		createRuleButton.setBounds(408, 285, 93, 23);
		frame.getContentPane().add(createRuleButton);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(85, 143, 323, 130);
		frame.getContentPane().add(scrollPane_2);
		
		JList list = new JList();
		scrollPane_2.setViewportView(list);
		
		JLabel label_3 = new JLabel("\u5217\u8868\uFF1A");
		label_3.setBounds(10, 145, 54, 15);
		frame.getContentPane().add(label_3);
		
		JButton deleteRuleButton = new JButton("\u5220\u9664\u89C4\u5219");
		deleteRuleButton.setBounds(408, 143, 93, 23);
		frame.getContentPane().add(deleteRuleButton);
		
		
		//添加监听程序
		createRuleButton.addMouseListener(new Win1CreateRuleButtonListener(frame, 
				orgTextArea, oppTextArea, ruleNameFiled,rulesBean,rulesListArea,
				specifyRuleComboBox,list,selfRules,selfFiles));
		deleteRuleButton.addMouseListener(new Win1DeleteSelfRuleButtonListener(frame, 
				list, selfRules, selfFiles,specifyRuleComboBox,rulesListArea,rulesBean));
		
		//添加初始化的一些服务
		Win1LoadSelfRule loadRules = new Win1LoadSelfRule(frame, list, selfRules,selfFiles);
		loadRules.loadDefaultRule();
	}
}
