package zip.hyeon.lgtm.application.auth.required;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import zip.hyeon.lgtm.domain.auth.Auth;
import zip.hyeon.lgtm.domain.auth.Provider;

public interface AuthRepository extends Repository<Auth, Long> {

    void save(Auth auth);

    @Query("SELECT a.member.id FROM Auth a WHERE a.provider = :provider AND a.providerId = :providerId")
    Optional<Long> findMemberIdByProviderAndProviderId(
        @Param("provider") Provider provider,
        @Param("providerId") String providerId
    );
}
