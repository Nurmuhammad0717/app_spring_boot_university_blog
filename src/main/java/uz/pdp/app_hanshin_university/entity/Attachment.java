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
@Entity(name = "post")
public class Post extends AbsUUIDEntity {

    @ManyToOne
    private User user;

    private String submittedName;

    private String contentType;

    private Long size;

    @Column(columnDefinition = "varchar(500)")
    private String path;

    private Boolean isPrivate;

}
