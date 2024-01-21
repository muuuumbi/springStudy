package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//애플리케이션 전체를 설정하고 구성
@Configuration
public class AppConfig {
    //중복이 존재하고, 역할에 따른 구현이 보이지 않음

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    // 싱글톤이 깨지는 거 아닌가? 스프링 컨테이너가 어떻게 해결할까?

    //예상
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //실제
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService

    //자동의존관계주입
//    @Autowired
//    MemberRepository memberRepository;
//    @Bean
//    public MemberService memberService(){
//        System.out.println("call AppConfig.memberService");
//        return new MemberServiceImpl(memberRepository());
//    }

//    @Bean
//    public MemberRepository memberRepository(){
//        System.out.println("call AppConfig.memberRepository");
//        return new MemoryMemberRepository();
//    }

//    @Bean
//    public OrderService orderService(){
//        System.out.println("call AppConfig.orderService");
//        //의존관계 필드 주입 예시 위해 잠시 주석 처리
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
////        return null;
//    }

//    @Bean
//    public DiscountPolicy discountPolicy(){
////        return new FixDiscountPolicy();
//        return new RateDiscountPolicy(); //할인정책 변경
//    }


}
