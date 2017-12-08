package com.jiadr2368;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import yalantis.com.sidemenu.sample.MyMemBookActivity;
import yalantis.com.sidemenu.sample.R;

public class ShowNoteActivity extends AppCompatActivity {

    TextView tv,tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcontent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Begin your editing", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(ShowNoteActivity.this,EditNoteActivity.class);
                intent.putExtra("Title",getIntent().getStringExtra("Title"));
                intent.putExtra("Note",getIntent().getStringExtra("Note"));
                startActivity(intent);
            }
        });

        tv1 = (TextView)findViewById(R.id.show_title);
        tv1.setText(getIntent().getStringExtra("Title"));
        tv = (TextView)findViewById(R.id.show_note);
        tv.setText(getIntent().getStringExtra("Note"));
    }

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ShowNoteActivity.this,MyMemBookActivity.class);
            startActivity(intent);
            this.finish();
        }
        return super.onKeyDown(keyCode,event);
    }
}
