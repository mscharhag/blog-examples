package com.mscharhag.vectorapi;

import jdk.incubator.vector.*;

public class Main {
    static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_128;

    public static void main(String[] args) {
        example();
        loopExample();
    }

    public static void example() {
        float[] a = new float[] {1f, 2f, 3f, 4f};
        float[] b = new float[] {5f, 8f, 10f, 12f};

        FloatVector first = FloatVector.fromArray(FloatVector.SPECIES_128, a, 0);
        FloatVector second = FloatVector.fromArray(FloatVector.SPECIES_128, b, 0);

        FloatVector result = first
                .add(second)
                .pow(2)
                .neg();

        System.out.println(result);

        float[] resultArray = new float[4];
        result.intoArray(resultArray, 0);

        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(resultArray[i]);
        }
    }

    public static void loopExample() {
        float[] a = randomFloatArray(10_000);
        float[] b = randomFloatArray(10_000);
        float[] c = new float[10_000];

        for (int i = 0; i < a.length; i += SPECIES.length()) {
            VectorMask<Float> mask = SPECIES.indexInRange(i, a.length);
            FloatVector first = FloatVector.fromArray(SPECIES, a, i, mask);
            FloatVector second = FloatVector.fromArray(SPECIES, b, i, mask);
            first.add(second).intoArray(c, i, mask);
        }

        System.out.println("result (last 10 elements):");
        for (int i = a.length - 10; i < a.length; i++) {
            System.out.printf("%d. %f + %f = %f%n", i, a[i], b[i], c[i]);
        }
    }


    public static float[] randomFloatArray(int size) {
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = (float) Math.random() * 10000;
        }
        return array;
    }
}
