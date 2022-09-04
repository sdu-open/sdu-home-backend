package kz.sdu.sduhome.entity.telegram;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "telegram_states")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class TelegramState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "event_status")
    @Enumerated(EnumType.STRING)
    private EventBotState eventState;

    @Builder
    public TelegramState(Integer id, EventBotState eventState) {
        this.id = id;
        this.eventState = eventState;
    }
}

enum EventBotState {
    NONE, ACCOUNT, SHOW_EVENT
}
