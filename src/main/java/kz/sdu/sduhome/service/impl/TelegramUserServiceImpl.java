package kz.sdu.sduhome.service.impl;

import kz.sdu.sduhome.dto.EduStudentInfoDto;
import kz.sdu.sduhome.dto.TelegramUserDto;
import kz.sdu.sduhome.dto.UserDto;
import kz.sdu.sduhome.entity.EduStudentInfo;
import kz.sdu.sduhome.entity.User;
import kz.sdu.sduhome.entity.telegram.TelegramUser;
import kz.sdu.sduhome.exception.ServerLogicException;
import kz.sdu.sduhome.repository.TelegramUserRepository;
import kz.sdu.sduhome.service.TelegramUserService;

import kz.sdu.sduhome.service.temp.BaseSingleEntityService;
import org.springframework.stereotype.Service;

@Service
public class TelegramUserServiceImpl extends BaseSingleEntityService<TelegramUser, TelegramUserDto> implements TelegramUserService {
    private final TelegramUserRepository repository;

    public TelegramUserServiceImpl(TelegramUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public TelegramUser save(TelegramUser telegramUser) {
        if (telegramUser.getId() != null)
            throw new ServerLogicException("Param id should be null");
        if (repository.findTelegramUserByChatId(telegramUser.getChatId()) != null)
            throw new ServerLogicException("Telegram with this chat id is exists");

        return repository.save(telegramUser);
    }

    @Override
    public TelegramUser update(TelegramUser telegramUser) {
        if (telegramUser == null || telegramUser.getId() == null || telegramUser.getChatId() == null)
            throw new ServerLogicException("Params con not be null");
        return save(telegramUser);
    }

    @Override
    protected TelegramUser convertToEntity(TelegramUserDto telegramUserDto) throws ServerLogicException {
        return TelegramUser.builder()
                .id(telegramUserDto.getId())
                .user(User.builder()
                        .id(telegramUserDto.getUserDto().getId())
                        .name(telegramUserDto.getUserDto().getName())
                        .surname(telegramUserDto.getUserDto().getSurname())
                        .birthday(telegramUserDto.getUserDto().getBirthday())
                        .eduStudentInfo(EduStudentInfo.builder()
                                .id(telegramUserDto.getUserDto().getEduStudentInfo().getId())
                                .studentId(telegramUserDto.getUserDto().getEduStudentInfo().getStudentId())
                                .build())
                        .build())
                .chatId(telegramUserDto.getChatId())
                .firstName(telegramUserDto.getFistName())
                .lastName(telegramUserDto.getLastName())
                .state(telegramUserDto.getState())
                .build();
    }

    @Override
    protected TelegramUserDto convertToDto(TelegramUser telegramUser) {
        return TelegramUserDto.builder()
                .id(telegramUser.getId())
                .userDto(UserDto.builder()
                        .id(telegramUser.getUser().getId())
                        .name(telegramUser.getUser().getName())
                        .surname(telegramUser.getUser().getSurname())
                        .patronymic(telegramUser.getUser().getPatronymic())
                        .birthday(telegramUser.getUser().getBirthday())
                        .eduStudentInfo(EduStudentInfoDto.builder()
                                .id(telegramUser.getUser().getEduStudentInfo().getId())
                                .studentId(telegramUser.getUser().getEduStudentInfo().getStudentId())
                                .build())
                        .build())
                .fistName(telegramUser.getFirstName())
                .lastName(telegramUser.getLastName())
                .chatId(telegramUser.getChatId())
                .state(telegramUser.getState())
                .build();
    }
}
