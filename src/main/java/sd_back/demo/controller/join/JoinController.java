package sd_back.demo.controller.join;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sd_back.demo.domain.Member;
import sd_back.demo.repository.JpaMemberRepository;
import sd_back.demo.service.MemberService;
import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class JoinController {

    private final MemberService memberService;
    private final JpaMemberRepository jpaMemberRepository;

    @GetMapping("/join")
    public String joinForm(@ModelAttribute("joinForm") joinForm form) {
        return "join/joinForm";
    }

//    @PostMapping("/join")
    public String join(@Valid @ModelAttribute joinForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "join/joinForm";
        }

        Member joinMember = new Member(form.getStudentId(), form.getName(), form.getPassword());

        memberService.join(joinMember.getStudentId(), joinMember.getName(), joinMember.getPassword());

        return "join/joinSuccessForm";

    }

    @PostMapping("/join")
    public String joinVer2(@Valid @ModelAttribute joinForm form, BindingResult bindingResult) { //jpa 사용함

        if (bindingResult.hasErrors()) {
            return "join/joinForm";
        }

        Member joinMember = new Member(form.getStudentId(), form.getName(), form.getPassword());

        jpaMemberRepository.save(joinMember);

        return "join/joinSuccessForm";

    }
}
