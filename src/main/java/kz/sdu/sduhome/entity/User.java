package kz.sdu.sduhome.entity;

import kz.sdu.sduhome.entity.telegram.TelegramUser;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "User")
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birthday")
    private Date birthday;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "student_info")
    private EduStudentInfo eduStudentInfo;
    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private TelegramUser telegramInfo;

    @Builder
    public User(Integer id, String name, String surname, String patronymic, Date birthday, EduStudentInfo eduStudentInfo, TelegramUser telegramInfo) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.eduStudentInfo = eduStudentInfo;
        this.telegramInfo = telegramInfo;
    }

    public void addTelegramInfo(TelegramUser info) {
        info.setUser(this);
        this.telegramInfo = info;
    }

    public void removeTelegramInfo() {
        if (telegramInfo != null) {
            telegramInfo.setUser(null);
            this.telegramInfo = null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
