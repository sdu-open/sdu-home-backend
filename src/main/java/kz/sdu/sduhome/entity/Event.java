package kz.sdu.sduhome.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Event")
@Table(name = "event")
@Getter
@Setter
@ToString
public class Event extends BaseEntity {
    @Column(name = "general_title", nullable = false)
    private String generalTitle;
    @Lob
    @Column(name = "image")
    private Blob image;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "enable")
    @ToString.Exclude
    private Boolean enable;
    @ManyToMany(cascade = CascadeType.ALL, targetEntity = EventContact.class)
    @JoinTable(name = "event_contacts_connection",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    @ToString.Exclude
    private Set<EventContact> contacts;
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "user_creator", nullable = false, updatable = false)
    @ToString.Exclude
    private Integer userCreator;

    @Builder
    public Event(Integer id, Date removed, String generalTitle, Blob image, String title, String description, Boolean enable, Set<EventContact> contacts, Date startDate, Date endDate, Integer userCreator) {
        super(id, removed);
        this.generalTitle = generalTitle;
        this.image = image;
        this.title = title;
        this.description = description;
        this.enable = enable;
        this.contacts = contacts;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userCreator = userCreator;
    }

    public Event() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;
        return getId().equals(event.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
