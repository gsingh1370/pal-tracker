package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
