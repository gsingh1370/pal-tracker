package io.pivotal.pal.tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }


    @RequestMapping(value = "/time-entries", method = RequestMethod.POST)
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        return new ResponseEntity<>(timeEntryRepository.create(timeEntry), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/time-entries/{id}", method = RequestMethod.GET)
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {

        TimeEntry timeEntry = timeEntryRepository.find(id);
        return new ResponseEntity<>(timeEntry, timeEntry != null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/time-entries", method = RequestMethod.GET)
    public ResponseEntity<List<TimeEntry>> list() {
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }


    @RequestMapping(value = "/time-entries/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TimeEntry> update(@PathVariable long id, @RequestBody TimeEntry timeEntry) {

        TimeEntry timeEntry1 = timeEntryRepository.update(id, timeEntry);

        return new ResponseEntity<>(timeEntry1, timeEntry1!= null ? HttpStatus.OK: HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/time-entries/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {

        TimeEntry timeEntry = timeEntryRepository.delete(id);

        return new ResponseEntity<>(timeEntry, HttpStatus.NO_CONTENT);
    }
}
