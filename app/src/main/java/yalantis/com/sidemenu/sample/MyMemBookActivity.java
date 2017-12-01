package yalantis.com.sidemenu.sample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import yalantis.com.sidemenu.sample.SwipeLayout;
import com.nineoldandroids.view.ViewHelper;

public class MyMemBookActivity extends Activity {

    private SwipeLayout sample1, sample2, sample3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mymembookactivity);

//        SwipeLayout swipeLayout = (SwipeLayout)findViewById(R.id.godfather);
//        swipeLayout.setDragEdge(SwipeLayout.DragEdge.Bottom); // Set in XML

        //sample1

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

        //sample2
        //2-0
        sample2 = (SwipeLayout) findViewById(R.id.sample2_0);
        sample2.setShowMode(SwipeLayout.ShowMode.LayDown);
        sample2.addDrag(SwipeLayout.DragEdge.Right, sample2.findViewWithTag("Bottom2"));
//        sample2.setShowMode(SwipeLayout.ShowMode.PullOut);
        sample2.findViewById(R.id.star).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyMemBookActivity.this, "Star", Toast.LENGTH_SHORT).show();
            }
        });

        sample2.findViewById(R.id.trash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyMemBookActivity.this, "Trash Bin", Toast.LENGTH_SHORT).show();
            }
        });

        sample2.findViewById(R.id.magnifier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyMemBookActivity.this, "Magnifier", Toast.LENGTH_SHORT).show();
            }
        });

        sample2.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyMemBookActivity.this, "Click on surface", Toast.LENGTH_SHORT).show();
            }
        });

        //2-1
        sample1 = (SwipeLayout) findViewById(R.id.sample2_1);
        sample1.setShowMode(SwipeLayout.ShowMode.LayDown);
        sample1.addDrag(SwipeLayout.DragEdge.Right, sample1.findViewWithTag("Bottom2"));
//        sample1.setShowMode(SwipeLayout.ShowMode.PullOut);
        sample1.findViewById(R.id.star).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyMemBookActivity.this, "Star", Toast.LENGTH_SHORT).show();
            }
        });

        sample1.findViewById(R.id.trash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyMemBookActivity.this, "Trash Bin", Toast.LENGTH_SHORT).show();
            }
        });

        sample1.findViewById(R.id.magnifier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyMemBookActivity.this, "Magnifier", Toast.LENGTH_SHORT).show();
            }
        });

        sample1.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyMemBookActivity.this, "Click on surface", Toast.LENGTH_SHORT).show();
            }
        });

        //2-2
        sample3 = (SwipeLayout) findViewById(R.id.sample2_2);
        sample3.setShowMode(SwipeLayout.ShowMode.LayDown);
        sample3.addDrag(SwipeLayout.DragEdge.Right, sample3.findViewWithTag("Bottom2"));
//        sample3.setShowMode(SwipeLayout.ShowMode.PullOut);
        sample3.findViewById(R.id.star).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyMemBookActivity.this, "Star", Toast.LENGTH_SHORT).show();
            }
        });

        sample3.findViewById(R.id.trash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyMemBookActivity.this, "Trash Bin", Toast.LENGTH_SHORT).show();
            }
        });

        sample3.findViewById(R.id.magnifier).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyMemBookActivity.this, "Magnifier", Toast.LENGTH_SHORT).show();
            }
        });
        sample3.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyMemBookActivity.this, "Click on surface", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
