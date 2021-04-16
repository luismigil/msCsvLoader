package com.loader.csv.ms.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.loader.csv.ms.enums.CSVFILE;
import com.loader.csv.ms.model.Orders;

public class CSVOrdersHelper {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	public static List<Orders> csvToOrders(InputStream is){
		try(BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());){
			
			List<Orders> orders = new ArrayList<Orders>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			for(CSVRecord csvRecord : csvRecords) {
				Orders order = new Orders.Builder(Long.parseLong(csvRecord.get(CSVFILE.ORDER_ID_HEADER.value)))
						.region(csvRecord.get(CSVFILE.REGION_HEADER.value))
						.country(csvRecord.get(CSVFILE.COUNTRY_HEADER.value))
						.itemType(csvRecord.get(CSVFILE.ITEM_TYPE_HEADER.value))
						.salesChannel(csvRecord.get(CSVFILE.SALES_CHANNEL_HEADER.value))
						.orderPriority(csvRecord.get(CSVFILE.ORDER_PRIORITY_HEADER.value))
						.orderDate(sdf.parse(csvRecord.get(CSVFILE.ORDER_DATE_HEADER.value)))
						.shipDate(sdf.parse(csvRecord.get(CSVFILE.SHIP_DATE_HEADER.value)))
						.unitsSold(Integer.parseInt(csvRecord.get(CSVFILE.UNITS_SOLD_HEADER.value)))
						.unitPrice(Float.parseFloat(csvRecord.get(CSVFILE.UNIT_PRICE_HEADER.value)))
						.unitCost(Float.parseFloat(csvRecord.get(CSVFILE.UNIT_COST_HEADER.value)))
						.totalRevenue(Float.parseFloat(csvRecord.get(CSVFILE.TOTAL_REVENUE_HEADER.value)))
						.totalCost(Float.parseFloat(csvRecord.get(CSVFILE.TOTAL_COST_HEADER.value)))
						.totalProfit(Float.parseFloat(csvRecord.get(CSVFILE.TOTAL_PROFIT_HEADER.value)))
						.build();
				
				orders.add(order);
			}
			return orders;
		}catch(IOException e) {
			throw new RuntimeException("failed to parse CSV file: " + e.getMessage());
		} catch (ParseException e) {
			throw new RuntimeException("failed to parse CSV file: " + e.getMessage());
		}
	}
}
