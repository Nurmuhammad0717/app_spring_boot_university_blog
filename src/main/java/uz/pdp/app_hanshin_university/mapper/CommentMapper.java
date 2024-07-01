package uz.pdp.app_hanshin_university.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.TargetType;
import uz.pdp.app_hanshin_university.entity.Note;
import uz.pdp.app_hanshin_university.entity.User;
import uz.pdp.app_hanshin_university.payload.NoteCrudDTO;
import uz.pdp.app_hanshin_university.payload.NoteDTO;
import uz.pdp.app_hanshin_university.payload.UserDTO;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NoteMapper {
    NoteDTO toDto(Note note);


    Note toEntity(NoteCrudDTO noteCrudDTO);

    List<NoteDTO> toDto(List<Note> note);

    void updateEntity(@TargetType Note note, NoteCrudDTO crudDto);
}