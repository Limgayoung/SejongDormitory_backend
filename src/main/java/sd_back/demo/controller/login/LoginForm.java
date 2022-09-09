package sd_back.demo.controller.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty
    private Long loginId;

    @NotEmpty
    private String password;

}
