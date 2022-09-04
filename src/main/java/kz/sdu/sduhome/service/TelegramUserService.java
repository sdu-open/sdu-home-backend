package kz.sdu.sduhome.service;

import kz.sdu.sduhome.entity.telegram.TelegramUser;

public interface TelegramUserService {

    TelegramUser save(TelegramUser telegramUser);

    TelegramUser update(TelegramUser telegramUser);
}
