package uz.pdp.app_hanshin_university.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link UserFollower}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowerCrudDTO implements Serializable {
    private UUID user;
    private UUID follower;
}