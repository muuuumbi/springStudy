package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //rateDiscount와 같은 타입이라 오휴 발생함.
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000; //1000원 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ //eunm은 == 사용
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
