package personal.printlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 点击多选框时，对应的更新列表
 * @author Administrator
 *
 */
public class CheckBoxList {
	static Map<String,List<String>> CheckboxMap = new HashMap<String, List<String>>();
	public static void init(){
		CheckboxMap.put("1",new ArrayList<String>());
		CheckboxMap.put("2",new ArrayList<String>());
	}
	/**
	 * 
	 * @param id:活动ID，“1”或者“2”或者其他
	 * @param flag:CheckBox的选中状态
	 * @param code:商品的条形码
	 * @return
	 */
	public static String checkBoxListHandler(String id,boolean flag,String code){
		if(CheckboxMap == null){
			init();
		}
		if(CheckboxMap.containsKey(id)){
			if(CheckboxMap.get(id) != null && CheckboxMap.get(id).size() >0 ){
				//如果是选中状态
				if(flag){
					//如果已经含有code，则不做处理
					if(CheckboxMap.get(id).contains(code)){
						return "OK";
					}else{
						CheckboxMap.get(id).add(code);
						return "OK";
					}
				}else{
					if(!CheckboxMap.get(id).contains(code)){
						return "OK";
					}else{
						CheckboxMap.get(id).remove(code);
						return "OK";
					}
				}
			}else{
				List<String> list = new ArrayList<String>();
				list.add(code);
				CheckboxMap.put(id,list);
				return "OK";
			}
		}else{
			List<String> list = new ArrayList<String>();
			list.add(code);
			CheckboxMap.put(id,list);
			return "创建OK";
		}
	}
}
