package project.springsecurity.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetailsService;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity(name = "users")
public abstract class User implements UserDetailsService {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = true)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
