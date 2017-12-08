package com.jiadr2368;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

import yalantis.com.sidemenu.sample.MyMemBookActivity;
import yalantis.com.sidemenu.sample.R;

public class EditNoteActivity extends AppCompatActivity {

    EditText et,et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcontent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Saved!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                SharedPreferences sp = getSharedPreferences("content_note",MODE_PRIVATE);;
                SharedPreferences.Editor ed = sp.edit();
                //在选择保存的时候将修改内容保存下来
                ed.putString("notetitle_0",et1.getText().toString());
                ed.putString("notecontent_0",et.getText().toString());
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                ed.putString("notetime_0",df.format(new Date()));
                ed.commit();
                //完成修改，返回NoteBook主页，用startActivity起，保证内容得到刷新
                Intent it = new Intent(EditNoteActivity.this, MyMemBookActivity.class);
                startActivity(it);
            }
        });

        et1 = (EditText)findViewById(R.id.edit_title);
        et1.setText(getIntent().getStringExtra("Title"));
        et = (EditText) findViewById(R.id.edit_note);
        et.setText(getIntent().getStringExtra("Note"));
    }

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(EditNoteActivity.this,MyMemBookActivity.class);
            startActivity(intent);
            this.finish();
        }
        return super.onKeyDown(keyCode,event);
    }
}
