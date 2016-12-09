package com.yang.stringtips;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText et;
    private TextView tv;

    private String text = "学习字符串的使用";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        et = (EditText) findViewById(R.id.text);
        tv = (TextView) findViewById(R.id.text2);
//        func1();
//        func2();


//        func3();
//        func4();
//        func5();
//        func6();
//        func7();
//        func8();
//        func9();
//        func10();
//        func11();
//        func12();
//        func13();
        func14();
    }

    private void func3() {
        String str = "123";
        long startTime_1 = new Date().getTime();
        for (int i = 0; i < 100000; i ++){
            str += "1";
        }
        logTimeInterval("String", startTime_1);

        StringBuffer sf = new StringBuffer("123");
        long startTime_2 = new Date().getTime();
        for (int i = 0; i < 100000; i ++){
            sf.append("1");
        }
        logTimeInterval("StringBuffer", startTime_2);

        StringBuilder sb = new StringBuilder("123");
        long startTime_3 = new Date().getTime();
        for (int i = 0; i < 100000; i ++){
            sb.append("1");
        }
        logTimeInterval("StringBuilder", startTime_3);
    }

    private void logTimeInterval(String tag, long startTime){
        long interval = new Date().getTime() - startTime;
        Log.i(tag, interval + "");
    }


    public void func1(){
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE), 2, 4, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        et.setText(ss);
    }
    public void func2(){
        SpannableStringBuilder ssb = new SpannableStringBuilder();

        SpannableString ss = new SpannableString(text);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE), 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        SpannableString ss1 = new SpannableString(text);
        ss1.setSpan(new ForegroundColorSpan(Color.RED), 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ssb.append(ss);
        ssb.append(ss1);
        tv.setText(ssb);
    }
    public void func4(){
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new BackgroundColorSpan(Color.BLUE), 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(ss);
    }
    public void func5(){
        SpannableString ss = new SpannableString(text);
        ClickableSpan span = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "ClickableSpan", Toast.LENGTH_LONG).show();
            }
        };
        ss.setSpan(span, 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(ss);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void func6(){
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE), 2, 4, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        tv.setText(ss);
    }
    public void func7(){
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new StrikethroughSpan(), 2, 4, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        tv.setText(ss);
    }
    public void func8(){
        SpannableString ss = new SpannableString(text);
        ss.setSpan(new UnderlineSpan(), 2, 4, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        tv.setText(ss);
    }
    public void func9(){
        SpannableString ss = new SpannableString(text);
        Drawable d = getResources().getDrawable(R.mipmap.ic_launcher);
        d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(d, DynamicDrawableSpan.ALIGN_BASELINE);
        ss.setSpan(span, 2, 4, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        tv.setText(ss);
    }
    public void func10(){
        SpannableString ss = new SpannableString(text);
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        ss.setSpan(superscriptSpan, 2, 4, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        tv.setText(ss);
    }
    public void func11(){
        SpannableString ss = new SpannableString(text);
        URLSpan urlSpan = new URLSpan("http://www.baidu.com");
        ss.setSpan(urlSpan, 2, 4, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        tv.setText(ss);
        tv.setMovementMethod(new LinkMovementMethod());
    }
    public void func12(){
        SpannableString ss1 = new SpannableString(text);
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        ss1.setSpan(superscriptSpan, 2, 4, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        SpannableString ss2 = new SpannableString(text);
        URLSpan urlSpan = new URLSpan("http://www.baidu.com");
        ss2.setSpan(urlSpan, 2, 4, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append(ss1);
        ssb.append(ss2);
        tv.setText(ssb);
        tv.setMovementMethod(new LinkMovementMethod());
    }

    public void func13(){
        Log.d("===", "---------------------------------");

        //字符串拼接  
        Log.d("===", TextUtils.concat("Hello", " ", "world!").toString());

        //判断是否为空字符串  
        Log.d("===", TextUtils.isEmpty("Hello") + "");

        //判断是否只有数字  
        Log.d("===", TextUtils.isDigitsOnly("Hello") + "");

        //判断字符串是否相等  
        Log.d("===", TextUtils.equals("Hello", "Hello") + "");

        //获取字符串的倒序  
        Log.d("===", TextUtils.getReverse("Hello", 0, "Hello".length()).toString());

        //获取字符串的长度  
        Log.d("===", TextUtils.getTrimmedLength("Hello world!") + "");
        Log.d("===", TextUtils.getTrimmedLength("  Hello world!  ") + "");

        //获取html格式的字符串 , 将<、>、\、空格……转为html定义的 &lt;  &gt;等
        Log.d("===", TextUtils.htmlEncode("<html>\n" +
                "<body>\n" +
                "这是一个非常简单的HTML。\n" +
                "</body>\n" +
                "</html>"));

        //获取字符串中第一次出现子字符串的字符位置  
        Log.d("===", TextUtils.indexOf("Hello world!", "Hello") + "");

        //截取字符串  
        Log.d("===", TextUtils.substring("Hello world!", 0, 5));

        //通过表达式截取字符串  
        Log.d("===", TextUtils.split("  Hello world!  ", " ")[0]);
    }


    public void func14(){
        String text = "<p>用户就诊须知：</p><p>1.用户添加就诊人，就诊卡请确保其内容真实性！</p><p>2.添加的就诊人与其就诊卡为仁济医院真实存在。</p><p>3.不支持初次就诊。</p><p>4.一个账号最多只能绑定两个就诊人。</p>";
        Spanned html = Html.fromHtml(text);
        tv.setText(html);
    }


}
