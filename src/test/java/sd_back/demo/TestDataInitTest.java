package sd_back.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import sd_back.demo.domain.Member;
import sd_back.demo.repository.MemberRepository;
import sd_back.demo.repository.MemoryMemberRepository;
import sd_back.demo.service.MemberService;

import static org.junit.jupiter.api.Assertions.*;


class TestDataInitTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
//    MemberService memberService = new MemberService(memberRepository); //memberRepository를 service에 주입

    @Test
    public void initData(){
        Member member = memberRepository.findByStudentId(18011552L).get();
        Assertions.assertThat(member.getName()).isEqualTo("임가영");
    }

}