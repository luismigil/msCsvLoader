package com.loader.csv.ms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	public Orders() {
		super();
	}

	public Orders(Builder builder) {
		this.orderId = builder.orderId;
		this.region = builder.region;
		this.country = builder.country;
		this.itemType = builder.itemType;
		this.salesChannel = builder.salesChannel;
		this.orderPriority = builder.orderPriority;
		this.orderDate = builder.orderDate;
		this.shipDate = builder.shipDate;
		this.unitsSold = builder.unitsSold;
		this.unitPrice = builder.unitPrice;
		this.unitCost = builder.unitCost;
		this.totalRevenue = builder.totalRevenue;
		this.totalCost = builder.totalCost;
		this.totalProfit = builder.totalProfit;
	}

	@Id
	@Column(name = "order_id")
    private Long orderId;

    @Column(name = "region")
    private String region;

    @Column(name = "country")
    private String country;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "sales_channel")
    private String salesChannel;

    @Column(name = "order_priority")
    private String orderPriority;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "ship_date")
    private Date shipDate;

    @Column(name = "units_sold")
    private Integer unitsSold;

    @Column(name = "unit_price")
    private Float unitPrice;

    @Column(name = "unit_cost")
    private Float unitCost;

    @Column(name = "total_revenue")
    private Float totalRevenue;

    @Column(name = "total_cost")
    private Float totalCost;

    @Column(name = "total_profit")
    private Float totalProfit;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}

	public String getOrderPriority() {
		return orderPriority;
	}

	public void setOrderPriority(String orderPriority) {
		this.orderPriority = orderPriority;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public Integer getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(Integer unitsSold) {
		this.unitsSold = unitsSold;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}

	public Float getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(Float totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public Float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}

	public Float getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(Float totalProfit) {
		this.totalProfit = totalProfit;
	}

	public static class Builder{
		private final long orderId;
		private String region;
		private String country;
		private String itemType;
		private String salesChannel;
		private String orderPriority;
		private Date orderDate;
		private Date shipDate;
		private Integer unitsSold;
		private Float unitPrice;
		private Float unitCost;
		private Float totalRevenue;
		private Float totalCost;
		private Float totalProfit;

		public Builder(long orderId) { this.orderId = orderId; }

		public Builder region(String region) {
			this.region = region;
			return this;
		}

		public Builder country(String country) {
			this.country = country;
			return this;
		}

		public Builder itemType(String itemType) {
			this.itemType = itemType;
			return this;
		}

		public Builder salesChannel(String salesChannel) {
			this.salesChannel = salesChannel;
			return this;
		}

		public Builder orderPriority(String orderPriority) {
			this.orderPriority = orderPriority;
			return this;
		}

		public Builder orderDate(Date orderDate) {
			this.orderDate = orderDate;
			return this;
		}

		public Builder shipDate(Date shipDate) {
			this.shipDate = shipDate;
			return this;
		}

		public Builder unitsSold(Integer unitsSold) {
			this.unitsSold = unitsSold;
			return this;
		}

		public Builder unitPrice(Float unitPrice) {
			this.unitPrice = unitPrice;
			return this;
		}

		public Builder unitCost(Float unitCost) {
			this.unitCost = unitCost;
			return this;
		}

		public Builder totalRevenue(Float totalRevenue) {
			this.totalRevenue = totalRevenue;
			return this;
		}

		public Builder totalCost(Float totalCost) {
			this.totalCost = totalCost;
			return this;
		}

		public Builder totalProfit(Float totalProfit) {
			this.totalProfit = totalProfit;
			return this;
		}

		public Orders build(){
			return new Orders(this);
		}
	}
}
