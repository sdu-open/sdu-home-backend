package kz.sdu.sduhome.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;


@Data
public class UserDto {
    private Integer id;
    private String name;

    private String surname;

    private String patronymic;

    private Date birthday;

    private EduStudentInfoDto eduStudentInfo;

    @Builder
    public UserDto(Integer id, String name, String surname, String patronymic, Date birthday, EduStudentInfoDto eduStudentInfo) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.eduStudentInfo = eduStudentInfo;
    }
}
