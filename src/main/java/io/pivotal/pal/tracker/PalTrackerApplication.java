package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PalTrackerApplication {

    @Autowired
    private TimeEntryRepository timeEntryRepository;


    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    public TimeEntryRepository getTimeEntryRepository() {
        return timeEntryRepository;
    }

}
