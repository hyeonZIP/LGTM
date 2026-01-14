package zip.hyeon.lgtm.application.member.provided;

import jakarta.validation.Valid;
import zip.hyeon.lgtm.application.member.dto.MemberRegisterRequest;
import zip.hyeon.lgtm.domain.member.Member;

/**
 * 회원 등록 또는 업데이트 기능을 제공한다
 */
public interface MemberRegister {

    Member registerOrUpdate(@Valid MemberRegisterRequest request);
}
