package com.example.landmarkbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView landmarkNameText;
    TextView countryNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.imageView);
        landmarkNameText = findViewById(R.id.landmarkNameText);
        countryNameText = findViewById(R.id.countryNameText);

        Intent intent = getIntent();
        String landmarkName = intent.getStringExtra("name");
        landmarkNameText.setText(landmarkName);
        String countryName = intent.getStringExtra("country");
        countryNameText.setText(countryName);

        /*YANLIŞ KULLANIM BÖYLE OLMAZ
        Singleton singleton = new Singleton();
        imageView.setImageBitmap(singleton.getChosenImage());
        */

        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());


       // imageView.setImageBitmap(selectedImage);

    }
}
