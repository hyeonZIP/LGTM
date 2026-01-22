package zip.hyeon.lgtm.application.member.provided;

import zip.hyeon.lgtm.domain.member.Member;

public interface MemberFinder {

    Member find(Long memberId);
}
