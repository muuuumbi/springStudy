package hello.core;

import hello.core.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//자동 생성된 것. 실행하면 spring 띄워야 해서 오래 걸림 -> 단위테스트(순수 자바 코드)가 중요한 이유
@SpringBootTest
class CoreApplicationTests {

    //필드 주입 사용해도 되는 곳
    //이렇게 하면 스프링 컨테이너에 스프링 빈 다 올린 다음에 얘를 바로 테스트 할 수 있기 때문에 편함.
    @Autowired
    OrderService orderService;

//	@Test
//	void contextLoads() {
//	}
//    왜 오류나는지??

}
