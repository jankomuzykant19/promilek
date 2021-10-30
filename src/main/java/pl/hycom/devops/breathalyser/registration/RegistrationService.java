package pl.hycom.devops.breathalyser.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.hycom.devops.breathalyser.user.AppUser;
import pl.hycom.devops.breathalyser.user.AppUserRole;
import pl.hycom.devops.breathalyser.user.AppUserService;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException(request.getEmail() + " is not valid");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getWeight(),
                        request.getHeight(),
                        request.getAge(),
                        request.isSex(),
                        AppUserRole.USER
                )
        );
    }
}
