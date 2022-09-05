package kz.sdu.sduhome.controller;

import kz.sdu.sduhome.controller.restApiRequests.EventApiRequest;
import kz.sdu.sduhome.dto.EventDto;
import kz.sdu.sduhome.service.impl.EventServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventRestController implements EventApiRequest {
    private final EventServiceImpl eventService;

    public EventRestController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @Override
    public EventDto create(EventDto eventDto) {
        return eventService.create(eventDto);
    }

    @Override
    public List<EventDto> read() {
        return eventService.read();
    }

    @Override
    public EventDto read(String id) {
        Integer idModel = Integer.parseInt(id);
        return eventService.read(idModel);
    }

    @Override
    public void update(EventDto eventDto) {
        eventService.update(eventDto);
    }

    @Override
    public void delete(String id) {
        Integer idModel = Integer.parseInt(id);
        eventService.delete(idModel);
    }

    @Override
    public EventDto showTopByEnable() {
        return eventService.showTopByEnable();
    }
}
