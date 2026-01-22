package zip.hyeon.lgtm.application.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zip.hyeon.lgtm.application.member.provided.MemberFinder;
import zip.hyeon.lgtm.application.member.required.MemberRepository;
import zip.hyeon.lgtm.domain.member.Member;

@Service
@RequiredArgsConstructor
public class MemberQueryService implements MemberFinder {

    private final MemberRepository memberRepository;

    @Override
    public Member find(Long memberId) {
        return memberRepository.findById(memberId)
            .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다 id : " + memberId));
    }
}
