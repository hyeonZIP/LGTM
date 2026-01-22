package zip.hyeon.lgtm.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberTest {

    Member member;

    @BeforeEach
    void setUp() {
        member = Member.register(new MemberRegisterRequest("username", "profile.jpg"));
    }

    @Test
    void registerMember() {
        assertThat(member.getStatus()).isEqualTo(Status.ACTIVATED);
        assertThat(member.getRole()).isEqualTo(Role.MEMBER);
    }

    @Test
    void updateMember() {
        var updateRequest = new MemberUpdateRequest("newName", "newProfile.png");

        member.update(updateRequest);

        assertThat(member.getUsername()).isEqualTo(updateRequest.username());
        assertThat(member.getProfileImageUrl()).isEqualTo(updateRequest.profileImageUrl());
    }
}
