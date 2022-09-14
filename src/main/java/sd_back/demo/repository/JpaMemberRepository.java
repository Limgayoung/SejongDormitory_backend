package sd_back.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sd_back.demo.domain.Member;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByStudentId(Long studentId);
    //기본적인 CRUD 메소드를 바로바로 만들어줌
    //findBy[칼럼명, 첫글자 대문자로]
    
    //메소드 실행 시 DB에 바로 실행됨
}
