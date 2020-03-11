package com.example.landmarkbookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
 //   static Bitmap selectedImage;  // static çok tercih edilen bir yapı değildir.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        //DATA

        final ArrayList<String> landmarkNames = new ArrayList<>();
        landmarkNames.add("Pisa Tower");
        landmarkNames.add("Eiffel Tower");
        landmarkNames.add("Colleseo");
        landmarkNames.add("London Bridge");

        //COUNTRY NAMES
        final ArrayList<String> countryNames = new ArrayList<>();
        countryNames.add("ITALY");
        countryNames.add("FRANCE");
        countryNames.add("ITALY");
        countryNames.add("UNITED KINGDOM");

        //IMAGES
        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.eiffel);
        Bitmap colleseo = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.colleseo);
        Bitmap londonbridge = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.londonbridge);

        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();
        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
        landmarkImages.add(colleseo);
        landmarkImages.add(londonbridge);

        //LIST VIEW

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, landmarkNames);
        listView.setAdapter(arrayAdapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //System.out.println(landmarkNames.get(position));
               //System.out.println(countryNames.get(position));


               Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
               intent.putExtra("name", landmarkNames.get(position));
               intent.putExtra("country", countryNames.get(position));
             //  selectedImage = landmarkImages.get(position);

             /*  Singleton singleton = new Singleton();
               singleton.setChosenImage(landmarkImages.get(position));
            */

             Singleton singleton = Singleton.getInstance();
             singleton.setChosenImage(landmarkImages.get(position));


               startActivity(intent);
           }
       });



    }
}
