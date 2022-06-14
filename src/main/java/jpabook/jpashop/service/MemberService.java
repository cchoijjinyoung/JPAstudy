package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //JPA는 가급적 트랜젝션 내에서 모두 실행되어야 한다. 디폴트는 false
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional // readOnly를 false로 쓰고 싶으나, 위에 클래스 단위에 true로 줌으로써 이 매서드에도 적용됨.
    // @Transactional 을 붙여줌으로써 우선권을 부여하자.
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    //단건 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
