package com.example.e_shipmentauctionsystem1;

public class Product {
    String prID;
    String prWeight;
    String prLength;
    String prWidth;
    String prHeight;

    public Product() {

    }

    public Product(String prID, String prWeight, String prLength, String prWidth, String prHeight) {
        this.prID = prID;
        this.prWeight = prWeight;
        this.prLength = prLength;
        this.prWidth = prWidth;
        this.prHeight = prHeight;
    }

    public String getPrID() {
        return prID;
    }

    public String getPrWeight() {
        return prWeight;
    }

    public String getPrLength() {
        return prLength;
    }

    public String getPrWidth() {
        return prWidth;
    }

    public String getPrHeight() {
        return prHeight;
    }
}
