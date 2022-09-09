package sd_back.demo.controller.login;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sd_back.demo.domain.Member;
import sd_back.demo.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
//@RestController
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,

                        HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Member loginMember = memberService.login(form.getLoginId(), form.getPassword());
        if (loginMember == null) { //로그인 실패
            bindingResult.reject("loginFail", "아이디/비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
        log.debug(""+loginMember.getStudentId());

        //로그인 성공
        HttpSession session = request.getSession(); //있으면 그 세션 넘겨주고 없으면 세션 만들어서 넘겨줌
        session.setAttribute("loginMember", loginMember); //나중에 name 부분은 const로 바꿔서 넘겨주기 (수정에 용이하게)
        log.debug("로그인 성공!");

        //화면이 안넘어가는 오류 해결해야함!
        return "login/loginSuccessForm";
    }
}
