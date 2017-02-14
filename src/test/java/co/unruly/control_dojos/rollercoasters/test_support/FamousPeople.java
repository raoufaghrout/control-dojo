package co.unruly.control_dojos.rollercoasters.test_support;

import co.unruly.control_dojos.rollercoasters.domain.Person;

import static co.unruly.control_dojos.rollercoasters.domain.MedicalCondition.HAYFEVER;
import static co.unruly.control_dojos.rollercoasters.domain.MedicalCondition.HYDROPHOBIA;
import static co.unruly.control_dojos.rollercoasters.domain.MedicalCondition.NARCOLEPSY;

public class FamousPeople {

    public static Person HAPPY = new Person("Happy", 120);
    public static Person SNEEZY = new Person("Sneezy", 125, HAYFEVER);
    public static Person DOPEY = new Person("Dopey", 95);
    public static Person GRUMPY = new Person("Grumpy", 128);
    public static Person SLEEPY = new Person("Sleepy", 109, NARCOLEPSY);
    public static Person BASHFUL = new Person("Bashful", 99);
    public static Person DOC = new Person("Doc", 127);

    public static Person CHANDLER = new Person("Chandler", 183);
    public static Person JOEY = new Person("Joey", 178);
    public static Person ROSS = new Person("Ross", 185);
    public static Person MONICA = new Person("Monica", 165);
    public static Person RACHEL = new Person("Rachel", 164);
    public static Person PHOEBE = new Person("Phoebe", 173);

    public static Person JD = new Person("JD", 183);
    public static Person TURK = new Person("Turk", 183);

    public static Person VIZZINI = new Person("Vizzini", 157);
    public static Person INIGO_MONTOYA = new Person("Inigo Montoya", 185);
    public static Person FEZZEK = new Person("Fezzek", 224);

    public static Person OZ = new Person("Oz", 140);
    public static Person ELPHABA = new Person("Elphaba", 185, HYDROPHOBIA);
    public static Person NESSA = new Person("Nessa", 172);
}
