package com.example.pizza;

import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.io.Serializable;

public class MiniMenu implements Serializable   {
    private String textView;


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



    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
