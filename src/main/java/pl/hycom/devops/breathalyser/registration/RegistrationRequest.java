package pl.hycom.devops.breathalyser.registration;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private String username;
    private String email;
    private String password;
    private float weight;
    private float height;
    private int age;
    private boolean sex;
}
