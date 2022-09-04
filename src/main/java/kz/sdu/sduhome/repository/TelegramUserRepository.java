package kz.sdu.sduhome.repository;

import kz.sdu.sduhome.entity.telegram.TelegramUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramUserRepository extends BaseJpaRepository<TelegramUser, Integer> {

    TelegramUser findTelegramUserByChatId(Integer chatId);
}