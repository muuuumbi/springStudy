package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithProtorypeTest1 {

    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(2);
    }

    @Scope("singleton")
//    @RequiredArgsConstructor
    static class ClientBean{
//        private final PrototypeBean prototypeBean; //생성 시점에 주입됨
        //항상 새로운 프로토타입을 가져오고 싶으면?
//        @Autowired
//        ApplicationContext applicationContext;

        //Provider로 해결
        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanProvider; //간단하게 필드주입으로 테스트

//        @Autowired
//        ClientBean(PrototypeBean prototypeBean) {
//            this.prototypeBean = prototypeBean;
//        }

        public int logic(){
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            prototypeBean.addCount(); //이미 생성돼있는 것을 사용
            int count = prototypeBean.getCount();
            return count;
        }

//        public int logic(){
//            prototypeBean.addCount(); //이미 생성돼있는 것을 사용
//            int count = prototypeBean.getCount();
//            return count;
//        }

//        public int logic(){
//            PrototypeBean prototypeBean = applicationContext.getBean(PrototypeBean.class); //사용할 때마다 새로 생성
//            prototypeBean.addCount();
//            int count = prototypeBean.getCount();
//            return count;
//        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
