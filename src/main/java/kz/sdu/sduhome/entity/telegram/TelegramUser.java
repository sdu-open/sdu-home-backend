package kz.sdu.sduhome.entity.telegram;

import kz.sdu.sduhome.entity.BaseEntity;
import kz.sdu.sduhome.entity.User;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "TelegramUser")
@Table(name = "telegram_user")
@Getter
@Setter
public class TelegramUser extends BaseEntity {
    @NaturalId
    @Column(name = "chat_id", nullable = false, unique = true, updatable = false)
    private Integer chatId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private User user;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "t_state_id", referencedColumnName = "id")
    private TelegramState state;

    @Builder
    public TelegramUser(Integer id, Date removed, Integer chatId, String firstName, String lastName, User user, TelegramState state) {
        super(id, removed);
        this.chatId = chatId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
        this.state = state;
    }

    public TelegramUser() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelegramUser that)) return false;
        return getChatId().equals(that.getChatId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChatId());
    }
}
