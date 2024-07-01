package uz.pdp.app_hanshin_university.service;


import uz.pdp.app_hanshin_university.payload.ApiResult;
import uz.pdp.app_hanshin_university.payload.PostCrudDto;
import uz.pdp.app_hanshin_university.payload.PostDTO;

import java.util.List;
import java.util.UUID;


public interface PostService {


    ApiResult<PostDTO> create(PostCrudDto crudDto);
    ApiResult<List<PostDTO>> read();
    ApiResult<PostDTO> readOne(UUID id);
    ApiResult<PostDTO> update(UUID id, PostCrudDto crudDto);
    ApiResult<String> delete(UUID id);


}
