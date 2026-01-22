package zip.hyeon.lgtm.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    PENDING("pending"),
    ACTIVATED("activated"),
    DEACTIVATED("deactivated"),
    BANNED("banned");

    private final String value;
}
