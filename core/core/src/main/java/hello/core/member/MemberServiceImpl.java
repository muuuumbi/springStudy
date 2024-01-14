package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //가입과 찾기를 이용하려면 레포지토리가 필요
    //인터페이스만 갖고 있고 구현 객체가 없으면 nullpointException 생김.
    //구현 객체 선택해줘야 함. (다형성)
//    private final MemberRepository memberRepository = new MemoryMemberRepository();//추상화, 구체화 모두 의존. DIP 위반
    //추상화에만 의존
    private final MemberRepository memberRepository; //MemoryMemberRepository가 할당됨

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMemebr(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
