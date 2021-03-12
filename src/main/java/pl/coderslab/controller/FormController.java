package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Category;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.DonationRepository;
import pl.coderslab.repository.InstitutionRepository;


@Controller
public class FormController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;

    public FormController(InstitutionRepository institutionRepository, DonationRepository donationRepository, CategoryRepository categoryRepository){
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/123")
    public String homeAction(Model model){

        model.addAttribute("institutions", institutionRepository.findAll());
        model.addAttribute("gifts", donationRepository.count());
        model.addAttribute("bags", donationRepository.sumBagsByQuantity());
        return "index";
    }

}
