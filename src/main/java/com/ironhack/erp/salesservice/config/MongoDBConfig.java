package com.ironhack.erp.salesservice.config;

import com.ironhack.erp.salesservice.model.entities.Sale;
import com.ironhack.erp.salesservice.repository.SalesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@EnableMongoRepositories(basePackageClasses = SalesRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(SalesRepository saleRepository) {
        return strings -> {
            List<Sale> test = saleRepository.findAll();

            if (test.size() < 1) {
                saleRepository.save(new Sale((long) 1, (long) 1, Arrays.asList((long) 1, (long) 3, (long) 5, (long) 7), "card", new BigDecimal(100), new BigDecimal(100), new BigDecimal(100), new BigDecimal(100), new BigDecimal(100)));
                saleRepository.save(new Sale((long) 2, (long) 2, Arrays.asList((long) 2, (long) 4, (long) 6, (long) 8), "cheque", new BigDecimal(200), new BigDecimal(200), new BigDecimal(200), new BigDecimal(200), new BigDecimal(200)));
            }
        };
    }

}
