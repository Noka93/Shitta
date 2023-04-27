package shitta.data.repositories;

import shitta.data.model.Event;


import java.util.ArrayList;
import java.util.List;

public class EventRepositoryImpl implements EventRepository{

    private int lastIdCreated;

    private List<Event> events = new ArrayList<>();

    @Override
    public Event save(Event event) {
        boolean isSaved = event.getId()!= 0;
        if (isSaved) update(event);else saveNewEvent(event);

        return event;
    }
    private void update(Event event){
        Event savedEvent = findById(event.getId());
        int indexOfSavedPackage = events.indexOf(savedEvent);
        events.set(indexOfSavedPackage, event);

    }

    private void saveNewEvent(Event event){
        event.setId(generateId());
        events.add(event);
        lastIdCreated++;

    }

    private int generateId() {
        return lastIdCreated+1;
    }

    @Override
    public void delete(Event event) {
        events.remove(event.getId());
        events.add(event);

    }

    @Override
    public void delete(int id) {
        Event foundEvent = findById(id);
        delete(foundEvent);

    }

    @Override
    public List<Event> findAll() {
        return events;
    }

    @Override
    public Event findById(int id) {
        for (Event event: events){
            if (event.getId() == id){
                return event;
            }
        }
        return null;
    }

    @Override
    public long count() {
        return events.size();
    }
}
