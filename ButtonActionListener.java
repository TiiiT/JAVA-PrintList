package personal.printlist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;

/**
 * 按钮的事件监听
 * @author Administrator
 *
 */
public class ButtonActionListener implements ActionListener {
	private PromotionsHandler promotionsHandler = new PromotionsHandler();

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton j = (JButton) e.getSource();
		//Iterator<String> it = CheckBoxList.CheckboxMap.keySet().iterator();
		//while(it.hasNext()){
		List<String> list = CheckBoxList.CheckboxMap.get(j.getName());
		promotionsHandler.handlerMap(j.getName(),list);
		//}
		//测试代码：打印promotionsMap
		Iterator<String> it2 = promotionsHandler.promotionsMap.keySet().iterator();
		while(it2.hasNext()){
			String temp = it2.next();
			System.out.println("promotionsMap:"+temp+":"+promotionsHandler.promotionsMap.get(temp).getItems());
		}
	}
}
