package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient{
    private String url;
    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url){
        this.url = url;
    }

    //서비스 시작 시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call : " + url + " message = " + message);
    }

    //서비스 종료 시 호출
    public void disconnect(){
        System.out.println("close : " + url);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }

    //2. 빈 설정 정보로 등록해 사용하기
//    public void init(){
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    public void close(){
//        disconnect();
//    }

    //3. 애노테이션 사용하기
    @PostConstruct
    public void init(){
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close(){
        disconnect();
    }
}
