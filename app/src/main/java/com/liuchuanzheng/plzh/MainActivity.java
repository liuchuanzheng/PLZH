package com.liuchuanzheng.plzh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.et_count)
    EditText etCount;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.et_result)
    EditText etResult;
    String content = "爱，萌，乐，优，福，鲜，吉，宝，麦，汪，旺，美，新，厨，生，龙，迪，中，品，果，米，多，悦";
    int count = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        etContent.setText(content);
        etCount.setText(count+"");
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        String finalContent= "";
        int finalCount = 1;
        finalContent = etContent.getText().toString().trim();
        finalCount = Integer.valueOf(etCount.getText().toString().trim());
        plzh(finalContent,finalCount);
    }

    private void plzh(String finalContent, int finalCount) {
        if (TextUtils.isEmpty(finalContent)){
            Toast.makeText(this,"要排列的内容为空",Toast.LENGTH_SHORT).show();
            return;
        }
        if (0 == finalCount){
            Toast.makeText(this,"排列个数不对",Toast.LENGTH_SHORT).show();
            return;
        }
        String[] strings = finalContent.split("，");
        for (String item:strings){
            Log.i("liuchuanzheng",item);
        }
        if(finalCount > strings.length || strings.length <= 0){
            return ;
        }

        String finalResult = "";
        finalPLZH(finalResult,strings,finalCount);

    }

    private String finalPLZH(String finalResult, String[] strings, int finalCount) {
        if (finalCount == 1){
            return finalResult;
        }else{
            for (int i=0;i<strings.length;i++){
                for (int j=0;i<strings.length;i++){

                }
            }
        }

        return finalResult;
    }
}
