package com.example.imageMarker.mark;

public class MarkConfig {
    private String text;
    private int posX;
    private int posY;
    private String color;
    private int fontSize;

    // Construtor
    public MarkConfig(String text, int posX, int posY, String cor, int fontSize) {
        this.text = text;
        this.posX = posX;
        this.posY = posY;
        this.color = cor;
        this.fontSize = fontSize;
    }

    // Getters e Setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
