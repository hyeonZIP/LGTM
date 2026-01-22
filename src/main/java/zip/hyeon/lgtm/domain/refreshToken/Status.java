package zip.hyeon.lgtm.domain.refreshToken;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    REVOKED("revoked"),
    EXPIRED("expired"),
    ACTIVATED("activated");

    private final String value;
}
