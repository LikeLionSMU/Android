package com.example.choidaek.doitmission10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.mainGrid);
        ItemAdapter adapter = new ItemAdapter();
        adapter.addItem(new ItemClass(R.drawable.clothes1, "롱코트1", "180,000원", "설명 1입니다. 뭐라고 써야할지..."));
        adapter.addItem(new ItemClass(R.drawable.clothes2, "롱코트2", "190,000원", "설명 2입니다. 뭐라고 써야할지..."));
        adapter.addItem(new ItemClass(R.drawable.clothes3, "롱코트3", "200,000원", "설명 3입니다. 뭐라고 써야할지..."));
        adapter.addItem(new ItemClass(R.drawable.clothes4, "롱코트4", "180,000원", "설명 4입니다. 뭐라고 써야할지..."));
        adapter.addItem(new ItemClass(R.drawable.clothes5, "롱코트5", "210,000원", "설명 5입니다. 뭐라고 써야할지..."));
        adapter.addItem(new ItemClass(R.drawable.clothes6, "롱코트6", "320,000원", "설명 6입니다. 뭐라고 써야할지..."));

        gridView.setAdapter(adapter);
    }

    class ItemAdapter extends BaseAdapter{
        ArrayList<ItemClass> arrayList = new ArrayList();

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public ItemClass getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        void addItem(ItemClass item){
            arrayList.add(item);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ItemView view = null;
            if(view == null){
                view = new ItemView(getApplicationContext());
            } else {
                view = (ItemView) convertView;
            }
            view.setImageView(arrayList.get(position).getResId());
            view.setNameView(arrayList.get(position).getName());
            view.setPriceView(arrayList.get(position).getPrice());
            view.setCommentView(arrayList.get(position).getComment());

            return view;
        }
    }
}
