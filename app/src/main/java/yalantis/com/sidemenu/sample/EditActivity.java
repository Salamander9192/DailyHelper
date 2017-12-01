package yalantis.com.sidemenu.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EditActivity extends Activity implements View.OnClickListener {

    TextView tv;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Button cancelBtn = (Button)findViewById(R.id.cancelBtn);
        Button saveBtn = (Button)findViewById(R.id.saveBtn);
        Button resetBtn = (Button)findViewById(R.id.resetBtn);

        cancelBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(this);

        Intent it_from_main = getIntent();
        tv = (TextView)findViewById(R.id.textView);
        et = (EditText)findViewById(R.id.editText);
        String mem = it_from_main.getStringExtra("备忘");
        tv.setText(mem.substring(0,3));
        et.setText(mem.substring(3));

    }

    public void onClick(View v){
        if(v.getId()==R.id.cancelBtn){
            setResult(RESULT_CANCELED);
            finish();
        }
        else if(v.getId()==R.id.saveBtn){
            Intent it_self = new Intent();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //将修改后的et写入Intent，传递到MainActivity
            it_self.putExtra("备忘",tv.getText().toString() + et.getText().toString());
            it_self.putExtra("时间","Modified at : " + df.format(new Date()));
            setResult(RESULT_OK,it_self);
            finish();
        }
        else if(v.getId()==R.id.resetBtn){
            et.setText("");
            Toast.makeText(getApplicationContext(),"已清除，请重新输入", Toast.LENGTH_SHORT).show();
        }
    }

}