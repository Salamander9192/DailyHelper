package yalantis.com.sidemenu.sample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemBookActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener{

    //目前还是定死的内容，稍候会修改成读出SP内存储的内容
    String [] aMemo = {"","","","","","","",""};
    String [] aTime = {"","","","","","","",""};
    String [] aWhole = {"","","","","","","",""};

    ListView lv;
    TextView tv;
    ArrayAdapter<String> aa;

    SharedPreferences sp;
    SharedPreferences.Editor ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membooknew);

        lv = (ListView)findViewById(R.id.lv);
        //获取只能被本应用程序读写的ShareaPerference对象
        sp = getSharedPreferences("memorynote",MODE_PRIVATE);
        ed = sp.edit();

        for(int i=0;i<8;i++){
            String content = sp.getString(""+i,null);
            String time = sp.getString(""+i+"_time",null);
            if(content==""||content==null){
                switch (i){
                    case 0 : aMemo[0] = "1. 单击可以修改备忘内容";
                        break;
                    case 1 : aMemo[1] = "2. 长按可以清除备忘内容";
                        break;
                    case 2 : aMemo[2] = "3. 新增你自己的备忘吧！";
                        break;
                    case 3 : aMemo[3] = "4. ";
                        break;
                    case 4 : aMemo[4] = "5. ";
                        break;
                    case 5 : aMemo[5] = "6. ";
                        break;
                    case 6 : aMemo[6] = "7. ";
                        break;
                    case 7 : aMemo[7] = "8. ";
                        break;
                    default: break;
                }
                aTime[i] = "";
            }
            else {
                if(time==null){
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    aTime[i] = "Created at : " + df.format(new Date());
                }
                else {
                    aTime[i] = time;
                }
                aMemo[i] = content;
            }
            aWhole[i] = aMemo[i] + "\n" + aTime[i];
        }

        aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,aWhole);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int pos, long id){
        Intent it = new Intent(this,EditActivity.class);
        it.putExtra("备忘",aMemo[pos]);
        startActivityForResult(it,pos);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View v, int pos, long id){
        //清除长按行的内容
        aMemo[pos] = aMemo[pos].substring(0,3);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        aTime[pos] = "Modified at : " + df.format(new Date());
        for(int i=0;i<aMemo.length;i++){
            ed.putString(""+i,aMemo[i]);
            aWhole[i] = aMemo[i] + "\n" + aTime[i];
        }
        aa.notifyDataSetChanged();
        ed.putString(""+pos+"_time",aTime[pos]);
        ed.commit();
        Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_CANCELED){
            Toast.makeText(getApplicationContext(), "操作已取消", Toast.LENGTH_SHORT).show();
        }
        else if(resultCode==RESULT_OK){
            //将修改内容取出来
            aMemo[requestCode] = data.getStringExtra("备忘");
            aTime[requestCode] = data.getStringExtra("时间");
            //使用SP对aMemo的结果进行保存
            for(int i=0;i<aMemo.length;i++){
                ed.putString(""+i,aMemo[i]);
                aWhole[i] = aMemo[i]  + "\n" + aTime[i];
            }
            aa.notifyDataSetChanged();
            //将当前修改的条目时间写入ed
            ed.putString(""+requestCode+"_time",data.getStringExtra("时间"));
            ed.commit();
            Toast.makeText(getApplicationContext(), "修改成功", Toast.LENGTH_SHORT).show();
        }
    }
}