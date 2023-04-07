package time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClockTest {

    @Mock
    Clock clock;

    private static ZonedDateTime zonedDateTime = ZonedDateTime.of(
            2023,
            4,
            1,
            12,
            12,
            12,
            0,
            ZoneId.systemDefault()
    );

    @BeforeEach
    void setup() {
//        MockitoAnnotations.openMocks(this);
        when(clock.getZone()).thenReturn(zonedDateTime.getZone());
        when(clock.instant()).thenReturn(zonedDateTime.toInstant());
    }

    @Test
    public void clock() {
        LocalDateTime now = LocalDateTime.now(clock);
        System.out.println(now);
    }
}
