package com.rupizza;

public enum Sauce {
    W("WHITE"),
    R("RED");

    private final String flavor;
    private Sauce (String flavor) {
        this.flavor = flavor;
    }

    public String getFlavor() {
        return this.flavor;
    }

}
