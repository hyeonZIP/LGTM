package zip.hyeon.lgtm.domain.auth;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import zip.hyeon.lgtm.domain.AbstractTimeEntity;
import zip.hyeon.lgtm.domain.member.Member;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Auth extends AbstractTimeEntity {
    @Column(nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private Provider provider;

    @Column(nullable = false, updatable = false)
    private String providerId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(nullable = false, updatable = false, name = "member_id")
    private Member member;
}
