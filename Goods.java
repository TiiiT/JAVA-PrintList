package personal.printlist;

/**
 * 
 * 商品类
 * @author 
 */
public class Goods {
	private String code;
	private String name;
	private String measurement;
	private float price;
	private String family;
	
	public Goods(){}
	
	public Goods(String code, String name, String measurement, float price,
			String family) {
		this.code = code;
		this.name = name;
		this.measurement = measurement;
		this.price = price;
		this.family = family;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMeasurement() {
		return measurement;
	}
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	
}
