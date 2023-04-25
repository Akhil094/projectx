import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class FitnessClubnewTest {

    private Map<String, List<LocalDate>> timetable;
    private FitnessClubnew fitnessClub;

    @Before
    public void setUp() {
        timetable = new HashMap<>();
        timetable.put("Zumba", Arrays.asList(
                LocalDate.of(2023, 5, 1),
                LocalDate.of(2023, 5, 8),
                LocalDate.of(2023, 5, 15),
                //...
               
                LocalDate.of(2023, 6, 25)));
        timetable.put("Yoga", Arrays.asList(
                LocalDate.of(2023, 5, 8),
                LocalDate.of(2023, 5, 15),
                LocalDate.of(2023, 5, 22),
                //...
                LocalDate.of(2023, 6, 26),
                LocalDate.of(2023, 7, 2)));
        // ...
        fitnessClub = new FitnessClubnew();
    }

    @Test
    public void testViewTimetable() {
        // Redirect standard output to a stream for testing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        // Call the method to be tested
        fitnessClub.viewTimetable();
        
        // Check if the expected output is generated
        String expectedOutput = "Timetable for the next 8 weekends:\n" +
            "Zumba:\n" +
            "- 01/05/2023\n" +
            "- 08/05/2023\n" +
            "- 15/05/2023\n" +
            // ...
            "- 25/06/2023\n\n" +
            "Yoga:\n" +
            "- 08/05/2023\n" +
            "- 15/05/2023\n" +
            "- 22/05/2023\n" +
            // ...
            "- 02/07/2023\n\n" +
            // ...
            " Yoga lesson price is :- 10 dollars \n Zumba lesson price is 20 dollars \n Aquasice lesson price is 50 dollars \n Bodysculpt lesson price is 15 dollars \n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testViewBooking() {
        // Set up some test data
        String memberName = "John Doe";
        LocalDate bookingDate = LocalDate.of(2023, 5, 8);
        String lessonName = "Yoga";
        int numOfParticipants = 1;
        
        // Make a booking
       fitnessClub.makeBooking(memberName, bookingDate, lessonName, numOfParticipants);
           // Redirect standard output to a stream for testing
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    
    // Call the method to be tested
    fitnessClub.viewBooking(memberName);
    
    // Check if the expected output is generated
    String expectedOutput = "Bookings for John Doe:\n" +
        "Lesson: Yoga\n" +
        "Date: 08/05/2023\n" +
        "Number of participants: 1\n\n";
    assertEquals(expectedOutput, outContent.toString());
}

@Test
public void testMakeBooking() {
    // Set up some test data
    String memberName = "Jane Smith";
    LocalDate bookingDate = LocalDate.of(2023, 5, 8);
    String lessonName = "Zumba";
    int numOfParticipants = 2;
    
    // Redirect standard output to a stream for testing
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    
    // Call the method to be tested
    fitnessClub.makeBooking(memberName, bookingDate, lessonName, numOfParticipants);
    
    // Check if the booking is made and the expected output is generated
    assertTrue(fitnessClub.hasBooking(memberName, bookingDate, lessonName, numOfParticipants));
    String expectedOutput = "Booking made:\n" +
        "Member name: Jane Smith\n" +
        "Lesson: Zumba\n" +
        "Date: 08/05/2023\n" +
        "Number of participants: 2\n";
    assertEquals(expectedOutput, outContent.toString());
}
}

