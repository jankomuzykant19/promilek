package pl.hycom.devops.breathalyser.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.hycom.devops.breathalyser.model.CalculationModel;
import pl.hycom.devops.breathalyser.registration.RegistrationRequest;
import pl.hycom.devops.breathalyser.registration.RegistrationService;
import pl.hycom.devops.breathalyser.service.CalculationService;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Controller
public class BreathanalyserController {

    @Autowired
    private CalculationService calculationService;

    @Autowired
    private final RegistrationService registrationService;

    @GetMapping("/")
    public String start(Model model) {
        CalculationModel calculationModel = new CalculationModel();
        model.addAttribute("calculationModel", calculationModel);
        return "calculator";
    }

    @PostMapping("/calculate")
//    public String save(@ModelAttribute CalculationModel calculationModel, Model model, @RequestParam(name = "g-recaptcha-response") String captchaResponse) throws Exception {
    public String calculate(@ModelAttribute CalculationModel calculationModel, Model model) throws Exception {
//        String url = "https://www.google.com/recaptcha/api/siteverify";
//        String params = "?secret=6LepSVIcAAAAAN53XMelVvKf1GkEKeyYQz9g2eLl&response=" + captchaResponse;
//        ReCaptchaResponse reCaptchaResponse = restTemplate.exchange(url + params, HttpMethod.POST, null, ReCaptchaResponse.class).getBody();
//        if (reCaptchaResponse.isSuccess()) {
        calculationModel.setTime((float) ((CalculationService.getDateDiff(calculationModel.getStartDate(), calculationModel.getEndDate(), calculationModel.getStartTime(), calculationModel.getEndTime(), TimeUnit.MINUTES)) / 60.0));
        CalculationService.calculatePromiles(calculationModel);
        calculationModel.toString();
        model.addAttribute("calculationModel", calculationModel);
        return "redirect:/success";
//        } else {
//            message = "Please verify captcha";
//            return "redirect:/";
//        }
    }

    @GetMapping("/list")
    public String list(Model model) {
        return "list";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegistrationRequest registrationRequest = new RegistrationRequest();
        model.addAttribute("registerRequest", registrationRequest);
        return "register";
    }

    @PostMapping("/create-account")
    public String createAccount(@ModelAttribute RegistrationRequest registrationRequest, Model model) throws Exception {
        registrationRequest.toString();
        registrationService.register(registrationRequest);
        return "redirect:/confirm-email";
    }

    @GetMapping("/success")
    public String result(Model model) {
        return "result";
    }

    @GetMapping("/confirm-email")
    public String confirmEmail(Model model){
        return "confirmEmail";
    }
}
