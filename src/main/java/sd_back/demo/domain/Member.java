package sd_back.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private Long id;
    private Long studentId;
    private String name;
    private String password;

    public Member(Long studentId, String name, String password) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
    }
}
