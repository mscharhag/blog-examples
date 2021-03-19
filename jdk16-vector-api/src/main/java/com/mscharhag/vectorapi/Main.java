package com.mscharhag.vectorapi;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

public class Main {
    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_128;

    public static void main(String[] args) {
        float[] a = new float[] {1f, 2f, 3f, 4f};
        float[] b = new float[] {5f, 8f, 10f, 12f};

        FloatVector first = FloatVector.fromArray(SPECIES, a, 0);
        FloatVector second = FloatVector.fromArray(SPECIES, b, 0);

        FloatVector result = first
                .add(second)
                .pow(2)
                .neg();

        System.out.println(result);
    }
}
