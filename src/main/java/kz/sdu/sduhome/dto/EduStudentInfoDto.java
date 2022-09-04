package kz.sdu.sduhome.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class EduStudentInfoDto {
    private Integer id;
    private String studentId;

    @Builder
    public EduStudentInfoDto(Integer id, String studentId) {
        this.id = id;
        this.studentId = studentId;
    }
}
