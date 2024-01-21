package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    //애플리케이션 로직으로 main method 확인하는 것은 한계가 있음. -> Junit이라는 테이스 프레임워크 사용 (기본세팅)
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = new MemberServiceImpl(memberRepository);
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //스프링컨테이너를 통해서 찾아오기 (이름(메서드이름), 반환타입)
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMemebr(1L);
        //가입멤버와 찾은 멤버가 같으면 성공
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
