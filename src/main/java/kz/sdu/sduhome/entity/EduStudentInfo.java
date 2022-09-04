package kz.sdu.sduhome.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_info")
@Getter
@Setter
@NoArgsConstructor
public class EduStudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NaturalId
    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Builder
    public EduStudentInfo(Integer id, String studentId) {
        this.id = id;
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EduStudentInfo that)) return false;
        return getStudentId().equals(that.getStudentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId());
    }
}
