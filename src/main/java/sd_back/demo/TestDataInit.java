package sd_back.demo;

import lombok.RequiredArgsConstructor;
import sd_back.demo.domain.Member;
import sd_back.demo.repository.MemberRepository;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;

    //test용 데이터 추가
    @PostConstruct
    public void init(){
        memberRepository.save(new Member(18011552L, "임가영", "test"));
    }
}
