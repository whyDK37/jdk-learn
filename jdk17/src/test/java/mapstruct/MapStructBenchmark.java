package mapstruct;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapStructBenchmark {
    @Test
    public void shouldMapCarToDto() {
        //given
        Car car = new Car("Morris", 5, CarType.SEDAN);

        //when
        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);

        //then
        assertNotNull(carDto);
        assertEquals(carDto.getMake(), "Morris");
        assertEquals(carDto.getSeatCount(), 5);
        assertEquals(carDto.getType(), "SEDAN");
    }
}
