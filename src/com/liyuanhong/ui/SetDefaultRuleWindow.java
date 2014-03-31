package com.liyuanhong.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.liyuanhong.listener.Win2DefaultRuleRadioListener;
import com.liyuanhong.listener.Win2SelectRuleButtonListener;
import com.liyuanhong.listener.Win2SetDefaultButtonListener;
import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.util.RulesBean;
import com.liyuanhong.util.Win2LoadSysRules;
import com.liyuanhong.util.Win2SelectCategory;

public class SetDefaultRuleWindow {
	private static RulesBean rulesBean;

	public JFrame frame;
	private JTextField rulePathField;
	private static SetDefaultRuleWindow instance;
	private Win2SelectCategory selectCategory = new Win2SelectCategory();
	private Map<String, AbstrackRule> rulesMap = new LinkedHashMap<String, AbstrackRule>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SetDefaultRuleWindow window = new SetDefaultRuleWindow(rulesBean);
////					SetDefaultRuleWindow window = SetDefaultRuleWindow.getInstance();
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
	private SetDefaultRuleWindow(RulesBean rulesBean) {
		initialize(rulesBean);
	}
	
	public static SetDefaultRuleWindow getInstance(RulesBean rulesBean){		
		if(instance == null){
			instance = new SetDefaultRuleWindow(rulesBean);
		}
		return instance;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(RulesBean rulesBean) {
		this.rulesBean = rulesBean;
		frame = new JFrame();
		frame.setTitle("\u8BBE\u7F6E\u9ED8\u8BA4\u89C4\u5219");
		frame.setResizable(false);
		frame.setBounds(100, 100, 443, 276);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u5F53\u524D\u9ED8\u8BA4\u89C4\u5219\uFF1A");
		label.setFont(new Font("宋体", Font.BOLD, 12));
		label.setBounds(10, 10, 93, 15);
		frame.getContentPane().add(label);
		
		JLabel currentRuleLabel = new JLabel("\u5012\u5E8F\u89C4\u5219");
		currentRuleLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		currentRuleLabel.setForeground(Color.BLUE);
		currentRuleLabel.setBounds(116, 10, 308, 15);
		frame.getContentPane().add(currentRuleLabel);
		
		JRadioButton sysRuleRadioButton = new JRadioButton("\u9009\u62E9\u7CFB\u7EDF\u89C4\u5219");
		sysRuleRadioButton.setFont(new Font("宋体", Font.BOLD, 12));
		sysRuleRadioButton.setSelected(true);
		sysRuleRadioButton.setBounds(6, 41, 121, 23);
		frame.getContentPane().add(sysRuleRadioButton);
		
		JRadioButton sefRuleRadioButton = new JRadioButton("\u9009\u62E9\u81EA\u5B9A\u4E49\u89C4\u5219");
		sefRuleRadioButton.setFont(new Font("宋体", Font.BOLD, 12));
		sefRuleRadioButton.setBounds(129, 41, 121, 23);
		frame.getContentPane().add(sefRuleRadioButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 308, 112);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("宋体", Font.BOLD, 12));
		scrollPane.setViewportView(list);
		
		JButton FinishSetButton = new JButton("\u8BBE\u5B9A");
		FinishSetButton.setFont(new Font("宋体", Font.BOLD, 12));
		FinishSetButton.setBounds(328, 68, 93, 114);
		frame.getContentPane().add(FinishSetButton);
		
		rulePathField = new JTextField();
		rulePathField.setEnabled(false);
		rulePathField.setFont(new Font("宋体", Font.PLAIN, 12));
		rulePathField.setBounds(10, 204, 308, 21);
		frame.getContentPane().add(rulePathField);
		rulePathField.setColumns(10);
		
		JButton selectRuleButton = new JButton("\u9009\u62E9\u89C4\u5219");
		selectRuleButton.setEnabled(false);
		selectRuleButton.setFont(new Font("宋体", Font.BOLD, 12));
		selectRuleButton.setBounds(328, 203, 93, 23);
		frame.getContentPane().add(selectRuleButton);
		
		//将选择规则类型的button添加到组里面
		ButtonGroup ruleSelect = new ButtonGroup();
		ruleSelect.add(sysRuleRadioButton);
		ruleSelect.add(sefRuleRadioButton);
		
		//添加listener
		sysRuleRadioButton.addMouseListener(new Win2DefaultRuleRadioListener(frame, list, 
				selectRuleButton, rulePathField,sysRuleRadioButton,sefRuleRadioButton,
				selectCategory));
		sefRuleRadioButton.addMouseListener(new Win2DefaultRuleRadioListener(frame, list, 
				selectRuleButton, rulePathField,sysRuleRadioButton,sefRuleRadioButton,
				selectCategory));
		FinishSetButton.addMouseListener(new Win2SetDefaultButtonListener(frame, rulesBean, 
				selectCategory, currentRuleLabel, list));
		selectRuleButton.addMouseListener(new Win2SelectRuleButtonListener(frame, rulesBean, 
				selectCategory, currentRuleLabel, rulePathField));
		//自动执行的一个服务
		Win2LoadSysRules loadSysRules = new Win2LoadSysRules(frame, list, selectCategory,rulesMap
				,rulesBean,currentRuleLabel);
		loadSysRules.loadSysRules();
	}
}
