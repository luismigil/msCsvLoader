package com.loader.csv.ms.batch;

import com.loader.csv.ms.enums.CSVFILE;
import com.loader.csv.ms.model.Orders;
import org.apache.commons.csv.CSVRecord;
import org.springframework.batch.item.ItemProcessor;

import java.text.SimpleDateFormat;

public class OrderItemProcessor implements ItemProcessor<CSVRecord, Orders> {

    static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    @Override
    public Orders process(CSVRecord csvOrder) throws Exception {
        Orders order = new Orders.Builder(Long.parseLong(csvOrder.get(CSVFILE.ORDER_ID_HEADER.value)))
                .region(csvOrder.get(CSVFILE.REGION_HEADER.value))
                .country(csvOrder.get(CSVFILE.COUNTRY_HEADER.value))
                .itemType(csvOrder.get(CSVFILE.ITEM_TYPE_HEADER.value))
                .salesChannel(csvOrder.get(CSVFILE.SALES_CHANNEL_HEADER.value))
                .orderPriority(CSVFILE.ORDER_PRIORITY_HEADER.value)
                .orderDate(sdf.parse(csvOrder.get(CSVFILE.ORDER_DATE_HEADER.value)))
                .shipDate(sdf.parse(csvOrder.get(CSVFILE.SHIP_DATE_HEADER.value)))
                .unitsSold(Integer.parseInt(csvOrder.get(CSVFILE.UNITS_SOLD_HEADER.value)))
                .unitPrice(Float.parseFloat(csvOrder.get(CSVFILE.UNIT_PRICE_HEADER.value)))
                .unitCost(Float.parseFloat(csvOrder.get(CSVFILE.UNIT_COST_HEADER.value)))
                .totalRevenue(Float.parseFloat(csvOrder.get(CSVFILE.TOTAL_REVENUE_HEADER.value)))
                .totalCost(Float.parseFloat(csvOrder.get(CSVFILE.TOTAL_COST_HEADER.value)))
                .totalProfit(Float.parseFloat(csvOrder.get(CSVFILE.TOTAL_PROFIT_HEADER.value)))
                .build();
        return order;
    }
}
