package zip.hyeon.lgtm.application.auth.provided;

import jakarta.validation.Valid;
import java.util.Optional;
import zip.hyeon.lgtm.application.auth.dto.AuthFindRequest;

public interface AuthFinder {

    Optional<Long> findMemberIdByProviderAndProviderId(@Valid AuthFindRequest request);
}
