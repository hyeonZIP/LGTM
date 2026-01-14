package zip.hyeon.lgtm.application.auth.provided;

import jakarta.validation.Valid;
import zip.hyeon.lgtm.application.auth.dto.AuthRegisterRequest;

/**
 * OAuth2 인증 정보 저장 기능을 제공한다
 */
public interface AuthRegister {

    void register(@Valid AuthRegisterRequest request);
}
