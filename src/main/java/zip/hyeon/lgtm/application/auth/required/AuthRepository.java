package zip.hyeon.lgtm.application.auth.required;

import java.util.Optional;
import org.springframework.data.repository.Repository;
import zip.hyeon.lgtm.domain.auth.Auth;
import zip.hyeon.lgtm.domain.auth.Provider;

public interface AuthRepository extends Repository<Auth, Long> {

    Auth save(Auth auth);

    Optional<Auth> findByProviderAndProviderId(Provider provider, String providerId);
}
