package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
//    MemberService memberService = new MemberServiceImpl(memberRepository);
    MemberService memberService; //AppConfig에서 바로 꺼내오기가 애매함. why?

    @BeforeEach
    public void beforeEach(){ //테스트 메서드 실행 이전에 수행
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given : ~~주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when : ~~했을 때
        memberService.join(member);
        Member findMember = memberService.findMemebr(1L);

        //then : 이렇게 된다. (검증)
        //org.assertj.core.api
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
