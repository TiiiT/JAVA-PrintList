package personal.printlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GoodsHandler {
	/*
	 * 商品信息包含：名称，数量单位，单价，类别和条形码（伪）。 
	 */
	static final String JSONSTR = "["
			+ "{\"name\":\"苹果\",\"measurement\":\"斤\",\"price\":\"4.3\",\"family\":\"\",\"code\":\"ITEM000001\"},"
			+ "{\"name\":\"香蕉\",\"measurement\":\"斤\",\"price\":\"5.3\",\"family\":\"\",\"code\":\"ITEM000002-2.6\"},"
			+ "{\"name\":\"水杯\",\"measurement\":\"个\",\"price\":\"5\",\"family\":\"\",\"code\":\"ITEM000003-3.0\"},"
			+ "{\"name\":\"梨\",\"measurement\":\"斤\",\"price\":\"6.0\",\"family\":\"\",\"code\":\"ITEM000004-7.0\"},"
			+ "{\"name\":\"小米\",\"measurement\":\"斤\",\"price\":\"5.0\",\"family\":\"\",\"code\":\"ITEM000005-9.0\"},"
			+ "{\"name\":\"蜂蜜\",\"measurement\":\"斤\",\"price\":\"15.0\",\"family\":\"\",\"code\":\"ITEM000006\"}"
			+ "]";
	/*
	 * 这个LIST用来存储收银机发过来的数据；
	 */
	static List<Goods> LIST = new ArrayList<Goods>();
	
	/**
	 * 将JSON字符串转换成JAVA对象，并将其添加进LIST；
	 */
	public static void jsonToJava(){
		JSONArray jsonArr = JSONArray.fromObject(JSONSTR);
		if(!LIST.isEmpty()){
			LIST.clear();
		}
		Iterator iterator = jsonArr.iterator();
		while(iterator.hasNext()){
			JSONObject jsonObject = (JSONObject) iterator.next();
			Goods goods = new Goods(jsonObject.getString("code"),
					jsonObject.getString("name"),
					jsonObject.getString("measurement"),
					Float.parseFloat(jsonObject.getString("price")),
					jsonObject.getString("family"));
			LIST.add(goods);
		}
		for(int i=0;i<LIST.size();i++){
			System.out.println(LIST.get(i).getCode());
		}
	}
	
	/**
	 * 根据商品的条形码，遍历LIST集合，返回查找到的商品；
	 * @param code：条形码
	 * @return
	 */
	public static Goods LISTIterator(String code){
		Goods goods = null;
		Iterator<Goods> it = GoodsHandler.LIST.iterator();
		while(it.hasNext()){
			goods = it.next();
			if(goods.getCode().equalsIgnoreCase(code)){
				break;
			}else{
				goods = null;
			}
		}
		return goods;
	}
}
