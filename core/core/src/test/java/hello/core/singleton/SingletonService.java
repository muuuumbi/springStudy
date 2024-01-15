package hello.core.singleton;

public class SingletonService {
    //이렇게 하면 딱 하나만 올라가게 된다는 게 무슨 뜻? static 영역 공부해보기
    private static final SingletonService instance = new SingletonService();

    //조회
    public static SingletonService getInstance(){
        return instance;
    }

    //생성 : private 생성자
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
