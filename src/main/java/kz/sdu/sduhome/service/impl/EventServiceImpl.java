package kz.sdu.sduhome.service.impl;

import kz.sdu.sduhome.dto.EventContactDto;
import kz.sdu.sduhome.dto.EventDto;
import kz.sdu.sduhome.entity.Event;
import kz.sdu.sduhome.entity.EventContact;
import kz.sdu.sduhome.exception.ServerLogicException;
import kz.sdu.sduhome.repository.EventContactRepository;
import kz.sdu.sduhome.repository.EventRepository;
import kz.sdu.sduhome.service.EventService;
import kz.sdu.sduhome.service.temp.BaseSingleEntityService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl extends BaseSingleEntityService<Event, EventDto> implements EventService {
    private final EventRepository repository;
    private final EventContactRepository contactRepository;

    public EventServiceImpl(EventRepository repository, EventContactRepository contactRepository) {
        this.repository = repository;
        this.contactRepository = contactRepository;
    }


    @Override
    public EventDto create(EventDto eventDto) {
        var model = repository.save(convertToEntity(eventDto));
        return convertToDto(model);
    }

    @Override
    public List<EventDto> read() {
        return repository.findEventsByEnable(true).stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public EventDto read(Integer id) {
        Event event = repository.findById(id).orElseThrow(() -> new ServerLogicException("Can't find event by id"));
        return convertToDto(event);
    }

    @Override
    public void update(EventDto eventDto) {
        Event dbEvent = repository.findById(eventDto.getId()).orElseThrow(() -> new ServerLogicException("Can't find event by id"));
        if (dbEvent.getRemoved() != null)
            throw new ServerLogicException("Can't update event");
        repository.save(convertToEntity(eventDto));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public EventDto showTopByEnable() {
        Event event = repository.findTopByEnable(true);
        return convertToDto(event);
    }

    @Override
    public List<EventDto> showAllByEnable() {
        List<Event> events = repository.findEventsByEnable(true);
        return events.stream().map(this::convertToDto).toList();
    }

    @Override
    protected Event convertToEntity(EventDto eventDto) throws ServerLogicException {
        final Event dbEvent = repository.findById(eventDto.getId()).orElseThrow(() -> new ServerLogicException("Can't find event by id"));
        final Set<EventContact> contacts = new HashSet<>(contactRepository.findAllById(eventDto.getContacts().stream()
                .map(EventContactDto::getId)
                .toList()));
        return Event.builder()
                .id(eventDto.getId())
                .generalTitle(eventDto.getGeneralTitle())
                .title(eventDto.getTitle())
                .description(eventDto.getDescription())
                .enable(dbEvent.getEnable())
                .contacts(contacts)
                .startDate(eventDto.getStartDate())
                .endDate(eventDto.getEndDate())
                .userCreator(dbEvent.getUserCreator())
                .image(eventDto.getImage())
                .build();
    }

    protected EventDto convertToDto(Event event) {
        var contacts = event.getContacts().stream()
                .map(contact -> EventContactDto.builder()
                        .id(contact.getId())
                        .name(contact.getName())
                        .phoneNumber(contact.getPhoneNumber())
                        .email(contact.getEmail())
                        .build())
                .collect(Collectors.toSet());

        return EventDto.builder()
                .id(event.getId())
                .generalTitle(event.getGeneralTitle())
                .title(event.getTitle())
                .description(event.getDescription())
                .image(event.getImage())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .contacts(contacts)
                .build();
    }
}
