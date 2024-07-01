package uz.pdp.app_hanshin_university.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import uz.pdp.app_hanshin_university.entity.AttachmentDTO;
import uz.pdp.app_hanshin_university.payload.ApiResult;

import java.util.UUID;

@Component
public interface AttachmentService {


    ApiResult<AttachmentDTO> upload(HttpServletRequest request);

    void download(UUID id, HttpServletRequest request);

}
