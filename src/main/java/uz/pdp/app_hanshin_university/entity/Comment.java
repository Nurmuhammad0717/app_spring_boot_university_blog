package uz.pdp.app_hanshin_university.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.app_hanshin_university.entity.templates.AbsUUIDEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "post")
public class Post extends AbsUUIDEntity {

    @ManyToOne
    private User user;

    private String title;

    @Column(columnDefinition = "text")
    private String comment;

    @OneToOne
    private Attachment attachment;

    private Boolean isPrivate;

}
