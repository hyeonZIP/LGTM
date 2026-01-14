package zip.hyeon.lgtm.application.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import zip.hyeon.lgtm.application.auth.dto.AuthRegisterRequest;
import zip.hyeon.lgtm.application.auth.provided.AuthRegister;
import zip.hyeon.lgtm.application.auth.required.AuthRepository;
import zip.hyeon.lgtm.domain.auth.Auth;

@Service
@Validated
@RequiredArgsConstructor
public class AuthModifyService implements AuthRegister {

    private final AuthRepository authRepository;

    @Override
    public void register(AuthRegisterRequest request) {
        authRepository.save(Auth.register(request));
    }
}
