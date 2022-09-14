package sd_back.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sd_back.demo.domain.Member;
import sd_back.demo.repository.JpaMemberRepository;
import sd_back.demo.repository.MemoryMemberRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor //final이 선언된 모든 필드를 인자값으로 하는 생성자 만들어줌 (의존성 자동 주입)
public class MemberService {

    //private final MemoryMemberRepository memberRepository;
    private final JpaMemberRepository memberRepository;

    public Member login(Long studentId, String password) { //로그인

        //Member member = memberRepository.findById(id).orElseThrow(() -> new NoSuchElementException("해당하는 id가 없습니다."));
        //Optional<Member> findMemberOptional = memberRepository.findByStudentId(studentId);
        //Member member = findMemberOptional.get();

        Optional<Member> findMember = memberRepository.findByStudentId(studentId);
        Member member = findMember.get();

        if (member.getPassword().equals(password)) { //login 성공
            return member;
        }
        else{
            return null;
        }
    }
    public void join(Long studentId, String name, String password){ //회원가입
        Member member = new Member(studentId,name,password);
        memberRepository.save(member);
    }
}
