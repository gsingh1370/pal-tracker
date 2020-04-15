package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntry);

    public TimeEntry update(long id, TimeEntry timeEntry);

    public TimeEntry delete(long id);

    public TimeEntry find(long id);

    public TimeEntry read(long id);

    public List<TimeEntry> list();
}
