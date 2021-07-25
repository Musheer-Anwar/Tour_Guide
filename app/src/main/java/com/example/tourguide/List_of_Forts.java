package com.example.tourguide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class List_of_Forts extends AppCompatActivity {
    ListView listView;
    String name[] = {"Mehrangarh Fort","Gwalior Fort","Red Fort","Amber Fort","Jhansi Fort","Chittorgarh Fort","Golconda Fort","Jaisalmer Fort","Kangra Fort","Jaigarh Fort"};
    String city[] = {"Jodhpur","Gwalior","Delhi","Jaipur","Jhansi","Rajasthan","Telangana","Jaisalmer","Kangra","Jaipur"};
    int images[] = {R.drawable.mmehrangarh,R.drawable.ggwalior,R.drawable.rredfort,R.drawable.ambeer,R.drawable.jjhansi,R.drawable.chitorgarh,R.drawable.ggolconda,R.drawable.jjaisalmer,R.drawable.kkangra,R.drawable.jjaigarh};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_forts);
        listView = findViewById(R.id.listview1);
        MyAdaptor adaptor = new MyAdaptor(this,name,city,images);
        listView.setAdapter(adaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.tourmyindia.com/states/rajasthan/mehrangarh-fort-jodhpur.html"));
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://theculturetrip.com/asia/india/articles/a-brief-history-of-indias-gwalior-fort/"));
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.britannica.com/topic/Red-Fort"));
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.holidify.com/places/jaipur/amer-fort-sightseeing-2124.html"));
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://housing.com/news/jhansi-fort/"));
                    startActivity(intent);
                }
                if(position==5){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.holidify.com/places/chittorgarh/chittorgarh-fort-sightseeing-1577.html"));
                    startActivity(intent);
                }
                if(position==6){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.holidify.com/places/hyderabad/golconda-fort-sightseeing-2043.html"));
                    startActivity(intent);
                }
                if(position==7){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.tourmyindia.com/states/rajasthan/jaisalmer-fort.html"));
                    startActivity(intent);
                }
                if(position==8){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://hpkangra.nic.in/history/"));
                    startActivity(intent);
                }
                if(position==9){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://jaipurtourism.co.in/jaigarh-fort-jaipur"));
                    startActivity(intent);
                }
            }
        });

    }
      class MyAdaptor extends ArrayAdapter<String> {
        Context context;
        String rname[];
        String rcity[];
        int rimage[];

        MyAdaptor(Context c,String srt1[],String str2[],int imgs[]){
            super(c,R.layout.listview,R.id.textview1, name);
            this.context = c;
            this.rname = name;
            this.rcity = city;
            this.rimage = images;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.listview,parent,false);
            ImageView image = row.findViewById(R.id.img1);
            TextView fort = row.findViewById(R.id.textview1);
            TextView cities = row.findViewById(R.id.textview2);
            image.setImageResource(images[position]);
            fort.setText(name[position]);
            cities.setText(city[position]);


            return row;
        }
    }
}