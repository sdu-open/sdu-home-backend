package kz.sdu.sduhome.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class EventContactDto {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;

    @Builder
    public EventContactDto(Integer id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
