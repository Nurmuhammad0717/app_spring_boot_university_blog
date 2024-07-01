package uz.pdp.app_hanshin_university.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.app_hanshin_university.entity.User;
import uz.pdp.app_hanshin_university.enums.RoleEnum;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInDTO implements Serializable {
    @NotNull(message = "first_name_must_not_be_null")
    @NotBlank
    private String firstName;
    private String lastName;
    @NotNull(message = "email_must_not_be_null")
    @Email(message = "email_should_be_valid")
    @NotBlank
    private String email;
    @NotNull(message = "password_must_not_be_null")
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String password;
    private RoleEnum role;
    private String identity;
    private String specialty;
}