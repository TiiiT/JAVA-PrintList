package personal.printlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 优惠活动对象：
 * 1、优惠活动名称；
 * 2、参与该优惠活动的商品条形码；
 * @author Administrator
 *
 */
public class Promotions {
	
	// 活动名称，如：买二送一等
	private String name;
	
	// 用来存放参与活动的商品，String代表商品的条形码，Goods代表具体的商品
	private List<String> items = new ArrayList<String>();
	
	public Promotions(String name,List<String> codeList) {
		this.name = name;
		setItems(codeList);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getItems() {
		return items;
	}
	
	/**
	 * 设置参与活动的商品列表
	 * @param items
	 */
	public void setItems(List<String> items) {
		Iterator<String> iterator = items.iterator();
		if(!this.items.isEmpty()){
			this.items.clear();
		}
		while(iterator.hasNext()){
			this.items.add(iterator.next());
		}
	}
}
