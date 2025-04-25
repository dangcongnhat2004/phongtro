package com.bets.be_admissionswebsite.phongtro.controller;

import com.bets.be_admissionswebsite.phongtro.Repository.PhongTroRepository;
import com.bets.be_admissionswebsite.phongtro.models.HinhThucThanhToan;
import com.bets.be_admissionswebsite.phongtro.models.PhongTro;
import com.bets.be_admissionswebsite.phongtro.service.PhongTroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/phongtro")
public class PhongTroController {

    @Autowired
    private PhongTroService phongTroService;
    @Autowired
    private PhongTroRepository phongTroRepository;
    @GetMapping
    public String danhSach(Model model) {
        model.addAttribute("danhSach", phongTroService.findAll());
        model.addAttribute("phongTro", new PhongTro()); // Dùng cho form tạo mới
        model.addAttribute("dsHinhThuc", phongTroService.findAllHinhThucThanhToan());
        return "phongtro_list";
    }
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("phongTro") PhongTro phongTro,
                       BindingResult result,
                       @RequestParam("hinhThucThanhToan.id") Long htttId,
                       Model model) {

        if (result.hasErrors()) {
            model.addAttribute("danhSach", phongTroService.findAll());
            model.addAttribute("dsHinhThuc", phongTroService.findAllHinhThucThanhToan());
            model.addAttribute("formVisible", true);
            return "phongtro_list";
        }

        HinhThucThanhToan httt = phongTroService.findHinhThucById(htttId);
        phongTro.setHinhThucThanhToan(httt);

        phongTroService.save(phongTro);
        return "redirect:/phongtro";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("phongTro", new PhongTro());
        model.addAttribute("danhSach", phongTroService.findAll());
        model.addAttribute("dsHinhThuc", phongTroService.findAllHinhThucThanhToan());
        model.addAttribute("formVisible", true); // bật form
        return "phongtro_list";
    }

    @GetMapping("/list")
    public String listPhongTro(Model model) {
        model.addAttribute("phongTroList", phongTroService.findAll());
        return "phongtro_list";  // Trả về giao diện danh sách phòng trọ
    }
    @PostMapping("/deletePhongTro")
    public String deletePhongTro(@RequestParam("selectedIds") List<Long> selectedIds, Model model) {
        if (selectedIds != null && !selectedIds.isEmpty()) {
            phongTroService.deletePhongTroByIds(selectedIds); // Xóa các phòng trọ đã chọn
        }
        return "redirect:/phongtro/list";  // Quay lại trang danh sách
    }

}
