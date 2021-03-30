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
				Orders order = new Orders(
						Long.parseLong(csvRecord.get("Order ID")),
						csvRecord.get("Region"),
						csvRecord.get("Country"),
						csvRecord.get("Item Type"),
						csvRecord.get("Sales Channel"),
						csvRecord.get("Order Priority"),
						sdf.parse(csvRecord.get("Order Date")),
						sdf.parse(csvRecord.get("Ship Date")),
						Integer.parseInt(csvRecord.get("Units Sold")),
						Float.parseFloat(csvRecord.get("Unit Price")),
						Float.parseFloat(csvRecord.get("Unit Cost")),
						Float.parseFloat(csvRecord.get("Total Revenue")),
						Float.parseFloat(csvRecord.get("Total Cost")),
						Float.parseFloat(csvRecord.get("total Profit"))
						);
				
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
