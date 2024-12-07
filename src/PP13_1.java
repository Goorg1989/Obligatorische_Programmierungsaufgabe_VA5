import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class CalendarEvent {
    private String title;
    private LocalDate date;
    private LocalTime startTime;
    private Duration duration;

    public CalendarEvent(String title, LocalDate date, LocalTime startTime, Duration duration) {
        this.title = title;
        this.date = date;
        this.startTime = startTime;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Ereignis: " + title +
                ", Datum: " + date +
                ", Startzeit: " + startTime +
                ", Dauer: " + duration.toHours() + " Stunden " +
                duration.toMinutesPart() + " Minuten";
    }
}

public class CalendarApp {
    public static void main(String[] args) {
        List<CalendarEvent> events = new ArrayList<>();

        events.add(new CalendarEvent("Meeting mit dem Team", LocalDate.of(2023, 10, 25),
                LocalTime.of(10, 30), Duration.ofHours(2)));
        events.add(new CalendarEvent("Präsentation", LocalDate.of(2023, 10, 26),
                LocalTime.of(14, 0), Duration.ofHours(1).plusMinutes(30)));
        events.add(new CalendarEvent("Kaffeepause", LocalDate.of(2023, 10, 27),
                LocalTime.of(15, 0), Duration.ofMinutes(30)));

        System.out.println("Kalenderereignisse:");
        for (CalendarEvent event : events) {
            System.out.println(event);
        }
    }
}
