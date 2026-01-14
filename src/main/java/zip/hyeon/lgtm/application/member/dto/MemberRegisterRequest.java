package zip.hyeon.lgtm.application.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import zip.hyeon.lgtm.domain.auth.Provider;

public record MemberRegisterRequest(
    @NotNull Provider provider,
    @NotBlank String providerId,
    @NotBlank String username,
    @NotNull String profileImageUrl) {

}
