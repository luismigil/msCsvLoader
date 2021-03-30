package com.loader.csv.ms.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loader.csv.ms.exception.FileSizeException;
import com.loader.csv.ms.helper.CSVOrdersHelper;
import com.loader.csv.ms.model.Orders;
import com.loader.csv.ms.repository.OrdersRepository;

@Service
public class CSVService {

	@Autowired
	OrdersRepository ordersRepository;
	
	public void save(String path) {
		try {
			File file = new File(path);
			if(file.length() > FileSizeException.MAX_FILE_SIZE) {
				throw new FileSizeException("max file size is ["+FileSizeException.MAX_FILE_SIZE+" bytes] "
						+ "and your file size is [" + file.length() + " bytes] try with a smaller one");
			}
			FileInputStream fis = new FileInputStream(file);
			List<Orders> orders = CSVOrdersHelper.csvToOrders(fis);
			ordersRepository.saveAll(orders);
		}catch(IOException e) {
			throw new RuntimeException("failed to store CSV data: " + e.getMessage());
		}catch(FileSizeException e) {
			throw new RuntimeException("failed to store CSV data: " + e.getMessage());
		}
	}
}
