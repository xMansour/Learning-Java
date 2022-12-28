package org.example;

public class BreakfastOrder {
    private final String fol;
    private final String ta3mia;
    private final String bed;
    private final String mkhalel;

    public static class Builder {
        private String fol;
        private String ta3mia;
        private String bed;
        private String mkhalel;

        public Builder() {

        }


        public Builder fol(String fol) {
            this.fol = fol;
            return this;
        }

        public Builder ta3mia(String ta3mia) {
            this.ta3mia = ta3mia;
            return this;
        }

        public Builder bed(String bed) {
            this.bed = bed;
            return this;
        }

        public Builder mkhalel(String mkhalel) {
            this.mkhalel = mkhalel;
            return this;
        }

        public BreakfastOrder build() {
            return new BreakfastOrder(this);
        }
    }


    //Constructor only takes a Builder object
    public BreakfastOrder(Builder builder) {
        this.fol = builder.fol;
        this.ta3mia = builder.ta3mia;
        this.bed = builder.bed;
        this.mkhalel = builder.mkhalel;
    }

    //No setters to prevent mutability.

    public String getFol() {
        return fol;
    }

    public String getTa3mia() {
        return ta3mia;
    }

    public String getBed() {
        return bed;
    }

    public String getMkhalel() {
        return mkhalel;
    }

    @Override
    public String toString() {
        return "BreakfastOrder{" +
                "fol='" + fol + '\'' +
                ", ta3mia='" + ta3mia + '\'' +
                ", bed='" + bed + '\'' +
                ", mkhalel='" + mkhalel + '\'' +
                '}';
    }
}
