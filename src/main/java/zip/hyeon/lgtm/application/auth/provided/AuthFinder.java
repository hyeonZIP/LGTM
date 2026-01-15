package zip.hyeon.lgtm.application.auth.provided;

import jakarta.validation.Valid;
import java.util.Optional;
import zip.hyeon.lgtm.application.auth.dto.AuthFindRequest;
import zip.hyeon.lgtm.domain.auth.Auth;

public interface AuthFinder {

    Optional<Auth> find(@Valid AuthFindRequest request);
}
