package uz.pdp.app_hanshin_university.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.pdp.app_hanshin_university.entity.templates.AbsUUIDEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class UserFollower extends AbsUUIDEntity {

    @ManyToOne
    private User user;

}
