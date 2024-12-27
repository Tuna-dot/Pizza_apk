package com.example.pizza;

import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.io.Serializable;

public class MiniMenu implements Serializable   {
    private String textView;
    private CardView cardView;

    private int imageView;

    public MiniMenu(String textView, int imageView) {
        this.imageView = imageView;
        this.textView = textView;
    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }

    public CardView getCardView() {
        return cardView;
    }

    public void setCardView(CardView cardView) {
        this.cardView = cardView;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
