package shitta.data.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Event {

    private int id;

    LocalDateTime when;

    private String what;

    User who;
}
