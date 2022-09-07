package sd_back.demo.repository;

import org.springframework.stereotype.Repository;
import sd_back.demo.domain.Member;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long num = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++num);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) { //id로 찾기

        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByStudentId(Long studentId) {

        return store.values().stream() //store 값들 중에서
                .filter(member -> member.getStudentId().equals(studentId)) //이런 조건 가진 멤버
                .findAny(); //순서 상관없이 아무거나 (어짜피 중복 안됨)
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(Member member) {
        store.remove(member.getId());
    }

    @Override
    public void update(Long id, Member updateMember) {
        Member member = findById(id).orElseThrow(()->new NoSuchElementException("해당하는 회원이 없습니다"));
        member.setName(updateMember.getName());
        member.setStudentId(updateMember.getStudentId());
        member.setPassword(updateMember.getPassword());
    }

    public void clearStore(){ //메모리 지워주기
        store.clear();
    }
}
