package zip.hyeon.lgtm.domain.member;

import static java.util.Objects.requireNonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import zip.hyeon.lgtm.application.member.dto.MemberRegisterRequest;
import zip.hyeon.lgtm.domain.AbstractTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends AbstractTimeEntity {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public static Member register(MemberRegisterRequest request) {
        Member member = new Member();

        member.username = requireNonNull(request.username());
        member.profileImageUrl = requireNonNull(request.profileImageUrl());
        member.role = Role.MEMBER;
        member.status = Status.ACTIVATED;

        return member;
    }

    public void update(MemberRegisterRequest request) {
        this.username = requireNonNull(request.username());
        this.profileImageUrl = requireNonNull(request.profileImageUrl());
    }
}
