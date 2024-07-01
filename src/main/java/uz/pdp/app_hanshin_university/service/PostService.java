package uz.pdp.app_hanshin_university.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import uz.pdp.app_hanshin_university.entity.AttachmentDTO;
import uz.pdp.app_hanshin_university.payload.ApiResult;

import java.util.UUID;


public interface AttachmentService {


    ApiResult<AttachmentDTO> upload(HttpServletRequest request);

    void download(UUID id, HttpServletResponse request);

}
