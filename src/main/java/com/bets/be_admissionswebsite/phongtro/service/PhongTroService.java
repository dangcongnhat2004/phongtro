package com.bets.be_admissionswebsite.phongtro.service;

import com.bets.be_admissionswebsite.phongtro.Repository.HinhThucThanhToanRepository;
import com.bets.be_admissionswebsite.phongtro.Repository.PhongTroRepository;
import com.bets.be_admissionswebsite.phongtro.models.HinhThucThanhToan;
import com.bets.be_admissionswebsite.phongtro.models.PhongTro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongTroService {

    @Autowired
    private PhongTroRepository phongTroRepository;

    @Autowired
    private HinhThucThanhToanRepository hinhThucThanhToanRepository;
    public void deletePhongTroByIds(List<Long> selectedIds) {
        if (selectedIds != null && !selectedIds.isEmpty()) {
            phongTroRepository.deleteAllById(selectedIds);  // Gọi phương thức xóa theo danh sách ID
        }
    }
    public PhongTro save(PhongTro phongTro) {
        if (phongTro.getId() == null) {
            long maxId = phongTroRepository.findMaxId().orElse(0L);
            String maPhong = String.format("PT-%03d", maxId + 1);
            phongTro.setMaPhong(maPhong);
        }
        return phongTroRepository.save(phongTro);
    }

    public List<PhongTro> findAll() {
        return phongTroRepository.findAll();
    }

    public List<HinhThucThanhToan> findAllHinhThucThanhToan() {
        return hinhThucThanhToanRepository.findAll();
    }
    public HinhThucThanhToan findHinhThucById(Long id) {
        return hinhThucThanhToanRepository.findById(id).orElse(null);
    }

}
