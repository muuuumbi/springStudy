package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    //수정자주입 방식 테이스
//    @Test
//    void createOrder(){
//        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
//        memberRepository.save(new Member(1L, "name", Grade.VIP));
//
//        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
//        Order order = orderService.createOrder(1L, "itemA", 10000);
//        //-> 오류생김 왜? createOrder만 테스트하고 싶어도 가짜객체를 만들어서 넣어줘야 함
//        //파라미터에 new 객체를 넣어서 해야 함
//
//        assertThat(order.getDiscountPrice()).isEqualTo(1000);
//    }
}