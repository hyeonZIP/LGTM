package zip.hyeon.lgtm.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import zip.hyeon.lgtm.application.member.dto.MemberRegisterRequest;
import zip.hyeon.lgtm.domain.auth.Provider;

class MemberTest {

    Member member;

    @BeforeEach
    void setUp() {
        member = Member.register(
            new MemberRegisterRequest(Provider.GITHUB, "providerId", "username", "profile.jpg"));
    }

    @Test
    @DisplayName("등록된 회원의 기본값은 활성화 및 일반 회원이다")
    void registerMember() {
        assertThat(member.getStatus()).isEqualTo(Status.ACTIVATED);
        assertThat(member.getRole()).isEqualTo(Role.MEMBER);
    }

    @Test
    @DisplayName("회원 정보를 업데이트 한다")
    void updateMember() {
        var newRequest = new MemberRegisterRequest(Provider.GITHUB, "providerId", "newName",
            "newProfile.png");

        member.update(newRequest);

        assertThat(member.getUsername()).isEqualTo(newRequest.username());
        assertThat(member.getProfileImageUrl()).isEqualTo(newRequest.profileImageUrl());
    }
}
