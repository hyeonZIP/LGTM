package zip.hyeon.lgtm.domain.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Provider {
    GITHUB("github");

    private final String value;
}
