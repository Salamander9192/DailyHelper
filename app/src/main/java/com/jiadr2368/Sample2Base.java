package com.jiadr2368;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import yalantis.com.sidemenu.sample.EditActivity;
import yalantis.com.sidemenu.sample.MyMemBookActivity;
import yalantis.com.sidemenu.sample.R;
import yalantis.com.sidemenu.sample.SwipeLayout;

/**
 * Created by Administrator on 2017/12/1.
 * 将SwipeLayout封装在这个类里，想为SwipeLayout新增功能就在这里增加
 */

public class Sample2Base extends Activity{

    SwipeLayout sample;
    TextView tv;
    private Boolean starred = Boolean.FALSE;

    public Sample2Base(SwipeLayout sample){
        this.sample = sample;
    }

    public void equippedSample2Base(Activity myactivity){
        //    sample = (SwipeLayout) findViewById(R.id.sample2_0);
        sample.setShowMode(SwipeLayout.ShowMode.LayDown);
        sample.addDrag(SwipeLayout.DragEdge.Right, sample.findViewWithTag("Bottom2"));
//        sample2.setShowMode(SwipeLayout.ShowMode.PullOut);

        sample.findViewById(R.id.star).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(starred == Boolean.FALSE)
                    starred = Boolean.TRUE;
                else
                    starred = Boolean.FALSE;
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
                intent.setClassName("yalantis.com.sidemenu.sample","yalantis.com.sidemenu.sample.EditActivity");
                startActivityForResult(intent,0);

            }
        });

        sample.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    public Boolean isStarred(){
        return starred;
    }

}

//        Sample1原来的代码
//        sample1 = (SwipeLayout) findViewById(R.id.sample1);
//        sample1.setShowMode(SwipeLayout.ShowMode.PullOut);
//        View starBottView = sample1.findViewById(R.id.starbott);
//        sample1.addDrag(SwipeLayout.DragEdge.Left, sample1.findViewById(R.id.bottom_wrapper));
//        sample1.addDrag(SwipeLayout.DragEdge.Right, sample1.findViewById(R.id.bottom_wrapper_2));
//        sample1.addDrag(SwipeLayout.DragEdge.Top, starBottView);
//        sample1.addDrag(SwipeLayout.DragEdge.Bottom, starBottView);
//        sample1.addRevealListener(R.id.delete, new SwipeLayout.OnRevealListener() {
//            @Override
//            public void onReveal(View child, SwipeLayout.DragEdge edge, float fraction, int distance) {
//
//            }
//        });
//
//        sample1.getSurfaceView().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MyMemBookActivity.this, "Click on surface", Toast.LENGTH_SHORT).show();
//                Log.d(MyMemBookActivity.class.getName(), "click on surface");
//            }
//        });
//        sample1.getSurfaceView().setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Toast.makeText(MyMemBookActivity.this, "longClick on surface", Toast.LENGTH_SHORT).show();
//                Log.d(MyMemBookActivity.class.getName(), "longClick on surface");
//                return true;
//            }
//        });
//        sample1.findViewById(R.id.star2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MyMemBookActivity.this, "Star", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        sample1.findViewById(R.id.trash2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MyMemBookActivity.this, "Trash Bin", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        sample1.findViewById(R.id.magnifier2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MyMemBookActivity.this, "Magnifier", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        sample1.addRevealListener(R.id.starbott, new SwipeLayout.OnRevealListener() {
//            @Override
//            public void onReveal(View child, SwipeLayout.DragEdge edge, float fraction, int distance) {
//                View star = child.findViewById(R.id.star);
//                float d = child.getHeight() / 2 - star.getHeight() / 2;
//                ViewHelper.setTranslationY(star, d * fraction);
//                ViewHelper.setScaleX(star, fraction + 0.6f);
//                ViewHelper.setScaleY(star, fraction + 0.6f);
//            }
//        });
