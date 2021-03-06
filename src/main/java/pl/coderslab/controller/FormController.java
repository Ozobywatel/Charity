package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.Category;
import pl.coderslab.model.Donation;
import pl.coderslab.model.Institution;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.DonationRepository;
import pl.coderslab.repository.InstitutionRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


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

    @ModelAttribute("categories")
    public List<Category> getCategories(){return categoryRepository.findAll();}

    @ModelAttribute("institutions")
    public List<Institution> getInstitutions(){return institutionRepository.findAll();}

    @RequestMapping(value = "/new_donation", method = RequestMethod.GET)
    public String formDonationAdd(Model model){
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @RequestMapping(value = "/new_donation", method = RequestMethod.POST)
    public String saveDonation(@Valid Donation donation, BindingResult result,
                               HttpSession session, Model model){
                if (result.hasErrors()) {
                    model.addAttribute("errors", result.getAllErrors());
            return "/validation-fail-list";
        }
            session.setAttribute("donation", donation);
        return "redirect:/new_donation_confirm#donation";
    }



}
