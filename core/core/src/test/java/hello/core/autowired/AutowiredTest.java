package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        //자동 주입 대상을 옵션으로 처리하는 방법
        //1. @Autowried(required = false) 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨.
        @Autowired(required = false)//true로 하면 오류 터짐
        public void setNoBean1(Member noBean1){ //스프링컨테이너로 관리되지 않는(member)넣어줌
            System.out.println("noBean1 = " + noBean1);
        }
        //2. org.springframework.lang.@Nullable : 자동 주입할 대상이 없으면 null이 입력된다
         @Autowired
         public void setNoBean2(@Nullable Member noBean2){ //스프링컨테이너로 관리되지 않는(member)넣어줌
             System.out.println("noBean2 = " + noBean2);
         }
        //3. Optional<> : 자동 주입할 대상이 없으면 Optional.empty 가 입력된다.
        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
