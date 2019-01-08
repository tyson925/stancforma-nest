package com.stancforma.dxfReader.entities;

public class DL_LinetypeData {
    /** Linetype name */
    String name;
    /** Linetype description */
    String description;
    /** Linetype flags */
    int flags;
    /** Number of dashes */
    int numberOfDashes;
    /** Pattern length */
    double patternLength;
    /** Pattern */
    double pattern;

    public DL_LinetypeData(String name, String description, int flags, int numberOfDashes, double patternLength, double pattern) {
        this.name = name;
        this.description = description;
        this.flags = flags;
        this.numberOfDashes = numberOfDashes;
        this.patternLength = patternLength;
        this.pattern = pattern;
    }

    public DL_LinetypeData(String name, String description, int flags, int numberOfDashes, double patternLength) {
        this.name = name;
        this.description = description;
        this.flags = flags;
        this.numberOfDashes = numberOfDashes;
        this.patternLength = patternLength;
    }
}
