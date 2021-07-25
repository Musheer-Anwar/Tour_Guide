package com.example.tourguide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class List_of_cities extends AppCompatActivity {
    ListView listView;
    String city[] = {"Jaipur","Varanasi","Udaipur","Bangalore","Delhi","Chennai","Mysore","Agra","Kolkata","Mumbai"};
    String state[]={"Rajasthan","Uttar Pradesh","Rajasthan","Karnataka","Union Territory","Tamil Nadu","Karnataka","Uttar Pradesh","West Bengal","Maharashtra"};
    int imgs[] = {R.drawable.jaipur,R.drawable.varanasi,R.drawable.udaipur,R.drawable.bangalore,R.drawable.delhi,R.drawable.chennai,R.drawable.mysore,R.drawable.agra,R.drawable.kolkata,R.drawable.mumbai};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_cities);
        listView = findViewById(R.id.listview4);
        List_of_cities.MyAdaptor adaptor = new MyAdaptor(this,city,state,imgs);
        listView.setAdapter(adaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(List_of_cities.this, "Clicked "+city[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
    class MyAdaptor extends ArrayAdapter<String> {
        Context context;
        String rname[];
        String rcity[];
        int rimage[];

        MyAdaptor(Context c,String srt1[],String str2[],int imgs[]){
            super(c,R.layout.listview,R.id.textview1, city);
            this.context = c;
            this.rname = city;
            this.rcity = state;
            this.rimage = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.listview,parent,false);
            ImageView image = row.findViewById(R.id.img1);
            TextView fort = row.findViewById(R.id.textview1);
            TextView citie = row.findViewById(R.id.textview2);
            image.setImageResource(imgs[position]);
            fort.setText(city[position]);
            citie.setText(state[position]);


            return row;
        }
    }
}