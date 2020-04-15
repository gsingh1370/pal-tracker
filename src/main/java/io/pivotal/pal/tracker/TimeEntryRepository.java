package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntry);

    public TimeEntry update(long id, TimeEntry timeEntry);

    public void delete(long id);

    public TimeEntry find(long id);

    public List<TimeEntry> list();
}
