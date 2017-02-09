package co.unruly.control_dojos.boyfriends;

import static co.unruly.control_dojos.boyfriends.EducationLevel.*;
import static co.unruly.control_dojos.boyfriends.Job.DOCTOR;
import static co.unruly.control_dojos.boyfriends.Job.ESTATE_AGENT;
import static co.unruly.control_dojos.boyfriends.Job.LAWYER;
import static co.unruly.control_dojos.boyfriends.Vehicle.*;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public class Boyfriends {

    public static final Boyfriend DEAN = new Boyfriend("Dean", 24, GCSE, empty(), of(HARLEY_DAVIDSON));

    public static final Boyfriend GARY = new Boyfriend("Gary", 28, A_LEVELS, of(ESTATE_AGENT), of(SOUPED_UP_FORD_ESCORT));

    public static final Boyfriend CHRISTOPHER = new Boyfriend("Christopher", 42, GRADUATE, of(LAWYER), of(BMW_3_SERIES));

    public static final Boyfriend MICHAEL = new Boyfriend("Michael", 30, POSTGRADUATE, of(DOCTOR), of(FORD_MONDEO));
}
