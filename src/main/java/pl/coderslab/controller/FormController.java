package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.Category;
import pl.coderslab.model.Donation;
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

    @RequestMapping(value = "/new_donation", method = RequestMethod.GET)
    public String homeAction(Model model){
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institutions", institutionRepository.findAll());
        return "form";
    }

}
