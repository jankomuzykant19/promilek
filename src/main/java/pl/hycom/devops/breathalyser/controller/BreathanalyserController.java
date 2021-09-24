package pl.hycom.devops.breathalyser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.hycom.devops.breathalyser.model.CalculationModel;
import pl.hycom.devops.breathalyser.service.CalculationService;

import java.util.concurrent.TimeUnit;

@Controller
public class BreathanalyserController {

    @Autowired
    private CalculationService calculationService;

    @GetMapping("/")
    public String start(Model model) {
        CalculationModel calculationModel = new CalculationModel();
        model.addAttribute("submit", calculationModel);
        return "submit";
    }

    @PostMapping("/submit")
//    public String save(@ModelAttribute CalculationModel calculationModel, Model model, @RequestParam(name = "g-recaptcha-response") String captchaResponse) throws Exception {
    public String calculate(@ModelAttribute CalculationModel calculationModel, Model model) throws Exception {
//        String url = "https://www.google.com/recaptcha/api/siteverify";
//        String params = "?secret=6LepSVIcAAAAAN53XMelVvKf1GkEKeyYQz9g2eLl&response=" + captchaResponse;

//        ReCaptchaResponse reCaptchaResponse = restTemplate.exchange(url + params, HttpMethod.POST, null, ReCaptchaResponse.class).getBody();
//        if (reCaptchaResponse.isSuccess()) {
        calculationModel.setTime((float) ((calculationService.getDateDiff(calculationModel.getStartDate(), calculationModel.getEndDate(), calculationModel.getStartTime(), calculationModel.getEndTime(), TimeUnit.MINUTES))/60.0));
        CalculationService.calculatePromiles(calculationModel);
        calculationModel.toString();
        model.addAttribute("submit", calculationModel);
        return "redirect:/success";
//        } else {
//            message = "Please verify captcha";
//            return "redirect:/";
//        }
    }

    @GetMapping("/success")
    public String list(Model model) {
        return "result";
    }
}
