package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();//transaction 생성
        tx.begin();//transaction 시작

        /*
        실제 동작 코드 작성 시작
        ex) DB에 데이터 저장, 조회 등
         */
        try {
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloA");

//            Member member = new Member(200L, "member200");

            //회원 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

//            System.out.println("=== BEFORE ===");
//            em.persist(member);
//            System.out.println("=== AFTER ===");

//            em.flush();

//            Member findMemebr = em.find(Member.class, 101L);

//            System.out.println("findMemebr.getId() = " + findMemebr.getId());
//            System.out.println("findMemebr.getId() = " + findMemebr.getName());

            tx.commit(); //commit 문제 생기면 rollback 해줘야
        }catch(Exception e){
            tx.rollback();
        }finally {
            //실제 동작 코드 작성 끝
            em.close(); //끝나면 닫아줘야 함.
        }
        emf.close();
    }
}
