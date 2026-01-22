package zip.hyeon.lgtm.application.auth;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zip.hyeon.lgtm.application.auth.dto.AuthFindRequest;
import zip.hyeon.lgtm.application.auth.provided.AuthFinder;
import zip.hyeon.lgtm.application.auth.required.AuthRepository;

@Service
@RequiredArgsConstructor
public class AuthQueryService implements AuthFinder {

    private final AuthRepository authRepository;

    @Override
    public Optional<Long> findMemberIdByProviderAndProviderId(AuthFindRequest request) {

        return authRepository.findMemberIdByProviderAndProviderId(
            request.provider(),
            request.providerId()
        );
    }
}
