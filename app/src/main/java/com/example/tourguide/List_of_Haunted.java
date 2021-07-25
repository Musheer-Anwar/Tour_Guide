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

public class List_of_Haunted extends AppCompatActivity {
    ListView listView;
    String name[] = {"Bhangarh Fort","Kuldhara Village"," Dow Hill"," Jatinga","Agrasen ki Baoli"};
    String place[] = {"Rajasthan","Rajasthan","West Bengal","Assam","Delhi"};
    int imag[] = {R.drawable.bhangarhfort,R.drawable.kuldhara,R.drawable.dow_hill,R.drawable.jatinga,R.drawable.agrasen_kibaoli};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_haunted);
        listView = findViewById(R.id.listview3);
        List_of_Haunted.MyAdaptor adaptor = new MyAdaptor(this,name,place,imag);
        listView.setAdapter(adaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://theculturetrip.com/asia/india/articles/the-story-of-bhangarh-fort-indias-most-notorious-haunted-site/"));
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.tourmyindia.com/states/rajasthan/kuldhara-jaisalmer.html"));
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.thestatesman.com/travel/kurseong-ghost-stories-are-drawing-visitors-to-this-bengal-hill-town-1502741633.html"));
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.youthkiawaaz.com/2020/07/jatinga-the-mystical-place-of-assam-india/"));
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.holidify.com/places/delhi/agrasen-ki-baoli-sightseeing-6224.html"));
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
            this.rcity = place;
            this.rimage = imag;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.listview,parent,false);
            ImageView image = row.findViewById(R.id.img1);
            TextView a = row.findViewById(R.id.textview1);
            TextView b = row.findViewById(R.id.textview2);
            image.setImageResource(imag[position]);
            a.setText(name[position]);
            b.setText(place[position]);


            return row;
        }
    }
}