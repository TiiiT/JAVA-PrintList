package personal.printlist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;

/**
 * 多选框的事件监听
 * @author Administrator
 */
public class CheckBoxActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox jh = (JCheckBox) e.getSource();
		System.out.println(jh.getParent().getComponents()[7].getName());
		System.out.println(jh.isSelected());
		System.out.println(jh.getName());
		String result = CheckBoxList.checkBoxListHandler(jh.getParent().getComponents()[7].getName(),jh.isSelected(),jh.getName());
		System.out.println(result);
	}
}
