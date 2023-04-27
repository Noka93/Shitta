package shitta.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Package {

    private int id;

    private double weightGram;

    User sender;

    User receiver;

    LocalDateTime timeCreated;

    List<Event> events;

    private boolean payOnDelivery;

}
