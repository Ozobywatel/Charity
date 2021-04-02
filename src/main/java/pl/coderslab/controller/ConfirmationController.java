package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.Donation;
import pl.coderslab.repository.DonationRepository;

import javax.servlet.http.HttpSession;

@Controller
public class ConfirmationController {

    private final DonationRepository donationRepository;

    public ConfirmationController(DonationRepository donationRepository){
        this.donationRepository = donationRepository;
    }

    @RequestMapping(value = "/new_donation_confirm", method = RequestMethod.GET)
    public String formDonationAdd(Model model, HttpSession session){
        return "confirm";
    }

    @RequestMapping(value = "/new_donation_confirm", method = RequestMethod.POST)
    public String saveDonation(HttpSession session){

        donationRepository.save((Donation) session.getAttribute("donation"));
        return "redirect:/finish";
    }

    @RequestMapping("/finish")
    public String thankYouScreen(){
        return "thankYouScreen";
    }
}
