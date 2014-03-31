package com.liyuanhong.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.liyuanhong.listener.AccountCategoryListener;
import com.liyuanhong.listener.AccountImportanceListener;
import com.liyuanhong.listener.AccountPanelAddOneListener;
import com.liyuanhong.listener.AccountPanelClearListener;
import com.liyuanhong.listener.AddAccPanelGetCipButtonListener;
import com.liyuanhong.listener.AddAccPanelGetOrgButtonListener;
import com.liyuanhong.listener.AddCreatRuleListener;
import com.liyuanhong.listener.ButtonChangePageListener;
import com.liyuanhong.listener.ButtonLastAccountListener;
import com.liyuanhong.listener.ButtonModifyAccountListener;
import com.liyuanhong.listener.ButtonModifyFinishListener;
import com.liyuanhong.listener.ButtonNextAccountListerner;
import com.liyuanhong.listener.ButtonRemoveAccountListener;
import com.liyuanhong.listener.ButtonSearchListener;
import com.liyuanhong.listener.CipherToOrigButtonListener;
import com.liyuanhong.listener.ClearAddRuleButtonListener;
import com.liyuanhong.listener.DeleteCreatRuleListener;
import com.liyuanhong.listener.ExitListener;
import com.liyuanhong.listener.FirstAccountListener;
import com.liyuanhong.listener.ImportCreateRuleListener;
import com.liyuanhong.listener.LastAccountListener;
import com.liyuanhong.listener.MenuCurrentFileListener;
import com.liyuanhong.listener.MenuNewAccountListener;
import com.liyuanhong.listener.MenuOpenFileListener;
import com.liyuanhong.listener.MenuRightCopy;
import com.liyuanhong.listener.MenuRightDelete;
import com.liyuanhong.listener.MenuRightProperty;
import com.liyuanhong.listener.MenuSaveAsListener;
import com.liyuanhong.listener.MenuSaveListener;
import com.liyuanhong.listener.MenuSetDefaultRuleListener;
import com.liyuanhong.listener.MenuShowCreateRuleWindowListener;
import com.liyuanhong.listener.OrigToCipherButtonListener;
import com.liyuanhong.listener.OtherRuleButtonListener;
import com.liyuanhong.listener.RadioSelectRuleToTransferListener;
import com.liyuanhong.listener.RunAddedRuleButtonListener;
import com.liyuanhong.listener.SaveCreateRuleListener;
import com.liyuanhong.listener.SearchResultDoubleClickListener;
import com.liyuanhong.listener.SearchResultsRightClickListener;
import com.liyuanhong.listener.SearchTextFieldFocusListener;
import com.liyuanhong.listener.SearchTextFieldInputListener;
import com.liyuanhong.listener.SearchTextFieldOnBlueListener;
import com.liyuanhong.listener.SearchWayListener;
import com.liyuanhong.listener.ShowOrgTextButtonListener;
import com.liyuanhong.listener.SpecifyRuleComboBoxListener;
import com.liyuanhong.listener.TextFieldEnterKeyListener;
import com.liyuanhong.util.AccountCategory;
import com.liyuanhong.util.CurrentAcountItem;
import com.liyuanhong.util.LoadRules;
import com.liyuanhong.util.RulesBean;
import com.liyuanhong.util.SearchListNum;
import com.liyuanhong.util.SearchTextState;
import com.liyuanhong.util.SearchWay;
import com.liyuanhong.util.TransformRuleUtil;

public class Main {
	private CurrentAcountItem itemAnchor = new CurrentAcountItem();   
	private AccountCategory category = new AccountCategory();
	private SearchTextState searchTextState = new SearchTextState();
	private SearchListNum searchResultNumList = new SearchListNum();
	private SearchWay searchWay = new SearchWay();
	private RulesBean rulesBean = new RulesBean();
	private TransformRuleUtil transformRule = new TransformRuleUtil();
	
	private JFrame frame;
	private JTextField searchTextfield;
	private JTextField accountText;
	private JTextField detailText;
	private JTextField passwordTest;
	private JTextField cipherText;
	private JTextField detailsAccount;
	private JTextField detailsDetails;
	private JTextField detailsAttribute;
	private JTextField detailsPassword;
	private JTextField detailsCipherText;
	private JTextField otherRuleFiled;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\u5BC6\u7801\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 793, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton accDetails = new JButton("\u8D26\u53F7\u660E\u7EC6");
		accDetails.setForeground(Color.RED);
		accDetails.setBounds(10, 10, 96, 23);
		frame.getContentPane().add(accDetails);
		
		JButton accAdd = new JButton("\u6DFB\u52A0\u8D26\u53F7");
		accAdd.setBounds(105, 10, 96, 23);
		frame.getContentPane().add(accAdd);
		
		JButton passTranslate = new JButton("\u5BC6\u7801\u67E5\u9605");
		passTranslate.setBounds(200, 10, 96, 23);
		frame.getContentPane().add(passTranslate);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 43, 546, 399);
		frame.getContentPane().add(panel);
		CardLayout cardLayout = new CardLayout(0, 0);
		panel.setLayout(cardLayout);
		
		JPanel accDetailsPanel = new JPanel();
		panel.add(accDetailsPanel, "accDetailsPanel");
		accDetailsPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setBounds(10, 10, 47, 15);
		accDetailsPanel.add(lblNewLabel_1);
		
		JLabel label_4 = new JLabel("\u8BF4\u660E\uFF1A");
		label_4.setBounds(10, 41, 47, 15);
		accDetailsPanel.add(label_4);
		
		JLabel label_5 = new JLabel("\u5C5E\u6027\uFF1A");
		label_5.setBounds(10, 74, 47, 15);
		accDetailsPanel.add(label_5);
		
		JLabel label_6 = new JLabel("\u539F\u6587\uFF1A");
		label_6.setBounds(10, 113, 47, 15);
		accDetailsPanel.add(label_6);
		
		JLabel label_7 = new JLabel("\u5BC6\u6587\uFF1A");
		label_7.setBounds(10, 148, 47, 15);
		accDetailsPanel.add(label_7);
		
		JLabel label_8 = new JLabel("\u5907\u6CE8\uFF1A");
		label_8.setBounds(10, 186, 47, 15);
		accDetailsPanel.add(label_8);
		
		detailsAccount = new JTextField();
		detailsAccount.setEditable(false);
		detailsAccount.setBounds(61, 7, 471, 21);
		accDetailsPanel.add(detailsAccount);
		detailsAccount.setColumns(10);
		
		detailsDetails = new JTextField();
		detailsDetails.setEditable(false);
		detailsDetails.setColumns(10);
		detailsDetails.setBounds(61, 38, 471, 21);
		accDetailsPanel.add(detailsDetails);
		
		detailsAttribute = new JTextField();
		detailsAttribute.setEditable(false);
		detailsAttribute.setColumns(10);
		detailsAttribute.setBounds(61, 71, 471, 21);
		accDetailsPanel.add(detailsAttribute);
		
		detailsPassword = new JTextField();
		detailsPassword.setEditable(false);
		detailsPassword.setColumns(10);
		detailsPassword.setBounds(61, 110, 471, 21);
		accDetailsPanel.add(detailsPassword);
		
		detailsCipherText = new JTextField();
		detailsCipherText.setEditable(false);
		detailsCipherText.setColumns(10);
		detailsCipherText.setBounds(61, 145, 471, 21);
		accDetailsPanel.add(detailsCipherText);
		
		JButton showOrgTextButton = new JButton("\u663E\u793A\u539F\u6587");
		showOrgTextButton.setBounds(10, 346, 93, 23);
		accDetailsPanel.add(showOrgTextButton);
		
		JButton buttonDeleteAccount = new JButton("\u5220\u9664\u8D26\u6237");
		buttonDeleteAccount.setBounds(133, 346, 93, 23);
		accDetailsPanel.add(buttonDeleteAccount);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "  \u4FEE\u6539  ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(281, 279, 251, 55);
		accDetailsPanel.add(panel_5);
		panel_5.setLayout(null);
		
		JButton detailsModifyButton = new JButton("\u4FEE\u6539");
		detailsModifyButton.setBounds(10, 25, 93, 23);
		panel_5.add(detailsModifyButton);
		
		JButton detailsOkButton = new JButton("\u786E\u5B9A");
		detailsOkButton.setBounds(148, 25, 93, 23);
		panel_5.add(detailsOkButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 196, 471, 73);
		accDetailsPanel.add(scrollPane);
		
		JTextArea detailsComment = new JTextArea();
		detailsComment.setEditable(false);
		detailsComment.setBackground(UIManager.getColor("Button.background"));
		detailsComment.setLineWrap(true);
		scrollPane.setViewportView(detailsComment);
		
		JPanel accAddPanel = new JPanel();
		panel.add(accAddPanel, "accAddPanel");
		accAddPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(10, 10, 43, 15);
		accAddPanel.add(lblNewLabel);
		
		JLabel label = new JLabel("\u8BF4\u660E\uFF1A");
		label.setBounds(10, 43, 43, 15);
		accAddPanel.add(label);
		
		JLabel label_1 = new JLabel("\u539F\u6587\uFF1A");
		label_1.setBounds(10, 78, 43, 15);
		accAddPanel.add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC6\u6587\uFF1A");
		label_2.setBounds(10, 115, 43, 15);
		accAddPanel.add(label_2);
		
		JLabel label_3 = new JLabel("\u5907\u6CE8\uFF1A");
		label_3.setBounds(10, 152, 43, 15);
		accAddPanel.add(label_3);
		
		accountText = new JTextField();
		accountText.setBounds(63, 7, 469, 21);
		accAddPanel.add(accountText);
		accountText.setColumns(10);
		
		detailText = new JTextField();
		detailText.setColumns(10);
		detailText.setBounds(63, 40, 469, 21);
		accAddPanel.add(detailText);
		
		passwordTest = new JTextField();
		passwordTest.setColumns(10);
		passwordTest.setBounds(63, 75, 469, 21);
		accAddPanel.add(passwordTest);
		
		cipherText = new JTextField();
		cipherText.setColumns(10);
		cipherText.setBounds(63, 112, 469, 21);
		accAddPanel.add(cipherText);
		
		JRadioButton personalRadioButton = new JRadioButton("\u4E2A\u4EBA");
		personalRadioButton.setSelected(true);
		personalRadioButton.setBounds(309, 148, 58, 23);
		accAddPanel.add(personalRadioButton);
		
		JRadioButton workRadioButton = new JRadioButton("\u5DE5\u4F5C");
		workRadioButton.setBounds(309, 216, 58, 23);
		accAddPanel.add(workRadioButton);
		
		JRadioButton tempRadioButton = new JRadioButton("\u4E34\u65F6");
		tempRadioButton.setBounds(309, 286, 58, 23);
		accAddPanel.add(tempRadioButton);
		
		JRadioButton importentRadioButton = new JRadioButton("\u91CD\u8981\u8D26\u6237");
		importentRadioButton.setBounds(400, 148, 113, 23);
		accAddPanel.add(importentRadioButton);
		
		JRadioButton generalRadioButton = new JRadioButton("\u666E\u901A\u8D26\u6237");
		generalRadioButton.setSelected(true);
		generalRadioButton.setBounds(400, 286, 113, 23);
		accAddPanel.add(generalRadioButton);
		
		JButton addAccountButton = new JButton("\u6DFB\u52A0");
		addAccountButton.setBounds(63, 344, 93, 23);
		accAddPanel.add(addAccountButton);
		
		JButton accountPanelClearBut = new JButton("\u6E05\u7A7A");
		accountPanelClearBut.setBounds(201, 344, 93, 23);
		accAddPanel.add(accountPanelClearBut);
		
		JButton addAccPanelGetCipButton = new JButton("\u52A0\u5BC6");
		addAccPanelGetCipButton.setBounds(311, 344, 93, 23);
		accAddPanel.add(addAccPanelGetCipButton);
		
		JButton addAccPanelGetOrgButton = new JButton("\u89E3\u5BC6");
		addAccPanelGetOrgButton.setBounds(439, 344, 93, 23);
		accAddPanel.add(addAccPanelGetOrgButton);
		
		JPanel accTranslatePanel = new JPanel();
		panel.add(accTranslatePanel, "accTranslatePanel");
		accTranslatePanel.setLayout(null);
		
		JLabel label_9 = new JLabel("\u539F\u6587\uFF1A");
		label_9.setBounds(10, 10, 44, 15);
		accTranslatePanel.add(label_9);
		
		JLabel label_10 = new JLabel("\u5BC6\u6587\uFF1A");
		label_10.setBounds(10, 76, 44, 15);
		accTranslatePanel.add(label_10);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(63, 10, 469, 56);
		accTranslatePanel.add(scrollPane_4);
		
		JTextArea origTextArea = new JTextArea();
		origTextArea.setLineWrap(true);
		scrollPane_4.setViewportView(origTextArea);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(63, 76, 469, 56);
		accTranslatePanel.add(scrollPane_5);
		
		JTextArea cipherTextArea = new JTextArea();
		cipherTextArea.setLineWrap(true);
		scrollPane_5.setViewportView(cipherTextArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), " \u89C4\u5219 ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(63, 159, 214, 87);
		accTranslatePanel.add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton defaultRule = new JRadioButton("\u9ED8\u8BA4");
		defaultRule.setSelected(true);
		defaultRule.setBounds(20, 24, 67, 23);
		panel_2.add(defaultRule);
		
		JRadioButton specifiedRule = new JRadioButton("\u6307\u5B9A");
		specifiedRule.setBounds(124, 24, 67, 23);
		panel_2.add(specifiedRule);
		
		JComboBox specifyRuleComboBox = new JComboBox();
		specifyRuleComboBox.setEnabled(false);
		specifyRuleComboBox.setBounds(287, 169, 245, 21);
		accTranslatePanel.add(specifyRuleComboBox);
		
		JButton origToCipherButton = new JButton("\u539F\u6587\u8F6C\u5BC6\u6587");
		origToCipherButton.setBounds(64, 343, 110, 23);
		accTranslatePanel.add(origToCipherButton);
		
		JButton cipherToOrigButton = new JButton("\u5BC6\u6587\u8F6C\u539F\u6587");
		cipherToOrigButton.setBounds(422, 343, 110, 23);
		accTranslatePanel.add(cipherToOrigButton);
		
		JPanel accCreateRulesPanel = new JPanel();
		accCreateRulesPanel.setLayout(null);
		panel.add(accCreateRulesPanel, "accCreateRulesPanel");
		
		JLabel label_11 = new JLabel("\u539F\u6587\uFF1A");
		label_11.setBounds(10, 10, 44, 15);
		accCreateRulesPanel.add(label_11);
		
		JLabel label_12 = new JLabel("\u5BC6\u6587\uFF1A");
		label_12.setBounds(10, 76, 44, 15);
		accCreateRulesPanel.add(label_12);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.setBounds(10, 142, 522, 199);
		accCreateRulesPanel.add(panel_8);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 31, 192, 158);
		panel_8.add(scrollPane_6);
		
		JList rulesListArea = new JList();
		scrollPane_6.setViewportView(rulesListArea);
		
		JLabel label_13 = new JLabel("\u89C4\u5219\u5217\u8868\uFF1A");
		label_13.setBounds(10, 10, 81, 15);
		panel_8.add(label_13);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(320, 31, 192, 158);
		panel_8.add(scrollPane_7);
		
		JList addedListArea = new JList();
		scrollPane_7.setViewportView(addedListArea);
		
		JLabel label_14 = new JLabel("\u5E94\u7528\u7684\u89C4\u5219\uFF1A");
		label_14.setBounds(320, 10, 81, 15);
		panel_8.add(label_14);
		
		JButton addCreateRuleButton = new JButton(">>>");
		addCreateRuleButton.setBounds(212, 31, 93, 23);
		panel_8.add(addCreateRuleButton);
		
		JButton deleteCreateRuleButton = new JButton("<<<");
		deleteCreateRuleButton.setBounds(212, 64, 93, 23);
		panel_8.add(deleteCreateRuleButton);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(60, 10, 472, 56);
		accCreateRulesPanel.add(scrollPane_2);
		
		JTextArea orgMapTextArea = new JTextArea();
		orgMapTextArea.setLineWrap(true);
		scrollPane_2.setViewportView(orgMapTextArea);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(60, 76, 472, 56);
		accCreateRulesPanel.add(scrollPane_3);
		
		JTextArea cipMapTextArea = new JTextArea();
		cipMapTextArea.setLineWrap(true);
		scrollPane_3.setViewportView(cipMapTextArea);
		
		JButton saveRulesButton = new JButton("\u4FDD\u5B58\u89C4\u5219");
		saveRulesButton.setBounds(10, 361, 93, 23);
		accCreateRulesPanel.add(saveRulesButton);
		
		JButton importRulesButton = new JButton("\u5BFC\u5165\u89C4\u5219");
		importRulesButton.setBounds(439, 361, 93, 23);
		accCreateRulesPanel.add(importRulesButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(566, 43, 211, 370);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(0, 0, 211, 370);
		panel_1.add(scrollPane_8);
		
		JList searchReasults = new JList();
		scrollPane_8.setViewportView(searchReasults);
		
		JPopupMenu popupMenu = new JPopupMenu();
		
		JMenuItem copyItem = new JMenuItem("\u590D\u5236");
		popupMenu.add(copyItem);
		
		JMenuItem deleteItem = new JMenuItem("\u5220\u9664");
		popupMenu.add(deleteItem);
		
		JMenuItem propertyItem = new JMenuItem("\u5C5E\u6027");
		popupMenu.add(propertyItem);
		
		searchTextfield = new JTextField();
		searchTextfield.setForeground(Color.LIGHT_GRAY);
		searchTextfield.setText("\u641C\u7D22");
		searchTextfield.setToolTipText("");
		searchTextfield.setBounds(566, 11, 135, 21);
		frame.getContentPane().add(searchTextfield);
		searchTextfield.setColumns(10);
		
		JButton searchButton = new JButton("\u641C\u7D22");
		searchButton.setBounds(708, 10, 69, 23);
		frame.getContentPane().add(searchButton);
		
		JRadioButton searchByAccountRadioButton = new JRadioButton("\u6309\u8D26\u53F7");
		searchByAccountRadioButton.setSelected(true);
		searchByAccountRadioButton.setBounds(566, 419, 121, 23);
		frame.getContentPane().add(searchByAccountRadioButton);
		
		JRadioButton searchBySpecifyRadioButton = new JRadioButton("\u6309\u8BF4\u660E");
		searchBySpecifyRadioButton.setBounds(708, 419, 69, 23);
		frame.getContentPane().add(searchBySpecifyRadioButton);
		
		JButton ruleCreateRules = new JButton("\u7EC4\u5408\u89C4\u5219");
		ruleCreateRules.setBounds(295, 10, 96, 23);
		frame.getContentPane().add(ruleCreateRules);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u6587\u4EF6");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuNewFile = new JMenuItem("\u65B0\u5EFA");
		mnNewMenu.add(menuNewFile);
		
		JMenuItem menuOpenFile = new JMenuItem("\u6253\u5F00");
		mnNewMenu.add(menuOpenFile);
		
		JMenuItem menuSave = new JMenuItem("\u4FDD\u5B58");
		mnNewMenu.add(menuSave);
		
		JMenuItem menuSaveAs = new JMenuItem("\u53E6\u5B58\u4E3A");
		mnNewMenu.add(menuSaveAs);
		
		JMenuItem menuCurrentFile = new JMenuItem("\u5F53\u524D\u6587\u4EF6");
		mnNewMenu.add(menuCurrentFile);
		
		JMenuItem menuExit = new JMenuItem("\u9000\u51FA");
		mnNewMenu.add(menuExit);
		
		JMenu mnNewMenu_1 = new JMenu("\u8BBE\u7F6E");
		menuBar.add(mnNewMenu_1);
		
		JMenu menu_1 = new JMenu("\u5BC6\u7801\u89C4\u5219\u8BBE\u7F6E");
		mnNewMenu_1.add(menu_1);
		
		JMenuItem menuSetDefaultRule = new JMenuItem("\u8BBE\u7F6E\u9ED8\u8BA4\u89C4\u5219");
		menu_1.add(menuSetDefaultRule);
		
		JMenuItem menuCreateMapRule = new JMenuItem("\u521B\u5EFA\u5BF9\u5E94\u89C4\u5219");
		menu_1.add(menuCreateMapRule);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5BFC\u51FA\u8D26\u53F7");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu menuSmallTools = new JMenu("\u5C0F\u5DE5\u5177");
		menuBar.add(menuSmallTools);
		
		JMenuItem menuItem = new JMenuItem("\u751F\u6210\u6D4B\u8BD5\u6587\u4EF6");
		menuSmallTools.add(menuItem);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5B57\u7B26\u4E32\u5C0F\u5DE5\u5177");
		menuSmallTools.add(menuItem_3);
		
		JMenu menu = new JMenu("\u7248\u6743");
		menuBar.add(menu);	
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(63, 155, 231, 154);
		accAddPanel.add(scrollPane_1);
		
		JTextArea commentText = new JTextArea();
		commentText.setLineWrap(true);
		scrollPane_1.setViewportView(commentText);
		
		JButton lastAccount = new JButton("<<<");
		lastAccount.setBounds(10, 296, 93, 23);
		accDetailsPanel.add(lastAccount);
		
		JButton nextAccount = new JButton(">>>");
		nextAccount.setBounds(133, 296, 93, 23);
		accDetailsPanel.add(nextAccount);
		
		JButton firstAccountButton = new JButton("\u7B2C\u4E00\u4E2A");
		firstAccountButton.setBounds(291, 346, 93, 23);
		accDetailsPanel.add(firstAccountButton);
		
		JButton lastAccountButton = new JButton("\u6700\u540E\u4E00\u4E2A");
		lastAccountButton.setBounds(428, 346, 93, 23);
		accDetailsPanel.add(lastAccountButton);
		
		JLabel counter = new JLabel("");
		counter.setForeground(Color.MAGENTA);
		counter.setFont(new Font("宋体", Font.PLAIN, 30));
		counter.setBounds(430, 0, 121, 43);
		frame.getContentPane().add(counter);
		
		otherRuleFiled = new JTextField();
		otherRuleFiled.setEnabled(false);
		otherRuleFiled.setBounds(63, 267, 353, 21);
		accTranslatePanel.add(otherRuleFiled);
		otherRuleFiled.setColumns(10);
		
		JButton otherRuleButton = new JButton("\u9009\u62E9\u89C4\u5219");
		otherRuleButton.setEnabled(false);
		otherRuleButton.setBounds(422, 266, 110, 23);
		accTranslatePanel.add(otherRuleButton);
		
		JRadioButton otherRule = new JRadioButton("\u6307\u5B9A\u5176\u4ED6\u89C4\u5219");
		otherRule.setBounds(20, 58, 103, 23);
		panel_2.add(otherRule);
		
		JButton clearAddedRuleButton = new JButton("\u6E05\u7A7A");
		clearAddedRuleButton.setBounds(331, 361, 93, 23);
		accCreateRulesPanel.add(clearAddedRuleButton);
		
		JButton runAddedRuleButton = new JButton("\u5E94\u7528");
		runAddedRuleButton.setBounds(120, 361, 93, 23);
		accCreateRulesPanel.add(runAddedRuleButton);		
		
		//创建一个搜索方式的单选按钮的组
		ButtonGroup searchWaySelect = new ButtonGroup();
		searchWaySelect.add(searchByAccountRadioButton);
		searchWaySelect.add(searchBySpecifyRadioButton);
		//创件一个账号属于某个团体的组
		ButtonGroup accountCategory = new ButtonGroup();
		accountCategory.add(personalRadioButton);
		accountCategory.add(workRadioButton);
		accountCategory.add(tempRadioButton);
		//创建一个账号级别的组
		ButtonGroup accountLevel = new ButtonGroup();
		accountLevel.add(importentRadioButton);
		accountLevel.add(generalRadioButton);	
		//创建一个选择翻译规则的组
		ButtonGroup tanslateRuleSelect = new ButtonGroup();
		tanslateRuleSelect.add(defaultRule);
		tanslateRuleSelect.add(specifiedRule);
		tanslateRuleSelect.add(otherRule);
		//添加切换panel的listener
		accDetails.addMouseListener(new ButtonChangePageListener(accDetails, 
				accAdd, passTranslate, ruleCreateRules,cardLayout, panel));
		accAdd.addMouseListener(new ButtonChangePageListener(accDetails, 
				accAdd, passTranslate, ruleCreateRules,cardLayout, panel));
		passTranslate.addMouseListener(new ButtonChangePageListener(accDetails, 
				accAdd, passTranslate, ruleCreateRules,cardLayout, panel));
		ruleCreateRules.addMouseListener(new ButtonChangePageListener(accDetails, 
				accAdd, passTranslate, ruleCreateRules,cardLayout, panel));	
		//添加账号明细panel组件的listener
		detailsModifyButton.addMouseListener(new ButtonModifyAccountListener(detailsAccount, 
				detailsDetails, detailsAttribute, detailsPassword, detailsCipherText, 
				detailsComment));
		nextAccount.addMouseListener(new ButtonNextAccountListerner(frame, itemAnchor, 
				detailsAccount, detailsDetails, detailsAttribute, detailsPassword, 
				detailsCipherText, detailsComment,counter));
		lastAccount.addMouseListener(new ButtonLastAccountListener(frame, itemAnchor, 
				detailsAccount, detailsDetails, detailsAttribute, detailsPassword, 
				detailsCipherText, detailsComment, counter));
		buttonDeleteAccount.addMouseListener(new ButtonRemoveAccountListener(frame, 
				itemAnchor, detailsAccount, detailsDetails, detailsAttribute, 
				detailsPassword, detailsCipherText, detailsComment, counter));	
		firstAccountButton.addMouseListener(new FirstAccountListener(frame, itemAnchor, 
				detailsAccount, detailsDetails, detailsAttribute, detailsPassword, 
				detailsCipherText, detailsComment, counter));
		lastAccountButton.addMouseListener(new LastAccountListener(frame, itemAnchor, 
				detailsAccount, detailsDetails, detailsAttribute, detailsPassword, 
				detailsCipherText, detailsComment, counter));
		searchByAccountRadioButton.addMouseListener(new SearchWayListener(frame, 
				searchByAccountRadioButton, searchBySpecifyRadioButton, searchWay));
		searchBySpecifyRadioButton.addMouseListener(new SearchWayListener(frame, 
				searchByAccountRadioButton, searchBySpecifyRadioButton, searchWay));
		searchTextfield.addFocusListener(new SearchTextFieldFocusListener(frame, 
				searchTextfield, searchTextState));
		searchTextfield.addFocusListener(new SearchTextFieldOnBlueListener(frame, 
				searchTextfield, searchTextState));
		searchTextfield.getDocument().addDocumentListener(new SearchTextFieldInputListener
				(frame, searchTextfield, itemAnchor, detailsAccount, detailsDetails, 
						detailsAttribute, detailsPassword, detailsCipherText, 
						detailsComment, counter, searchReasults, searchTextState, 
						searchResultNumList, searchWay));
		searchTextfield.addKeyListener(new TextFieldEnterKeyListener(frame, 
				searchTextfield, itemAnchor, searchReasults, searchTextState, 
				searchResultNumList, searchWay));
		searchButton.addMouseListener(new ButtonSearchListener(frame, searchTextfield, 
				itemAnchor, searchReasults, searchTextState, searchResultNumList, 
				searchWay));
		searchReasults.addMouseListener(new SearchResultDoubleClickListener(frame, 
				accDetails, accAdd, passTranslate, ruleCreateRules, panel, cardLayout, 
				itemAnchor, detailsAccount, detailsDetails, detailsAttribute, 
				detailsPassword, detailsCipherText, detailsComment, counter, 
				searchResultNumList, searchReasults));
		searchReasults.addMouseListener(new SearchResultsRightClickListener(frame,
				searchResultNumList, searchReasults,popupMenu));		
		deleteItem.addActionListener(new MenuRightDelete(frame, itemAnchor, 
				detailsAccount, detailsDetails, detailsAttribute, detailsPassword, 
				detailsCipherText, detailsComment, counter, searchReasults, 
				searchResultNumList,searchTextfield,searchWay,searchTextState));
		detailsOkButton.addMouseListener(new ButtonModifyFinishListener(frame, 
				itemAnchor, detailsAccount, detailsDetails, detailsAttribute, 
				detailsPassword, detailsCipherText, detailsComment,rulesBean));
		showOrgTextButton.addMouseListener(new ShowOrgTextButtonListener(frame, 
				rulesBean, detailsPassword, detailsCipherText));
		//添加添加账号panel的listener
		accountPanelClearBut.addMouseListener(new AccountPanelClearListener(accountText, 
				detailText, passwordTest, cipherText,commentText));
		addAccountButton.addMouseListener(new AccountPanelAddOneListener(frame, itemAnchor, 
				accountText, detailText, passwordTest, cipherText, commentText,category,
				rulesBean));	
		personalRadioButton.addMouseListener(new AccountCategoryListener(frame, 
				personalRadioButton, workRadioButton, tempRadioButton, category));
		workRadioButton.addMouseListener(new AccountCategoryListener(frame, 
				personalRadioButton, workRadioButton, tempRadioButton, category));
		tempRadioButton.addMouseListener(new AccountCategoryListener(frame, 
				personalRadioButton, workRadioButton, tempRadioButton, category));
		importentRadioButton.addMouseListener(new AccountImportanceListener(frame, 
				importentRadioButton, generalRadioButton, category));
		generalRadioButton.addMouseListener(new AccountImportanceListener(frame, 
				importentRadioButton, generalRadioButton, category));
		addAccPanelGetCipButton.addMouseListener(new AddAccPanelGetCipButtonListener(frame, 
				rulesBean, passwordTest, cipherText));
		addAccPanelGetOrgButton.addMouseListener(new AddAccPanelGetOrgButtonListener(frame, 
				rulesBean, passwordTest, cipherText));
		//添加密码查阅panel组件的listener
		origToCipherButton.addMouseListener(new OrigToCipherButtonListener(frame, 
				origTextArea, cipherTextArea,transformRule));
		cipherToOrigButton.addMouseListener(new CipherToOrigButtonListener(frame, 
				origTextArea, cipherTextArea,transformRule));
		defaultRule.addMouseListener(new RadioSelectRuleToTransferListener(frame, defaultRule, 
				specifiedRule, otherRule, specifyRuleComboBox, otherRuleFiled, 
				otherRuleButton, rulesBean,transformRule));
		specifiedRule.addMouseListener(new RadioSelectRuleToTransferListener(frame, defaultRule, 
				specifiedRule, otherRule, specifyRuleComboBox, otherRuleFiled, 
				otherRuleButton, rulesBean,transformRule));
		otherRule.addMouseListener(new RadioSelectRuleToTransferListener(frame, defaultRule, 
				specifiedRule, otherRule, specifyRuleComboBox, otherRuleFiled, 
				otherRuleButton, rulesBean,transformRule));
		otherRuleButton.addMouseListener(new OtherRuleButtonListener(frame, otherRuleFiled, 
				otherRuleButton, rulesBean, transformRule));
		specifyRuleComboBox.addActionListener(new SpecifyRuleComboBoxListener(frame, 
				specifyRuleComboBox, rulesBean, transformRule));
		//添加创建规则panel组件的listener
		addCreateRuleButton.addMouseListener(new AddCreatRuleListener(frame, rulesBean, 
				addedListArea, rulesListArea,orgMapTextArea,cipMapTextArea));
		deleteCreateRuleButton.addMouseListener(new DeleteCreatRuleListener(frame, rulesBean, 
				addedListArea, rulesListArea,orgMapTextArea,cipMapTextArea));
		importRulesButton.addMouseListener(new ImportCreateRuleListener(frame, rulesBean, 
				addedListArea,orgMapTextArea,cipMapTextArea));
		saveRulesButton.addMouseListener(new SaveCreateRuleListener(frame, rulesBean));
		clearAddedRuleButton.addMouseListener(new ClearAddRuleButtonListener(frame, rulesBean, 
				addedListArea, rulesListArea, orgMapTextArea, cipMapTextArea));
		runAddedRuleButton.addMouseListener(new RunAddedRuleButtonListener(frame, rulesBean, 
				addedListArea, rulesListArea, orgMapTextArea, cipMapTextArea));
		//添加菜单选项的listener
		menuOpenFile.addActionListener(new MenuOpenFileListener(frame, 
				detailsAccount, detailsDetails, detailsAttribute, detailsPassword, 
				detailsCipherText, detailsComment, accDetails, accAdd, 
				passTranslate, ruleCreateRules, panel, cardLayout,
				itemAnchor,counter));
		menuExit.addActionListener(new ExitListener());
		menuNewFile.addActionListener(new MenuNewAccountListener(frame, itemAnchor, 
				detailsAccount, detailsDetails, detailsAttribute, 
				detailsPassword, detailsCipherText, detailsComment,counter));
		menuCurrentFile.addActionListener(new MenuCurrentFileListener(frame, itemAnchor));
		copyItem.addActionListener(new MenuRightCopy(frame, searchReasults));
		propertyItem.addActionListener(new MenuRightProperty(frame, itemAnchor, searchReasults));
		menuSaveAs.addActionListener(new MenuSaveAsListener(frame, itemAnchor));
		menuSave.addActionListener(new MenuSaveListener(frame, itemAnchor));
		menuCreateMapRule.addActionListener(new MenuShowCreateRuleWindowListener(rulesListArea,
				rulesBean,specifyRuleComboBox));
		menuSetDefaultRule.addActionListener(new MenuSetDefaultRuleListener(rulesBean));
		
		//添加程序启动要初始化的内容
		LoadRules loadRules = new LoadRules(rulesBean, rulesListArea, addedListArea,
				specifyRuleComboBox,frame,transformRule);
		loadRules.loadSysRules();
		
	}
}
