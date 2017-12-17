package yalantis.com.sidemenu.sample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiadr2368.EditNoteActivity;
import com.jiadr2368.ShowNoteActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyMemBookActivity extends AppCompatActivity {

    SwipeLayout sample;
    TextView tv1,tv,notetitle_tv,notetime_tv;
    LinearLayout ll;
    private String text,title;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    String notecontent;
    int num = 1;
    private View mView,mView1,mView2;
    TextView tva;
    RelativeLayout rl;
    ArrayList<View> mViews = new ArrayList<View>(20);;
    ImageView imageView;
    SharedPreferences init_para;
    SharedPreferences.Editor init_para_ed;
    int init_para_num,first_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mymembookactivity);

        ll = (LinearLayout)findViewById(R.id.note_bottle);

//        mViews = new ArrayList<View>(20);

//        System.out.println("MyMemBookActivity onCreate been called");
//
//        Log.d("sorry","this activity has been destroyed");
//
//        init_para  = getSharedPreferences("init_para",MODE_PRIVATE);
//
//        init_para_ed = init_para.edit();
//
//        init_para_num = init_para.getInt("init_para_num",0);
//
//        System.out.println("Jdr" + init_para_num + "has been get");

//        if(mViews.isEmpty()){
//            mViews.add(View.inflate(getApplicationContext(),R.layout.sample2,null));
//            ll.addView(mViews.get(0));
//            sample = (SwipeLayout)mViews.get(0).findViewById(R.id.sample_layout);
//            generateNoteSample(0,sample);
//        }
//        else{
//            for(int i=0;i<num;i++){
//                ll.addView(mViews.get(i));
//            }
//        }

//        refresh();

//        imageView = (ImageView)findViewById(R.id.imageView);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mViews.add(View.inflate(getApplicationContext(),R.layout.sample2,null));
//                ll.addView(mViews.get(num));
//                sample = (SwipeLayout)mViews.get(num).findViewById(R.id.sample_layout);
//                generateNoteSample(num,sample);
//                num++;
//                refresh();
//            }
//        });
    }

    @Override
    protected void onResume(){
        super.onResume();

        System.out.println("MyMemBookActivity onResume been called");
        System.out.println("MyMemBookActivity onResume been called" + mViews.isEmpty());
        System.out.println("MyMemBookActivity onResume been called" + num);

        init_para  = getSharedPreferences("init_para",MODE_PRIVATE);

        init_para_num = init_para.getInt("init_para_num",0);

        first_time = init_para.getInt("first_time",0);

        num = init_para_num;

        System.out.println("ZRT" + init_para_num + "has been get");

        System.out.println("ZRT" + "size of mViews is " + mViews.size());

        if(init_para_num==0){
            //如果之前没有新建过任何记录，则自动增加一个记录
//            mViews.add(View.inflate(getApplicationContext(),R.layout.sample2,null));
//            ll.addView(mViews.get(0));
//            sample = (SwipeLayout)mViews.get(0).findViewById(R.id.sample_layout);
//            sample.setNum(0);
//            generateNoteSample(sample);
        }
        else{
            if(mViews.size()!=0){
                //并没有重新起
                 for(int i=0;i<init_para_num;i++){
//                     ll.addView(mViews.get(i));
                 }
//                refresh(init_para_num);
            }
            else{
                //之前有新增加过记录,按照记录数目进行新增
                for(int i=0;i<init_para_num;i++){
//                    if(!mViews.isEmpty()){
//
                    System.out.println("ZRT mViews empty ? mViews.isEmpty() = " + mViews.isEmpty());
                    System.out.println("ZRT" +  "mViews.size() = " + mViews.size());
//                        //mViews不空，说明该Activity的onDestroy方法没有被执行过，那么啥也不用干
//                        if(i!=0){
////                            ll.addView(mViews.get(i));
//                        }
//                    }else{
                    //mViews空了，说明该Activity重新起了，那么要重新加
                    mViews.add(View.inflate(getApplicationContext(),R.layout.sample2,null));
                    ll.addView(mViews.get(i));
                    sample = (SwipeLayout)mViews.get(i).findViewById(R.id.sample_layout);
                    //在创建的时候就为每个sample对象打上自己的标号
                    sample.setNum(i);
                    generateNoteSample(sample);
//                    }
                }
                refresh(init_para_num);
            }

        }

        refresh(init_para_num);

        if(mViews.isEmpty()){
            Log.d("OH","mViews is empty");
        }
        else{
            for(int i=0;i<mViews.size();i++){
                Log.d("" + i,"Sample " + i);
            }
        }

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViews.add(View.inflate(getApplicationContext(),R.layout.sample2,null));
                ll.addView(mViews.get(num));
                sample = (SwipeLayout)mViews.get(num).findViewById(R.id.sample_layout);
                //在创建的时候就为每个sample对象打上自己的标号
                sample.setNum(num);
                generateNoteSample(sample);
                num++;
                refresh(num);

            }
        });
    }

    //依次加载所有note记录内容
    private void refresh(int num){
        for (int i=0;i<num;i++){
            sample = (SwipeLayout)mViews.get(i).findViewById(R.id.sample_layout);

            sp = getSharedPreferences("content_note_" + i,MODE_PRIVATE);
            notetitle_tv = (TextView)sample.findViewById(R.id.textView7);
            notetitle_tv.setText(sp.getString("notetitle_" + i,null));
            title = sp.getString("notetitle_" + i,null);
            notetime_tv = (TextView)sample.findViewById(R.id.textView4);
            notetime_tv.setText(sp.getString("notetime_" + i,null));
            notecontent = sp.getString("notecontent_" + i,null);
        }
    }

    private void generateNoteSample(final SwipeLayout sample){

        sample.setShowMode(SwipeLayout.ShowMode.LayDown);
        sample.addDrag(SwipeLayout.DragEdge.Right, sample.findViewWithTag("Bottom2"));

        //设置按键响应
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
                tv1 = (TextView)sample.findViewById(R.id.textView7);
                tv1.setText("");
                tv = (TextView)sample.findViewById(R.id.textView4);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                tv.setText(df.format(new Date()));
                //保存下修改
                sp = getSharedPreferences("content_note_" + sample.getNum(),MODE_PRIVATE);
                ed = sp.edit();
                ed.putString("notetitle_" + sample.getNum(),"");
                ed.putString("notecontent_" + sample.getNum(),"");
                ed.putString("notetime_" + sample.getNum(),df.format(new Date()));
                ed.commit();
            }
        });

        sample.findViewById(R.id.magnifier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyMemBookActivity.this,EditNoteActivity.class);
                sp = getSharedPreferences("content_note_" + sample.getNum(),MODE_PRIVATE);
                ed = sp.edit();
                intent.putExtra("Title",sp.getString("notetitle_" + sample.getNum(),null));

                intent.putExtra("Note",sp.getString("notecontent_" + sample.getNum(),null));
                intent.putExtra("Num","" + sample.getNum());
                startActivity(intent);
            }
        });

        sample.setOnLongClickListener((new View.OnLongClickListener() {
            @Override
            public  boolean onLongClick(View v) {
                Intent intent = new Intent(MyMemBookActivity.this,ShowNoteActivity.class);
                sp = getSharedPreferences("content_note_" + sample.getNum(),MODE_PRIVATE);
                ed = sp.edit();
                intent.putExtra("Title",sp.getString("notetitle_" + sample.getNum(),null));

                intent.putExtra("Note",sp.getString("notecontent_" + sample.getNum(),null));
                intent.putExtra("Num","" + sample.getNum());
                System.out.println("Jdr" + sample.getNum());

                startActivity(intent);
                return true;
            }
        }));
    }

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(MyMemBookActivity.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode,event);
    }

    @Override
    protected void onPause(){
        super.onPause();
        // 把num值保存下来
        init_para  = getSharedPreferences("init_para",MODE_PRIVATE);
        init_para_ed = init_para.edit();
        init_para_ed.putInt("init_para_num",num);
        init_para_ed.putInt("first_time",1);
        Log.i("ZRT","num " + num + "written into mem");
        init_para_ed.commit();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        System.out.println("MyMemBookActivity onDestroy been called");
        Log.d("Destroy","been called");
    }

}
