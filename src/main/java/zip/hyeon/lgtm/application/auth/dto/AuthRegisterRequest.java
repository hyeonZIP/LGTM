package zip.hyeon.lgtm.application.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import zip.hyeon.lgtm.domain.auth.Provider;
import zip.hyeon.lgtm.domain.member.Member;

public record AuthRegisterRequest(
    @NotNull Provider provider,
    @NotBlank String providerId,
    @NotNull Member member) {

}
