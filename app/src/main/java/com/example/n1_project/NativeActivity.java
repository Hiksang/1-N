package com.example.n1_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.bootpay.core.Bootpay;
import kr.co.bootpay.core.BootpayAnalytics;
import kr.co.bootpay.core.events.BootpayEventListener;
import kr.co.bootpay.core.models.BootExtra;
import kr.co.bootpay.core.models.BootItem;
import kr.co.bootpay.core.models.BootUser;
import kr.co.bootpay.core.models.Payload;
import kr.co.bootpay.core.models.statistics.BootStatItem;

public class NativeActivity extends AppCompatActivity {
    private String application_id = "62760dcb2701800021f69edc"; //production
//    private String application_id = "5b9f51264457636ab9a07cdc"; //development


    Context context;
    Spinner spinner_pg;
    Spinner spinner_method;
    EditText edit_price;
    EditText edit_non_tax;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_native);

        this.context = this;
        spinner_pg = findViewById(R.id.spinner_pg);
        spinner_method = findViewById(R.id.spinner_method);
        edit_price = findViewById(R.id.edit_price);
        edit_non_tax = findViewById(R.id.edit_non_tax);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String price1 = bundle.getString("price1");
        edit_price.setText(price1);

        bootpayInit();
//        bootpayAnalyticsUserTrace();
//        bootpayAnalyticsPageTrace();
    }

    void bootpayInit() {
        BootpayAnalytics.init(this, application_id); //this는 context
    }

    public void goTraceUser(View v) {
        BootpayAnalytics.userTrace(
                "user_1234", //user_id
                "test1234@gmail.com", //email
                "홍길동", //user name
                1, //성별 남자:1, 여자:0
                "19941014", //생년월일
                "01012345678", //고객 전화번호
                "서울" //ex) 서울|인천|대구|광주|부산|울산|경기|강원|충청북도|충북|충청남도|충남|전라북도|전북|전라남도|전남|경상북도|경북|경상남도|경남|제주|세종|대전 중 1
        );
    }



    public void goTotalRequest(View v) {
        BootUser user = new BootUser().setPhone("010-1234-5678"); // 구매자 정보
//        BootExtra extra = new BootExtra().setQuotas(new int[] {0,2,3});  // 일시불, 2개월, 3개월 할부 허용, 할부는 최대 12개월까지 사용됨 (5만원 이상 구매시 할부허용 범위)
        BootExtra extra = new BootExtra().setCardQuota("0,2,3");  // 일시불, 2개월, 3개월 할부 허용, 할부는 최대 12개월까지 사용됨 (5만원 이상 구매시 할부허용 범위)
        Double price = 1000d;
        try {
            price = Double.parseDouble(edit_price.getText().toString());
        } catch (Exception e){}



        List<BootItem> items = new ArrayList<>();
        BootItem item1 = new BootItem().setName("음식가격").setId("ITEM_CODE_MOUSE").setQty(1).setPrice(price);
        items.add(item1);

        Payload payload = new Payload();
        payload.setApplicationId(application_id)
                .setOrderName("핀테크 테스트결제")
                .setOrderId("1234")
                .setPrice(price)
                .setUser(user)
                .setExtra(extra)
                .setItems(items);

        Bootpay.init(getSupportFragmentManager(), getApplicationContext())
                .setPayload(payload)
                .setEventListener(new BootpayEventListener() {
                    @Override
                    public void onCancel(String data) {
                        Log.d("cancel", data);
                    }

                    @Override
                    public void onError(String data) {
                        Log.d("error", data);
                    }

                    @Override
                    public void onClose(String data) {
                        Log.d("close", data);
                        Bootpay.dismissWindow();
                    }

                    @Override
                    public void onIssued(String data) {
                        Log.d("issued", data);
                    }

                    @Override
                    public boolean onConfirm(String data) {
                        Log.d("confirm", data);
                        //Bootpay.transactionConfirm(data); //재고가 있어서 결제를 진행하려 할때 true (방법 1)
                        return true; //재고가 있어서 결제를 진행하려 할때 true (방법 2)
//                        return false; //결제를 진행하지 않을때 false

                    }

                    @Override
                    public void onDone(String data) {
                        Log.d("done", data);
                        Intent intent = new Intent(NativeActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                }).requestPayment();
    }
}