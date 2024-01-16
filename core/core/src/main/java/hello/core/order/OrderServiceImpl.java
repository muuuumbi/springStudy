package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //할인 정책 변경을 하려면 코드를 고쳐야 함. DIP위반, OCP위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //해결방법 : 인터페이스에만 의존하도록 설계 변경
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;//구현체가 없는데 어떻게 실행?? 구현 객체를 대신 생성해서 주입해주는 것이 필요

    //setter로 수정 위해서 final 제거. 생성자 제거
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;//구현체가 없는데 어떻게 실행?? 구현 객체를 대신 생성해서 주입해주는 것이 필요

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("첫번째 호출 1. OrderServiceImpl.OrderServiceImpl");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //일반메서드 주입
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //수정자
//    @Autowired(required = false)
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = " + memberRepository);
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = " + discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //1. 회원정보 조회
        Member member = memberRepository.findById(memberId);
        //2. 할인정책에 회원 넘김
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //설계가 잘됨. service에서는 할인에 대한 내용을 모름. 단일체계원칙을 잘 지킴.

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //싱글톤 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
