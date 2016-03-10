package personal.printlist;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 * 视图界面
 * @author Administrator
 *
 */
public class View extends JFrame {
	private static final long serialVersionUID = -3078882651030417250L;
	private CheckboxGroup checkboxGroup = new CheckboxGroup();
	
	public View() {
		GoodsHandler.jsonToJava();
		init();
	}
	
	/**
	 * 视图初始化：
	 * 1、设置整个视图的属性；
	 * 2、设置多选按钮、更新按钮、显示按钮和文本显示域；
	 */
	public void init(){
		setResizable(false);
		setTitle("终端打印机");
		setLocation(350,10);
		setSize(600,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		Container container = getContentPane();
		JButton jButton1 = new JButton("更新活动");
		jButton1.setName("1");
		jButton1.addActionListener(new ButtonActionListener());
		JButton jButton2 = new JButton("更新活动");
		jButton2.setName("2");
		jButton2.addActionListener(new ButtonActionListener());
		/*
		 * 买二送一:
		 */
		JPanel jPanel1 = getJPanl("买二送一:");
		jPanel1.setBounds(40,20,500,50);
		jPanel1.add(jButton1);
		/*
		 * 95折扣活动
		 */
		JPanel jPanel2 = getJPanl("    95折扣:");
		jPanel2.setBounds(40,75,500,50);
		jPanel2.add(jButton2);
		/*
		 * 显示按钮
		 */
		JPanel jPanel3 = getJPanel(50,20);
		JButton show = new JButton("显示");
		jPanel3.add(show);
		jPanel3.setBounds(40,130,500,40);
		/*
		 * 充当显示器功能的JTextArea
		 */
		JPanel jPanel4 = getJPanel(500,300);
		final JTextArea jTextArea = new JTextArea(24,44);
		jPanel4.add(jTextArea);
		jPanel4.setBounds(40,180,500,450);
		jPanel4.setBorder(BorderFactory.createEtchedBorder());
		/*
		 * 提示信息
		 */
		JTextArea tip = new JTextArea(3,44);
		tip.setText("提示：\n1.在点击显示前请确保已经点击更新活动按钮将活动列表更新；\n2.顾客放弃“买二赠一活动”"
				+ "将视为放弃所有优惠活动。");
		tip.setOpaque(false);
		tip.setForeground(Color.red);
		jPanel4.add(tip);
		/*
		 * 添加上述组件
		 */
		container.add(jPanel1);
		container.add(jPanel2);
		container.add(jPanel3);
		container.add(jPanel4);
		setContentPane(container);
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrintInfo printInfo = new PrintInfo();
				String info = printInfo.Print();
				if(jTextArea.getText() != null || !jTextArea.getText().isEmpty()){
					jTextArea.setText("");
				}
				jTextArea.setText(info);
			}
		});
	}
	
	/**
	 * 面板生成器
	 * @param name
	 * @return
	 */
	public JPanel getJPanl(String name){
		JPanel jPanel = new JPanel();
		JLabel jLabel = new JLabel(name);
		jPanel.add(jLabel);
		for(int i=0;i<GoodsHandler.LIST.size();i++){
			final JCheckBox jCheckBox = new JCheckBox(GoodsHandler.LIST.get(i).getName());
			jCheckBox.addActionListener(new CheckBoxActionListener());
			jCheckBox.setName(GoodsHandler.LIST.get(i).getCode());
			jPanel.add(jCheckBox, checkboxGroup);
		}
		jPanel.setPreferredSize(new Dimension(500,20));
		jPanel.setBorder(BorderFactory.createEtchedBorder());
		return jPanel;
	}
	
	/**
	 * 面板生成器
	 * @param name
	 * @return
	 */
	public JPanel getJPanel(int x,int y){
		JPanel jPanel = new JPanel();
		jPanel.setPreferredSize(new Dimension(x,y));
		return jPanel;
	}
	
}
