package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider; //MyLogger가 아닌 MyLogger를 찾을 수 있는 게 주입됨
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody //문자 바로 반환
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        String requestURL = request.getRequestURI().toString();
//        MyLogger myLogger = myLoggerProvider.getObject(); //실제 필요한 시점에 MyLogger를 받아옴.

        System.out.println("myLogger = " + myLogger.getClass()); //내가 만든 게 아니라 가짜가 프로바이더처럼 동작함
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        Thread.sleep(100); //테스트용
        logDemoService.logic("testId");
        return "OK";
    }

}
