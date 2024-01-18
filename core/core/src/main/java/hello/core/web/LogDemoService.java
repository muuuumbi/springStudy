package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
//    private final ObjectProvider<MyLogger> myLoggerProvider; //Provider로 주입
    private final MyLogger myLogger; //프록시

    public void logic(String id){
//        MyLogger myLogger = myLoggerProvider.getObject(); //Provider로 빈 가져오기
        myLogger.log("service id = " + id);
    }
}
