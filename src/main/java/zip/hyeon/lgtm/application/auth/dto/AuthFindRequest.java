package zip.hyeon.lgtm.application.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import zip.hyeon.lgtm.domain.auth.Provider;

public record AuthFindRequest(
    @NotNull Provider provider,
    @NotBlank String providerId) {

}
