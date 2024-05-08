package ar.com.problems.calendars;

import ar.com.problems.string.BaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

public class GetEspecificDayTest extends BaseTest {

    @Test
    public void findDay() {

        testing("SATURDAY", GetEspecificDay.findDay(2, 13, 2010));

    }


}