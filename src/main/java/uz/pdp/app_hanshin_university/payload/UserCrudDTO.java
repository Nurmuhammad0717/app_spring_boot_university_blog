package uz.pdp.app_hanshin_university.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.app_hanshin_university.entity.User;
import uz.pdp.app_hanshin_university.enums.RoleEnum;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private RoleEnum role;
    private String identity;
    private String specialty;
}