package uz.pdp.app_hanshin_university.service;

import uz.pdp.app_hanshin_university.config.AppProperties;
import uz.pdp.app_hanshin_university.payload.ApiResult;

public interface MailService {

    ApiResult<String> sendVerificationCode();

}
