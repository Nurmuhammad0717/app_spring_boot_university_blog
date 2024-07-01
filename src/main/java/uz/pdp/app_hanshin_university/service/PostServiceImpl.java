package uz.pdp.app_hanshin_university.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.app_hanshin_university.entity.AttachmentDTO;
import uz.pdp.app_hanshin_university.payload.ApiResult;
import uz.pdp.app_hanshin_university.payload.PostCrudDto;
import uz.pdp.app_hanshin_university.payload.PostDTO;

import java.util.UUID;


public interface PostService {


    ApiResult<PostDTO> create(PostCrudDto crudDto);
    ApiResult<PostDTO> read();
    ApiResult<PostDTO> readOne(UUID id);
    ApiResult<PostDTO> update(UUID id, PostCrudDto crudDto);
    ApiResult<PostDTO> delete(UUID id);


}
