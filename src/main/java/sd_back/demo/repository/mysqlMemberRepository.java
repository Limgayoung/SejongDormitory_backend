package sd_back.demo.repository;

import sd_back.demo.domain.Member;

import java.util.List;
import java.util.Optional;

//mysql Repository
public class mysqlMemberRepository implements MemberRepository{
    @Override
    public Member save(Member memeber) {
        return null;
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
