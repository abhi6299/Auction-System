package com.example.e_shipmentauctionsystem1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class home2 extends AppCompatActivity {
    SearchView mySearchView;
    ArrayList<AdapterItems>    listnewsData = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        mySearchView=(SearchView)findViewById(R.id.searchview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //add data and view it
        //listnewsData.add(new AdapterItems(R.drawable.Electronics,"developer"));
        myadapter=new MyCustomAdapter(listnewsData);
        ListView lsNews=(ListView)findViewById(R.id.lvlist);
        lsNews.setAdapter(myadapter);//intisal with data

        //update  data in listview
        listnewsData.add(new AdapterItems(R.drawable.electronics,"Electronic"));
        listnewsData.add(new AdapterItems(R.drawable.furniture,"TVs & Appliances"));
        listnewsData.add(new AdapterItems(R.drawable.furniture,"Furniture"));
        listnewsData.add(new AdapterItems(R.drawable.furniture,"Sports Item"));
        listnewsData.add(new AdapterItems(R.drawable.furniture,"Books"));
        listnewsData.add(new AdapterItems(R.drawable.furniture,"Vehicles"));

        myadapter.notifyDataSetChanged();
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });


    }

    private class MyCustomAdapter extends BaseAdapter {
        public  ArrayList<AdapterItems>  listnewsDataAdpater ;

        public MyCustomAdapter(ArrayList<AdapterItems>  listnewsDataAdpater) {
            this.listnewsDataAdpater=listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdpater.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.types, null);

            final   AdapterItems s = listnewsDataAdpater.get(position);

            ImageView iv=( ImageView)myView.findViewById(R.id.imageView);
            iv.setBackgroundResource(s.ID);

            TextView tv=(TextView)myView.findViewById(R.id.name);
            tv.setText(s.product);

            Button bu=(Button)myView.findViewById(R.id.button);
            bu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GoToNext();
                }
            });
            return myView;
        }

        private void GoToNext() {
            Intent intent=new Intent(home2.this,productdescActivity.class);
            startActivity(intent);
        }


    }

}
