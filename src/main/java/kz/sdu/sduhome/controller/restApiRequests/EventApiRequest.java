package kz.sdu.sduhome.controller.restApiRequests;

import kz.sdu.sduhome.dto.EventDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/events")
public interface EventApiRequest extends RestApiRequests<EventDto> {

    @GetMapping("/top")
    EventDto showTopByEnable();
}
