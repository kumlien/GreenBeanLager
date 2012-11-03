package se.ithuset.greenbean.lager;

public class Order {
	
	private String productId;
	private Integer qty;
	private String customerName;
	private String addressStreet;
	private String addressCity;
	private String addressZip;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressZip() {
		return addressZip;
	}
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}
	@Override
	public String toString() {
		return "Order [productId=" + productId + ", qty=" + qty
				+ ", customerName=" + customerName + ", addressStreet="
				+ addressStreet + ", addressCity=" + addressCity
				+ ", addressZip=" + addressZip + "]";
	}
	
	
}
