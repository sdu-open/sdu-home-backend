package kz.sdu.sduhome.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Blob;
import java.sql.Date;
import java.util.Set;

@Data
public class EventDto implements DTOs {
    private Integer id;
    private String generalTitle;
    private Blob image;

    private String title;
    private String description;
    private Set<EventContactDto> contacts;

    private Date startDate;
    private Date endDate;

    @Builder
    public EventDto(Integer id, String generalTitle, Blob image, String title, String description, Set<EventContactDto> contacts, Date startDate, Date endDate) {
        this.id = id;
        this.generalTitle = generalTitle;
        this.image = image;
        this.title = title;
        this.description = description;
        this.contacts = contacts;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
