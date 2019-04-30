package run.halo.app.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Tag entity
 *
 * @author ryanwang
 * @date : 2019-03-12
 */
@Data
@Entity
@Table(name = "tags", indexes = @Index(columnList = "slug_name"))
@ToString
@EqualsAndHashCode(callSuper = true)
public class Tag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Tag name.
     */
    @Column(name = "name", columnDefinition = "varchar(255) not null")
    private String name;

    /**
     * Tag slug name.
     */
    @Column(name = "slug_name", columnDefinition = "varchar(255) not null")
    private String slugName;

    @Override
    protected void prePersist() {
        super.prePersist();
        id = null;
    }
}
