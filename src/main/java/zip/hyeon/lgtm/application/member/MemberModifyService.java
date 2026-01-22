package zip.hyeon.lgtm.application.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import zip.hyeon.lgtm.application.auth.dto.AuthFindRequest;
import zip.hyeon.lgtm.application.auth.dto.AuthRegisterRequest;
import zip.hyeon.lgtm.application.auth.provided.AuthFinder;
import zip.hyeon.lgtm.application.auth.provided.AuthRegister;
import zip.hyeon.lgtm.application.member.dto.MemberRegisterRequest;
import zip.hyeon.lgtm.application.member.dto.MemberUpdateRequest;
import zip.hyeon.lgtm.application.member.dto.OAuth2MemberRegisterRequest;
import zip.hyeon.lgtm.application.member.provided.MemberFinder;
import zip.hyeon.lgtm.application.member.provided.MemberRegister;
import zip.hyeon.lgtm.application.member.required.MemberRepository;
import zip.hyeon.lgtm.domain.member.Member;

@Service
@Validated
@RequiredArgsConstructor
public class MemberModifyService implements MemberRegister {

    private final MemberFinder memberFinder;
    private final AuthRegister authRegister;
    private final MemberRepository memberRepository;
    private final AuthFinder authFinder;

    @Override
    public Member registerOrUpdate(OAuth2MemberRegisterRequest request) {

        return authFinder.findMemberIdByProviderAndProviderId(toAuthFindRequest(request))
            .map(memberId -> getUpdatedMember(memberId, request))
            .orElseGet(() -> getRegisteredMember(request));
    }

    private Member getRegisteredMember(OAuth2MemberRegisterRequest request) {
        Member member = Member.register(toMemberRegisterRequest(request));

        authRegister.register(toAuthRegisterRequest(request, member));

        return memberRepository.save(member);
    }

    private Member getUpdatedMember(Long memberId, OAuth2MemberRegisterRequest request) {
        Member member = memberFinder.find(memberId);

        member.update(toMemberUpdateRequest(request));

        return memberRepository.save(member);
    }

    private AuthFindRequest toAuthFindRequest(OAuth2MemberRegisterRequest request) {
        return new AuthFindRequest(request.provider(), request.providerId());
    }

    private AuthRegisterRequest toAuthRegisterRequest(OAuth2MemberRegisterRequest request,
        Member member) {
        return new AuthRegisterRequest(request.provider(), request.providerId(), member);
    }

    private MemberUpdateRequest toMemberUpdateRequest(OAuth2MemberRegisterRequest request) {
        return new MemberUpdateRequest(request.username(), request.profileImageUrl());
    }

    private MemberRegisterRequest toMemberRegisterRequest(OAuth2MemberRegisterRequest request) {
        return new MemberRegisterRequest(request.username(), request.profileImageUrl());
    }
}
