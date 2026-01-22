package zip.hyeon.lgtm.application.member.provided;

import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import zip.hyeon.lgtm.application.auth.dto.AuthRegisterRequest;
import zip.hyeon.lgtm.application.auth.provided.AuthFinder;
import zip.hyeon.lgtm.application.auth.provided.AuthRegister;
import zip.hyeon.lgtm.application.member.MemberModifyService;
import zip.hyeon.lgtm.application.member.dto.OAuth2MemberRegisterRequest;
import zip.hyeon.lgtm.application.member.required.MemberRepository;
import zip.hyeon.lgtm.domain.auth.Provider;
import zip.hyeon.lgtm.domain.member.Member;

@ExtendWith(MockitoExtension.class)
class MemberRegisterTest {

    @InjectMocks
    private MemberModifyService memberModifyService;
    @Mock
    MemberFinder memberFinder;
    @Mock
    AuthRegister authRegister;
    @Mock
    MemberRepository memberRepository;
    @Mock
    AuthFinder authFinder;

    @Test
    void registerOAuth2Member() {
        var request = new OAuth2MemberRegisterRequest(Provider.GITHUB, "providerId", "username",
            "profile.jpg");
        given(authFinder.findMemberIdByProviderAndProviderId(any())).willReturn(Optional.empty());

        memberModifyService.registerOrUpdate(request);

        verify(authRegister).register(any(AuthRegisterRequest.class));
        verify(memberRepository).save(any(Member.class));
    }

    @Test
    void updateOAuth2Member() {
        var request = new OAuth2MemberRegisterRequest(Provider.GITHUB, "providerId", "username",
            "profile.jpg");
        Member existingMember = mock(Member.class);
        given(authFinder.findMemberIdByProviderAndProviderId(any())).willReturn(Optional.of(1L));
        given(memberRepository.save(any())).willReturn(existingMember);
        given(memberFinder.find(any())).willReturn(existingMember);

        memberModifyService.registerOrUpdate(request);

        verify(existingMember).update(any());
        verify(memberRepository).save(existingMember);
        verify(authRegister, never()).register(any());
    }
}
