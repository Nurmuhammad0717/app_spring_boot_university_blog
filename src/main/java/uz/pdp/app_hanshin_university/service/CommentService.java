package uz.pdp.app_hanshin_university.service;


import uz.pdp.app_hanshin_university.payload.ApiResult;
import uz.pdp.app_hanshin_university.payload.NoteCrudDTO;
import uz.pdp.app_hanshin_university.payload.NoteDTO;

import java.util.List;
import java.util.UUID;


public interface NoteService {


    ApiResult<NoteDTO> create(NoteCrudDTO crudDto);
    ApiResult<List<NoteDTO>> read();
    ApiResult<NoteDTO> readOne(UUID id);
    ApiResult<NoteDTO> update(UUID id, NoteCrudDTO crudDto);
    ApiResult<String> delete(UUID id);


}
