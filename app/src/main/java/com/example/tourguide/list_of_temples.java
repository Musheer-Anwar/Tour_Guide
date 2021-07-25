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

public class list_of_temples extends AppCompatActivity {
    ListView listView;
    String namee[] ={"Golden Temple","Tirupathi Balaji","Jagannath Temple","Meenakshi Temple","Virupaksha Temple"};
    String cities[] = {"Amritsar","Tirumala","Puri","Madurai"," Hampi"};
    int img[] = {R.drawable.golden_temple,R.drawable.tirupathi_balajii,R.drawable.jagannath_temple,R.drawable.meenakshi_temple_madurai,R.drawable.virupaksha_temple_hampi};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_temples);
        listView = findViewById(R.id.listview2);
        list_of_temples.MyAdaptor adaptor = new list_of_temples.MyAdaptor(this,namee,cities,img);
        listView.setAdapter(adaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.goldentempleamritsar.org/"));
                    startActivity(intent);
                }
                if(position==1){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://timesofindia.indiatimes.com/religion/religious-places/history-of-tirupati-balaji-temple/articleshow/68206101.cms"));
                    startActivity(intent);
                }
                if(position==2){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.tutorialspoint.com/jagannath_temple/jagannath_temple_history.htm"));
                    startActivity(intent);
                }
                if(position==3){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.culturalindia.net/indian-temples/meenakshi-temple.html"));
                    startActivity(intent);
                }
                if(position==4){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://indiathedestiny.com/tourism/monuments/virupaksha-temple/"));
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
            super(c,R.layout.listview,R.id.textview1, namee);
            this.context = c;
            this.rname = namee;
            this.rcity = cities;
            this.rimage = img;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.listview,parent,false);
            ImageView image = row.findViewById(R.id.img1);
            TextView fort = row.findViewById(R.id.textview1);
            TextView citie = row.findViewById(R.id.textview2);
            image.setImageResource(img[position]);
            fort.setText(namee[position]);
            citie.setText(cities[position]);


            return row;
        }
    }
}