package com.bets.be_admissionswebsite.phongtro.Repository;

import com.bets.be_admissionswebsite.phongtro.models.HinhThucThanhToan;
import com.bets.be_admissionswebsite.phongtro.models.PhongTro;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PhongTroRepository extends JpaRepository<PhongTro, Long> {
@Query("SELECT MAX(p.id) FROM PhongTro p")
    Optional<Long> findMaxId();


    @Modifying
    @Transactional
    @Query("DELETE FROM PhongTro p WHERE p.id IN :ids")
    void deleteAllById(@Param("ids") List<Long> ids);
}

