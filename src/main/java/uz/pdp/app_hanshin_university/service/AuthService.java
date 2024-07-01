package uz.pdp.app_hanshin_university.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import uz.pdp.app_hanshin_university.payload.SignInDTO;
import uz.pdp.app_hanshin_university.payload.TokenDTO;


import java.util.UUID;

public interface AuthService extends UserDetailsService {
    ApiResult<TokenDTO> signIn(SignInDTO signInDTO);

    ApiResult<String> signUp(SignUpDTO signUpDTO);

    ApiResult<String> emailVerification(UUID codeId, String code);
}
