package se.ithuset.greenbean.lager;

public class Product {
	
	private String productId;
	private String name;
	private Integer itemsInStock;
	private Integer reOrderPoint;
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name
				+ ", itemsInStock=" + itemsInStock + ", reOrderPoint="
				+ reOrderPoint + "]";
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getItemsInStock() {
		return itemsInStock;
	}
	public void setItemsInStock(Integer itemsInStock) {
		this.itemsInStock = itemsInStock;
	}
	public Integer getReOrderPoint() {
		return reOrderPoint;
	}
	public void setReOrderPoint(Integer reOrderPoint) {
		this.reOrderPoint = reOrderPoint;
	}
	
}
