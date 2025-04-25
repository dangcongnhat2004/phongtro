package com.bets.be_admissionswebsite.phongtro.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongTro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maPhong; // PT-001, PT-002

    @NotBlank(message = "Tên người thuê trọ không được để trống.")
    @Pattern(regexp = "^[A-Za-z\\s]{5,50}$", message = "Tên người thuê trọ không được chứa ký tự số và ký tự đặc biệt, độ dài từ 5 đến 50 ký tự.")
    private String tenNguoiThue;

    @Size(min = 10, max = 10, message = "Số điện thoại phải có độ dài 10 ký tự.")
    @Pattern(regexp = "^[0-9]{10}$", message = "Số điện thoại phải là các ký tự số.")
    private String soDienThoai;

    @FutureOrPresent(message = "Ngày thuê không được là ngày quá khứ.")
    private LocalDate ngayBatDauThue;


    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "hinh_thuc_thanh_toan_id")
    private HinhThucThanhToan hinhThucThanhToan;
}
