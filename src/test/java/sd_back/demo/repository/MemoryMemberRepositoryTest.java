package sd_back.demo.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import sd_back.demo.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void afterEach(){ //테스트 끝나면 store 비워줌
        memberRepository.clearStore();
    }

    @Test
    void saveTest(){
        Member member1 = new Member(18011552L, "흠냐", "test");
        memberRepository.save(member1);
        Member findMember = memberRepository.findByStudentId(member1.getStudentId()).get(); //optional이라서

        assertThat(findMember).isEqualTo(member1);
    }

    @Test
    void findById(){
        Member member1 = new Member(18011552L, "히히", "test");

        memberRepository.save(member1);
        Member findMember = memberRepository.findById(member1.getId()).get();

        assertThat(findMember.getStudentId()).isEqualTo(member1.getStudentId());
    }

    @Test
    void findByStudentId(){
        Member member1 = new Member(18011552L, "히히", "test");

        memberRepository.save(member1);
        Member findMember = memberRepository.findByStudentId(18011552L).get();

        assertThat(findMember.getStudentId()).isEqualTo(member1.getStudentId());
    }

    @Test
    void findAll(){
        Member member1 = new Member(18011552L, "히히", "test");
        Member member2 = new Member(18011551L, "하하", "test2");

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> memberList = memberRepository.findAll();

        assertThat(memberList.size()).isEqualTo(2);
    }

    @Test
    void delete(){
        Member member1 = new Member(18011552L, "히히", "test");
        Member member2 = new Member(18011551L, "하하", "test2");

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.delete(member2);

        List<Member> memberList = memberRepository.findAll();
        assertThat(memberList.size()).isEqualTo(1);
    }

    @Test
    void update(){
        Member member1 = new Member(18011552L, "히히", "test");
        memberRepository.save(member1);
        Member updateMember = new Member(18011551L, "하하", "change");
        memberRepository.update(member1.getId(), updateMember);

        assertThat(member1.getName()).isEqualTo("하하");
    }
}