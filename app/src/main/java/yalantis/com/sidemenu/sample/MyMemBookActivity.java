package yalantis.com.sidemenu.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiadr2368.ShowNoteActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyMemBookActivity extends AppCompatActivity {

    private SwipeLayout sample;
    TextView tv;
    LinearLayout ll;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mymembookactivity);

        sample = (SwipeLayout) findViewById(R.id.sample2_0);
        sample.setShowMode(SwipeLayout.ShowMode.LayDown);
        sample.addDrag(SwipeLayout.DragEdge.Right, sample.findViewWithTag("Bottom2"));
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
                tv = (TextView)sample.findViewById(R.id.textView7);
                tv.setText("");
                tv = (TextView)sample.findViewById(R.id.textView4);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                tv.setText(df.format(new Date()));
            }
        });

        sample.findViewById(R.id.magnifier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.jiadr2368","com.jiadr2368.EditNoteActivity");
                startActivityForResult(intent,0);
            }
        });

        sample.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyMemBookActivity.this,ShowNoteActivity.class);
                tv = (TextView)findViewById(R.id.textView7);
                text = tv.getText().toString();
                intent.putExtra("Note",text);
                startActivity(intent);
            }
        });

    }

}
