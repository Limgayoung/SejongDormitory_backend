package sd_back.demo.repository;

import sd_back.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member memeber); //저장
    
    //조회
    Optional<Member> findById(Long id);
    Optional<Member> findByStudentId(Long studentId);
    List<Member> findAll();

    void delete(Member member); //삭제

    void update(Long id, Member updateMember); //수정
}
