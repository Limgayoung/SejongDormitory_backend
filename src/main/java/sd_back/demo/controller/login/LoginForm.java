package sd_back.demo.controller.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginForm {

    @NotNull
    private Long loginId;

    @NotEmpty
    private String password;

}
