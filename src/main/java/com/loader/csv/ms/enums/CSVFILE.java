package com.loader.csv.ms.enums;

public enum CSVFILE {
	ORDER_ID_HEADER("Order ID"),
	REGION_HEADER("Region"),
	COUNTRY_HEADER("Country"),
	ITEM_TYPE_HEADER("Item Type"),
	SALES_CHANNEL_HEADER("Sales Channel"),
	ORDER_PRIORITY_HEADER("Order Priority"),
	ORDER_DATE_HEADER("Order Date"),
	SHIP_DATE_HEADER("Ship Date"),
	UNITS_SOLD_HEADER("Units Sold"),
	UNIT_PRICE_HEADER("Unit Price"),
	UNIT_COST_HEADER("Unit Cost"),
	TOTAL_REVENUE_HEADER("Total Revenue"),
	TOTAL_COST_HEADER("Total Cost"),
	TOTAL_PROFIT_HEADER("Total Profit");
	
	public String value;
	
	private CSVFILE(String value) {
		this.value = value;
	}

}
