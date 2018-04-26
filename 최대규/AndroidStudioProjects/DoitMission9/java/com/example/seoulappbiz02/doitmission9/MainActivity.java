package com.example.seoulappbiz02.doitmission9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView number;
    private EditText name;
    private EditText birth;
    private EditText phone;
    private ListView listView;
    private Toast toast;
    CustomerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toast = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);

        number = findViewById(R.id.numberText);

        name = findViewById(R.id.nameEdit);
        birth = findViewById(R.id.birthEdit);
        phone = findViewById(R.id.phoneEdit);

        listView = findViewById(R.id.listView);

        adapter = new CustomerAdapter();
        adapter.addItem(new CustomerItem("최대규", "010-6253-9671", "1992-05-11"));
        adapter.addItem(new CustomerItem("다현", "010-1234-9671", "1995-01-19"));

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CustomerItem item = (CustomerItem) adapter.getItem(position);
                toast.setText("선택된 이름 : " + item.getName());
                toast.show();
            }
        });

        number.setText(String.valueOf(adapter.getCount()));

        Button button = findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().equals("") && !phone.getText().toString().equals("") && !birth.getText().toString().equals("")){
                    adapter.addItem(new CustomerItem(name.getText().toString(), phone.getText().toString(), birth.getText().toString()));
                    toast.setText("추가된 이름 : " + name.getText().toString());
                    toast.show();
                    name.setText("");
                    phone.setText("");
                    birth.setText("");
                } else if (name.getText().toString().equals("")){
                    toast.setText("이름을 입력해주세요.");
                    toast.show();
                } else if (phone.getText().toString().equals("")){
                    toast.setText("전화번호를 입력해주세요.");
                    toast.show();
                } else if (birth.getText().toString().equals("")){
                    toast.setText("생년월일을 입력해주세요.");
                    toast.show();
                }
                adapter.notifyDataSetChanged();
                number.setText(String.valueOf(adapter.getCount()));
            }
        });
    }

    class CustomerAdapter extends BaseAdapter{
        ArrayList<CustomerItem> arrayList = new ArrayList();

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CustomerItemView view;
            if(convertView == null){
                view = new CustomerItemView(getApplicationContext());
            } else {
                view = (CustomerItemView)convertView;
            }

            view.setImageView(arrayList.get(position).getResId());
            view.setNameText(arrayList.get(position).getName());
            view.setPhoneText(arrayList.get(position).getPhoneNumber());
            view.setBirthText(arrayList.get(position).getBirthday());

            return view;
        }

        public void addItem(CustomerItem item){
            arrayList.add(item);
        }
    }
}
