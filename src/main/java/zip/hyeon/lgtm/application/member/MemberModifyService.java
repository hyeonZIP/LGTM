package zip.hyeon.lgtm.application.member;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import zip.hyeon.lgtm.application.auth.dto.AuthRegisterRequest;
import zip.hyeon.lgtm.application.auth.provided.AuthRegister;
import zip.hyeon.lgtm.application.auth.required.AuthRepository;
import zip.hyeon.lgtm.application.member.dto.MemberRegisterRequest;
import zip.hyeon.lgtm.application.member.provided.MemberRegister;
import zip.hyeon.lgtm.application.member.required.MemberRepository;
import zip.hyeon.lgtm.domain.member.Member;

@Service
@Validated
@RequiredArgsConstructor
public class MemberModifyService implements MemberRegister {

    private final AuthRepository authRepository;
    private final AuthRegister authRegister;
    private final MemberRepository memberRepository;

    @Override
    public Member registerOrUpdate(MemberRegisterRequest request) {
        return authRepository.findByProviderAndProviderId(request.provider(), request.providerId())
            .map(auth -> {
                Member member = memberRepository.findById(auth.getMember().getId()).orElseThrow(
                    () -> new EntityNotFoundException("해당 인증 정보와 연결된 회원 정보를 찾을 수 없습니다."));

                member.update(request);

                return memberRepository.save(member);
            }).orElseGet(() -> {
                Member member = memberRepository.save(Member.register(request));

                authRegister.register(toAuthRegisterRequest(request, member));

                return member;
            });
    }

    private AuthRegisterRequest toAuthRegisterRequest(MemberRegisterRequest request,
        Member member) {
        return new AuthRegisterRequest(request.provider(), request.providerId(), member);
    }
}
