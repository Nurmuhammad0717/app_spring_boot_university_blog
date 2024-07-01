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
public class UserFollowerDTO implements Serializable {
    private UUID id;
    private UUID user;
    private UUID follower;
}