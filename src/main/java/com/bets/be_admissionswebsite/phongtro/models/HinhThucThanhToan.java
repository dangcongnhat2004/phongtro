package com.bets.be_admissionswebsite.phongtro.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HinhThucThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tenHinhThuc; // "Theo tháng", "Theo quý", "Theo năm"
}
