package kz.sdu.sduhome.service;

import kz.sdu.sduhome.dto.EventDto;

public interface EventService extends CrudOperation<EventDto, Integer> {

    EventDto showTopByEnable();
}
