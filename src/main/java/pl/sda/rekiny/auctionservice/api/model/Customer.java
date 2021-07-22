package pl.sda.rekiny.auctionservice.api.model;

import lombok.*;

import javax.validation.constraints.Email;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Customer {
    private Long id;
    @Email
    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private String role; // todo admin or casual user

}
