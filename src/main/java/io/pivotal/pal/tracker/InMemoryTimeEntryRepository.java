package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> entryMap = new HashMap<Long, TimeEntry>(100);

    private long idCounter = 1L;

    public TimeEntry create(TimeEntry timeEntry) {

        long entryId = timeEntry.getId() == 0 ? idCounter++ : timeEntry.getId();

        timeEntry.setId(entryId);

        entryMap.put(entryId, timeEntry);
        return timeEntry;
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {

        timeEntry.setId(id);
        entryMap.replace(id, timeEntry);

        return entryMap.get(id);
    }

    public TimeEntry delete(long id) {
        return entryMap.remove(id);
    }

    public TimeEntry find(long id) {
        return entryMap.get(id);
    }

    public TimeEntry read(long id) {
        return entryMap.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(entryMap.values());
    }
}
