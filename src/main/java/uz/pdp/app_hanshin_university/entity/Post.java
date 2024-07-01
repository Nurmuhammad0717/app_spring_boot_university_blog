package uz.pdp.app_hanshin_university.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import uz.pdp.app_hanshin_university.entity.templates.AbsUUIDEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "notes")
public class Note extends AbsUUIDEntity {

    @ManyToOne
    private User user;

    @Column(columnDefinition = "text")
    private String text;

}
