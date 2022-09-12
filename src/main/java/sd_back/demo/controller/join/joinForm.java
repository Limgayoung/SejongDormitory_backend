package sd_back.demo.controller.join;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class joinForm {

    @NotNull
    private Long studentId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;
}
