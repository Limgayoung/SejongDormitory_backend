package sd_back.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sd_back.demo.domain.Member;

import java.util.List;
import java.util.Optional;

//mysql Repository
public abstract class mysqlMemberRepository implements MemberRepository{
    @Override
    public Member save(Member member) {

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByStudentId(Long studentId) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public void delete(Member member) {

    }

    @Override
    public void update(Long id, Member updateMember) {

    }
}
