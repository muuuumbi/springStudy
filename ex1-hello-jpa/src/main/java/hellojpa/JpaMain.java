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
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
//            member.setTeamId(team.getId()); //객체지향스럽지 않음
            member.setTeam(team);
            em.persist(member);

            //영속성 컨텍스트가 아닌 DB에서 가져오는 쿼리를 보고 싶으면
            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());

//            Long findTeamId = findMember.getTeamId(); //객체지향스럽지 않음
//            Team findTeam = em.find(Team.class, findTeamId);
            Team findTeam = findMember.getTeam();

//            Team newTeam = em.find(Team.class, 100L);//100번 팀이 있다고 가정
//            findMember.setTeam(newTeam); //연관관계 수정

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
