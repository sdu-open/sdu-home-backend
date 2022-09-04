package kz.sdu.sduhome.dto;

import kz.sdu.sduhome.entity.telegram.TelegramState;
import lombok.Builder;
import lombok.Data;

@Data
public class TelegramUserDto implements DTOs {
    private Integer id;
    private Integer chatId;
    private String fistName;
    private String lastName;
    private UserDto userDto;
    private TelegramState state;

    @Builder
    public TelegramUserDto(Integer id, Integer chatId, String fistName, String lastName, UserDto userDto, TelegramState state) {
        this.id = id;
        this.chatId = chatId;
        this.fistName = fistName;
        this.lastName = lastName;
        this.userDto = userDto;
        this.state = state;
    }
}
