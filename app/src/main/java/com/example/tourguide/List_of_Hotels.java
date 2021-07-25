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
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class List_of_Hotels extends AppCompatActivity {
    ListView listView;
    String name[]={"Lemon Tree Hotel","Palm Tree Hotel","Mavens Orange Artemis Hotel","Hyphen Premier Hotel","Hotel Noida International"};
    String place[]={"Aligarh","Aligarh","Gurgaon","Meerut","Noida"};
    int himg[]={R.drawable.lemontree,R.drawable.palmtree,R.drawable.gurgaon,R.drawable.meerut,R.drawable.noida};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_hotels);
        listView = findViewById(R.id.listview5);
        List_of_Hotels.MyAdaptor adaptor = new MyAdaptor(this,name,place,himg);
        listView.setAdapter(adaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.booking.com/region/in/uttar-pradesh.html"));
                startActivity(intent);
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
            this.rcity = place;
            this.rimage = himg;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.listview,parent,false);
            ImageView image = row.findViewById(R.id.img1);
            TextView fort = row.findViewById(R.id.textview1);
            TextView city = row.findViewById(R.id.textview2);
            image.setImageResource(himg[position]);
            fort.setText(name[position]);
            city.setText(place[position]);
            return row;
        }
    }
}