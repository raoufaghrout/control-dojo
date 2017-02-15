package co.unruly.control_dojos.rollercoasters.domain;

import java.util.Set;

public class Toddler extends Person {

    public Toddler(String name, int height, MedicalCondition... medicalConditions) {
        super(name, height, medicalConditions);
    }

    @Override
    public String getName() {
        throw new Tantrum("NO NO NO NO NO NO NO");
    }

    @Override
    public int getHeight() {
        throw new Tantrum("NO NO NO NO NO NO NO");
    }

    @Override
    public Set<MedicalCondition> getMedicalConditions() {
        throw new Tantrum("NO NO NO NO NO NO NO");
    }
}
