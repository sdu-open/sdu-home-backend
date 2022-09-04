package kz.sdu.sduhome.service;

import kz.sdu.sduhome.dto.EventDto;

import java.util.List;

public interface EventService extends CRUDOperation<EventDto, Integer> {

    EventDto showTopByEnable();

    List<EventDto> showAllByEnable();
}
