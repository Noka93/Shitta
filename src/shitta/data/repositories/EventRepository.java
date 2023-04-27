package shitta.data.repositories;

import shitta.data.model.Event;

import java.util.List;

public interface EventRepository {

    Event save(Event event);

    void delete(Event event);

    void delete(int id);

    List<Event> findAll();

    Event findById(int id);

    long count();
}
