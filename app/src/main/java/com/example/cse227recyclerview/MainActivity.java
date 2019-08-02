package com.example.cse227recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;
    Button b1;
    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    MyAdapter adapter;
    ArrayList<Person> a1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText)findViewById(R.id.ed2);
        b1 = (Button) findViewById(R.id.b1);

        rv = (RecyclerView) findViewById(R.id.rv);
        a1 = new ArrayList<>();
        adapter = new MyAdapter(this,a1);
        lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }

    public void dothis(View view) {
        String name = ed1.getText().toString();
        int reg = Integer.parseInt(ed2.getText().toString());

        Person p = new Person(name,reg);
        a1.add(p);
        adapter.notifyDataSetChanged();

    }
}
