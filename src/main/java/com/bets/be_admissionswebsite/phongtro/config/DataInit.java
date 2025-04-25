package com.bets.be_admissionswebsite.phongtro.config;


import com.bets.be_admissionswebsite.phongtro.Repository.HinhThucThanhToanRepository;
import com.bets.be_admissionswebsite.phongtro.models.HinhThucThanhToan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInit {

    @Bean
    CommandLineRunner initDatabase(HinhThucThanhToanRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new HinhThucThanhToan(null, "Theo tháng"));
                repo.save(new HinhThucThanhToan(null, "Theo quý"));
                repo.save(new HinhThucThanhToan(null, "Theo năm"));
            }
        };
    }
}
