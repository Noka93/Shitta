package data.repositories;

import shitta.data.model.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import shitta.data.repositories.EventRepository;
import shitta.data.repositories.EventRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

class EventRepositoryImplTest {

    private EventRepository eventRepository;

    @BeforeEach
    void setUp() {
        eventRepository = new EventRepositoryImpl();

    }


    @Test
    @DisplayName("Create new Package Test")
    public void saveOneEvent_countIsOneTes(){

        Event event = new Event();

        assertEquals(0, eventRepository.count());
        eventRepository.save(event);

        assertEquals(1, eventRepository.count());

    }

    @Test
    @DisplayName("Generate ID test")
    public void saveOneEvent_IdIsOneTest(){
        Event event = new Event();

        assertEquals(0, event.getId());
        Event savedEvent = eventRepository.save(event);
        assertEquals(1, savedEvent.getId());

    }

    @Test
    @DisplayName("Find by id test")
    public void saveOneEvent_findEventById_returnSavedEventTest(){
        Event event = new Event();
        event.setWhat("Guitar");
        eventRepository.save(event);
        Event foundEvent = eventRepository.findById(1);
        assertEquals(1, foundEvent.getId());
        assertEquals(event, foundEvent);

    }
}