package personal.printlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Promotions活动类的操作类；
 * 
 * @author 
 *
 */
public class PromotionsHandler {
	/*
	 * promotionsMap的结构：
	 * {"买二送一":"具体的活动"}
	 */
	static Map<String,Promotions> promotionsMap = new HashMap<String, Promotions>();

	public PromotionsHandler(){}
	/*
	 * 点击更新的时候，应该调用这个函数,这个list应该是点击CheckBox时进行更改的
	 */
	public void handlerMap(String name,List<String> list){
		if(promotionsMap.containsKey(name)){
			promotionsMap.get(name).setItems(list);
		}else{
			promotionsMap.put(name,new Promotions(name,list));
		}
	}
}
