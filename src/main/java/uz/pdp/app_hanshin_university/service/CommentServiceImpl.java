package uz.pdp.app_hanshin_university.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.app_hanshin_university.entity.Note;
import uz.pdp.app_hanshin_university.entity.User;
import uz.pdp.app_hanshin_university.exception.RestException;
import uz.pdp.app_hanshin_university.mapper.NoteMapper;
import uz.pdp.app_hanshin_university.payload.ApiResult;
import uz.pdp.app_hanshin_university.payload.NoteCrudDTO;
import uz.pdp.app_hanshin_university.payload.NoteDTO;
import uz.pdp.app_hanshin_university.repository.NoteRepository;
import uz.pdp.app_hanshin_university.repository.UserRepository;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Transactional
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final NoteMapper noteMapper;

    @Override
    public ApiResult<NoteDTO> create(NoteCrudDTO crudDto) {

        User user = userRepository.findById(crudDto.getUserId())
                .orElseThrow(()-> RestException.notFound("User "));

        Note note = noteMapper.toEntity(crudDto);

        note.setUser(user);

        Note saved = noteRepository.save(note);

        return ApiResult.success(noteMapper.toDto(saved));
    }

    @Override
    public ApiResult<List<NoteDTO>> read() {

        List<Note> notes = noteRepository.findAll();

        return ApiResult.success(noteMapper.toDto(notes));
    }

    @Override
    public ApiResult<NoteDTO> readOne(UUID id) {

        Note note = noteRepository.findById(id)
                .orElseThrow(()->new RestException("This note is not available"));

        NoteDTO noteDTO = noteMapper.toDto(note);

        return ApiResult.success(noteDTO);
    }

    @Override
    public ApiResult<NoteDTO> update(UUID id, NoteCrudDTO crudDto) {

        Note note = noteRepository.findById(id)
                .orElseThrow(()->new RestException("This note is not available"));

     noteMapper.updateEntity(note, crudDto);

        Note save = noteRepository.save(note);

        return ApiResult.success(noteMapper.toDto(save));
    }

    @Override
    public ApiResult<String> delete(UUID id) {

        Note note = noteRepository.findById(id)
                .orElseThrow(()->new RestException("This note is not available"));

        noteRepository.delete(note);

        return ApiResult.success("Note is deleted");
    }



}
