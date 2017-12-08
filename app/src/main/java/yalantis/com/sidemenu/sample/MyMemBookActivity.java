package yalantis.com.sidemenu.sample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiadr2368.EditNoteActivity;
import com.jiadr2368.ShowNoteActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyMemBookActivity extends AppCompatActivity {

    private SwipeLayout sample;
    TextView tv1,tv,notetitle_tv,notetime_tv;
    LinearLayout ll;
    private String text,title;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    String notecontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mymembookactivity);

        sample = (SwipeLayout) findViewById(R.id.sample2_0);
        sample.setShowMode(SwipeLayout.ShowMode.LayDown);
        sample.addDrag(SwipeLayout.DragEdge.Right, sample.findViewWithTag("Bottom2"));

        //加载文本内容
        sp = getSharedPreferences("content_note",MODE_PRIVATE);
        ed = sp.edit();
        notetitle_tv = (TextView)findViewById(R.id.textView7);
        notetitle_tv.setText(sp.getString("notetitle_0",null));
        title = sp.getString("notetitle_0",null);
        notetime_tv = (TextView)findViewById(R.id.textView4);
        notetime_tv.setText(sp.getString("notetime_0",null));
        notecontent = sp.getString("notecontent_0",null);

//        sample2.setShowMode(SwipeLayout.ShowMode.PullOut);

        sample.findViewById(R.id.star).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sample.setStar();
                if(sample.getStar())
                    Toast.makeText(MyMemBookActivity.this,"Starred",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MyMemBookActivity.this,"Not Starred",Toast.LENGTH_SHORT).show();
            }
        });

        sample.findViewById(R.id.trash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1 = (TextView)findViewById(R.id.textView7);
                tv1.setText("");
                tv = (TextView)findViewById(R.id.textView4);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                tv.setText(df.format(new Date()));
                //保存下修改
                ed.putString("notetitle_0","");
                ed.putString("notecontent_0","");
                ed.putString("notetime_0",df.format(new Date()));
                ed.commit();
            }
        });

        sample.findViewById(R.id.magnifier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyMemBookActivity.this,EditNoteActivity.class);
                tv = (TextView)findViewById(R.id.textView7);
                intent.putExtra("Title",title);
                intent.putExtra("Note",notecontent);
                startActivity(intent);
            }
        });

        sample.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyMemBookActivity.this,ShowNoteActivity.class);
                tv = (TextView)findViewById(R.id.textView7);
                intent.putExtra("Title",title);
                intent.putExtra("Note",notecontent);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(MyMemBookActivity.this,MainActivity.class);
            startActivity(intent);
            this.finish();
        }
        return super.onKeyDown(keyCode,event);
    }

}
