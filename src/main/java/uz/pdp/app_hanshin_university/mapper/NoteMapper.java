package uz.pdp.app_hanshin_university.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import uz.pdp.app_hanshin_university.entity.User;
import uz.pdp.app_hanshin_university.payload.UserDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDTO toDto(User user);
}