package com.example.gcccylclingmobileapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gcccylclingmobileapplication.R;

import java.util.ArrayList;

class EventListActivity extends AppCompatActivity {
    ListView event_listView;
    EditText event_name;
    Button btn_createEvent,btn_updateEvent;

    ArrayList<String> events = new ArrayList<String>();
    ArrayAdapter myAddapter1;

    Integer indexVal;
    String item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        event_listView = (ListView) findViewById(R.id.event_listView);
        btn_createEvent = (Button) findViewById(R.id.btn_createEvent);
        btn_createEvent = (Button) findViewById(R.id.btn_updateEvent);
        event_name = (EditText) findViewById(R.id.event_name);

        myAddapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,events);
        event_listView.setAdapter(myAddapter1);

        //Add Events
        btn_createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringval = event_name.getText().toString();
                events.add(stringval);
                myAddapter1.notifyDataSetChanged();
                event_name.setText("");

            }
        });

        //select item
        event_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + "has been selected";
                indexVal = i;
                Toast.makeText(EventListActivity.this,item, Toast.LENGTH_SHORT).show();
            }
        });

        //Update
        btn_updateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringval = event_name.getText().toString();
                events.set(indexVal, stringval);
                myAddapter1.notifyDataSetChanged();
            }
        });

        //Delete
        event_listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + "has been deleted";
                Toast.makeText(EventListActivity.this,item, Toast.LENGTH_SHORT).show();
                events.remove(i);
                myAddapter1.notifyDataSetChanged();

                return true;

            }
        });
    }
}
