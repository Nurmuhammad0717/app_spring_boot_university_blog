package uz.pdp.app_hanshin_university.service;

import org.springframework.stereotype.Component;
import uz.pdp.app_hanshin_university.config.AppProperties;
import uz.pdp.app_hanshin_university.payload.ApiResult;
import uz.pdp.app_hanshin_university.payload.SignUpDTO;
import uz.pdp.app_hanshin_university.payload.UserDTO;

@Component
public interface MailService {


    ApiResult<String> sendVerificationCode(UserDTO userDTO);

}
