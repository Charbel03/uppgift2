import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class KunderTest {

    @Test
    void checkDateTest() {

        Kunder x = new Kunder();
        LocalDate localDate = LocalDate.now();
        x.localDateKund = LocalDate.of(localDate.getYear(),02,02);
        x.checkDate(x.localDateKund);

        assertEquals(true,x.isValidKund);
    }

    @Test
    void checkPtTxt(){
        Kunder x = new Kunder();
        LocalDate localDate = LocalDate.now();

        x.localDateKund = LocalDate.of(localDate.getYear(),02,02);
        x.checkDate(x.localDateKund);
        assertEquals("Namn: " + x.name + "\tPersonNummer: " + x.personNumber + "\tDatum: " + localDate,
                x.txt);

    }


}