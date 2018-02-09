package com.liuchuanzheng.plzh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
    String content = "爱，萌，乐，优，福，鲜，吉，宝，麦，汪，旺，美，新，厨，生，龙，迪，中，品，果，米，多，悦";
    int count = 3;
    @BindView(R.id.tv_result)
    TextView tvResult;
    private int all = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        etContent.setText(content);
        etCount.setText(count + "");
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        all = 0;
        tvResult.setText("");
        String finalContent = "";
        int finalCount = 1;
        finalContent = etContent.getText().toString().trim();
        finalCount = Integer.valueOf(etCount.getText().toString().trim());
        plzh(finalContent, finalCount);
    }

    private void plzh(String finalContent, final int finalCount) {
        if (TextUtils.isEmpty(finalContent)) {
            Toast.makeText(this, "要排列的内容为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (0 == finalCount) {
            Toast.makeText(this, "排列个数不对", Toast.LENGTH_SHORT).show();
            return;
        }
        String[] strings = finalContent.split("，");

        for (String item : strings) {
            Log.i("liuchuanzheng", item);
        }
        if (finalCount > strings.length || strings.length <= 0) {
            return;
        }
        final List lst = Arrays.asList(strings);
        new Thread(new Runnable() {
            @Override
            public void run() {
                take("", finalCount, lst);
            }
        }).start();


    }

    public void take(String s, int total, final List lst) {
        for (int i = 0; i < lst.size(); i++) {
            //System.out.println("i="+i);
            List templst = new LinkedList(lst);
            String n = (String) templst.remove(i);// 取出来的数字
            final String str = s + n;
            if (total == 1) {
                this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(str);//以最极端 n个里面只取一个，直接把取出来的结果输出即可
                        //total=all;
                        all++;
                        System.out.println(all + "");//以最极端 n个里面只取一个，直接把取出来的结果输出即可
                        tvResult.append(all+str+" " );
                        if (all%6 == 0){
                            tvResult.append("\n");
                        }
                    }
                });

            } else {
                int temp = total - 1;//在同一层中total总量不能减,不能再原有变量的基础上
                take(str, temp, templst);// 这里的temp以及templst都是全新的变量和集合
            }
        }

    }
}
