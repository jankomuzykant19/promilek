package pl.hycom.devops.breathalyser.registration.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.hycom.devops.breathalyser.user.AppUser;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ConfirmationToken {

    @SequenceGenerator(
            name = "confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    @Id
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private LocalDateTime expireDate;

    private LocalDateTime confirmedDate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "app_user_id")
    private AppUser appUser;

    public ConfirmationToken(String token, LocalDateTime createDate, LocalDateTime expireDate, LocalDateTime confirmedDate, AppUser appUser) {
        this.token = token;
        this.createDate = createDate;
        this.expireDate = expireDate;
        this.confirmedDate = confirmedDate;
        this.appUser = appUser;
    }
}
