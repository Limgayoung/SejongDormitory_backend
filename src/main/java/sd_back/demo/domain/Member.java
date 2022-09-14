package sd_back.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@AllArgsConstructor, @NoArgsConstructor는 @Builder 사용 시 항상 같이 넣어줘야 컴파일 할 때 에러가 안생김
public class Member {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 생성
    private Long id;
    @Column
    private Long studentId;

    private String name;

    private String password;

    public Member(Long studentId, String name, String password) {
        this.studentId = studentId;
        this.name = name;
        this.password = password;
    }

}
