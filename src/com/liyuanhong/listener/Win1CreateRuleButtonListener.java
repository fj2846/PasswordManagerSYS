package com.liyuanhong.listener;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.liyuanhong.rules.AbstrackRule;
import com.liyuanhong.rules.MapRule;
import com.liyuanhong.util.RulesBean;

public class Win1CreateRuleButtonListener extends MouseAdapter{
	private JFrame frame;
	private JTextArea orgTextArea;
	private JTextArea oppTextArea;
	private JTextField ruleNameFiled;
	private JList rulesListArea;
	private RulesBean rulesBean;
	private JComboBox specifyRuleComboBox;
	private JList list;
	private Map<String, AbstrackRule> selfRules;
	private Map<String, File> selfFiles;
	
	private Class<AbstrackRule> cla;
	private MapRule obj;
	private String name;
	private String orgText;
	private String oppText;
	private Vector<String> rules;
	private Map<String, AbstrackRule> rulesMap;
	
	
	public Win1CreateRuleButtonListener(JFrame frame, JTextArea orgTextArea,
			JTextArea oppTextArea, JTextField ruleNameFiled,RulesBean rulesBean,
			JList rulesListArea,JComboBox specifyRuleComboBox,JList list,
			Map<String, AbstrackRule> selfRules,Map<String, File> selfFiles) {
		super();
		this.frame = frame;
		this.orgTextArea = orgTextArea;
		this.oppTextArea = oppTextArea;
		this.ruleNameFiled = ruleNameFiled;
		this.rulesBean = rulesBean;
		this.rulesListArea = rulesListArea;
		this.specifyRuleComboBox = specifyRuleComboBox;
		this.list = list;
		this.selfRules = selfRules;
		this.selfFiles = selfFiles;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		name = ruleNameFiled.getText();
		orgText = orgTextArea.getText();
		oppText = oppTextArea.getText();
		rulesMap = rulesBean.getRulesMap();

		if(e.getButton() == MouseEvent.BUTTON1){
			try {
				if(name.equals("")){
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(frame, "文件名不能为空！", "ok", 
							JOptionPane.ERROR_MESSAGE);
				}else{
					cla = (Class<AbstrackRule>) Class.forName("com.liyuanhong.rules.MapRule");
					obj = (MapRule) cla.newInstance();
					
					obj.setName(name);
					obj.setOppText(oppText);
					obj.setOrgText(orgText);
					
					File file = new File("mapRule");
					if(!file.exists()){
						file.mkdirs();
					}
					file = new File("mapRule/" + name + ".rul");
					int i = 0;
					while(file.exists()){
						file = new File("mapRule/" + name + name + ++i + ".rul");
					}
					
					FileOutputStream os=new FileOutputStream(file);
					ObjectOutputStream oos=new ObjectOutputStream(os);
				    oos.writeObject(obj);
				    oos.close();
				    os.close();
				    
				    rulesMap.put(obj.getName(),obj);
				    Set<String> set = rulesMap.keySet();
					String[] str = new String[set.size()]; 
					rules = new Vector<String>();
					int k = 0;
					for(Iterator<String> ite = set.iterator();ite.hasNext();k++){
						rules.add(ite.next());
					}
					rulesListArea.setListData(rules);
					specifyRuleComboBox.setModel(new DefaultComboBoxModel(rules));
					
					//----------------------------------------
									
					selfRules.put(obj.getName(),obj);
					selfFiles.put(obj.getName(), file);
					Set<String> newset = selfRules.keySet();
					Vector<String> newrules = new Vector<String>();
					int h = 0;
					for(Iterator<String> ite = newset.iterator();ite.hasNext();h++){
						 newrules.add(ite.next());
					}
					list.setListData(newrules);
				    
				    Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(frame, "成功生成密码规则！", "ok", 
							JOptionPane.INFORMATION_MESSAGE);
				}				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
