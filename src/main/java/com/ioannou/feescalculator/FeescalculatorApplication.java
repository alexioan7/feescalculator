package com.ioannou.feescalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class FeescalculatorApplication {

	private static final String CSV_FILE_NAME = "Daily_Traffic_Report";

	@Autowired
	private VehicleRepository vehicleRepository;

	public static void main(String[] args) {
		SpringApplication.run(FeescalculatorApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			Map<Vehicle, Integer> fees = new HashMap<>();
			vehicleRepository.findAll().forEach(vehicle -> fees.put(vehicle, FeeCalculator.calculate(vehicle)));
			convertToCSV(fees);
		};
	}

	private void convertToCSV(Map<Vehicle, Integer> fees) throws FileNotFoundException {
		File csvOutputFile = new File(CSV_FILE_NAME);
		try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
			fees.entrySet().stream()
					.map(this::convertToLine)
					.forEach(pw::println);
		}
	}

    private String convertToLine(Map.Entry<Vehicle, Integer> entry) {
		return "Vehicle Type: " + entry.getKey().getType() + ", Plate: " + entry.getKey().getPlate()
				+ " has to pay: " + entry.getValue() + "euros";
	}
}
