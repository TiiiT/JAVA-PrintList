package personal.printlist;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 打印小票的类
 * @author Administrator
 *
 */
public class PrintInfo {
	private String info = "***************<没钱赚商店>购物清单***************\n";
	/**
	 * 打印小票的方法
	 * @return
	 */
	public String Print(){
		Iterator<Goods> it = GoodsHandler.LIST.iterator();
		String temp = "";
		float totalOriginalCost = 0.0f;
		float totalDiscountCost = 0.0f;
		while(it.hasNext()){
			Goods goods = it.next();
			float amount = getNum(goods.getCode());
			float price = goods.getPrice();
			float originalCost = FloatFormat(amount*price);
			float discountCost = FloatFormat((Float)getTotal(goods).get(0));
			totalOriginalCost += originalCost;
			totalDiscountCost += discountCost;
			temp += "名称："+goods.getName()+"，数量:"
						   +amount+goods.getMeasurement()+"，单价:"
						   +price+"(元)，小计:"+discountCost+"(元)";
			if("2".equals(getTotal(goods).get(1))){
				temp += "，节省:"+FloatFormat(originalCost-discountCost)+"(元)";
			}
			temp += "\n";
		}
		temp += "-------------------------------------\n";
		if(PromotionsHandler.promotionsMap.get("1")!=null?
				PromotionsHandler.promotionsMap.get("1").getItems().size()>0?true:false:false){
			Iterator<String> codeIt = PromotionsHandler.promotionsMap.get("1").getItems().iterator();
			while(codeIt.hasNext()){
				String code = codeIt.next();
				Goods goods = GoodsHandler.LISTIterator(code);
				if(goods != null){
					temp += "名称:"+goods.getName()+"，数量:"+getNum(goods.getCode())+goods.getMeasurement()+"\n";
				}
			}
			temp += "-------------------------------------\n";
		}
		temp += "总计:"+totalDiscountCost+"(元)\n";
		if(FloatFormat(totalOriginalCost-totalDiscountCost) != 0){
			temp += "节省:"+FloatFormat(totalOriginalCost-totalDiscountCost)+"(元)\n";
		}
		temp += "*******************************************************";
		info += temp;
		System.out.println(info);
		return info;
	}
	
	/**
	 * 根据条形码得到商品的购买数量
	 * @param num
	 * @return
	 */
	public float getNum(String num){
		String temp = num.split("-").length>1?num.split("-")[1]:"1.0";
		float amount = Float.parseFloat(temp);
		return amount;
	}
	
	/**
	 * 得到每个商品的小计价格；
	 * @param goods
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getTotal(Goods goods){
		List list = new ArrayList();
		float cost = 0.0f;
		String flag = "-1";
		float amount = getNum(goods.getCode());
		if(PromotionsHandler.promotionsMap.get("1")!=null?PromotionsHandler.promotionsMap.get("1").getItems().contains(goods.getCode()):false){
			cost += amount<3.0?amount*goods.getPrice():(amount-Math.floor(amount/3))*goods.getPrice();
			flag = "1";
		}else if(PromotionsHandler.promotionsMap.get("2")!=null?PromotionsHandler.promotionsMap.get("2").getItems().contains(goods.getCode()):false){
			cost += amount*goods.getPrice()*0.95f;
			flag = "2";
		}else{
			cost += amount*goods.getPrice();
		}
		list.add(0,cost);
		list.add(1,flag);
		return list;
	}
	
	/**
	 * 将传递进来的float数据格式化保留两位小数的格式；
	 * @param f
	 * @return
	 */
	public float FloatFormat(float f){
		return Float.parseFloat(new DecimalFormat("0.00").format(f));
	}
	
}
