package com.example.administrator.reservationnotesactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/4.
 */

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView tv_select_product;//  跳转到选择产品页的费用须知
    private TextView tv_refund_rule;   //    跳转到产品详情页的退改规则
    private TextView tv_trip_warning;  // 跳转到产品详情页的出行警告
    private TextView tv_shopping_instruction;  // 跳转到产品详情页的购物说明
    private TextView tv_recommend_project;   // 跳转到产品详情页的推荐项目


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        intView();
        setLisnter();
    }

    private void intView() {
        tv_select_product = (TextView) findViewById(R.id.to_select_products_tv);
        tv_refund_rule = (TextView) findViewById(R.id.to_refund_rule_tv);
        tv_trip_warning = (TextView) findViewById(R.id.to_trip_warning_tv);
        tv_shopping_instruction = (TextView) findViewById(R.id.to_shopping_instruction_tv);
        tv_recommend_project = (TextView) findViewById(R.id.to_recommend_project_tv);
    }
    private void setLisnter() {
        tv_select_product.setOnClickListener(this);
        tv_refund_rule.setOnClickListener(this);
        tv_trip_warning.setOnClickListener(this);
        tv_shopping_instruction.setOnClickListener(this);
        tv_recommend_project.setOnClickListener(this);

    }

    /**
     * 点击定位
     * @param tabId   监听点击
     * @return    返回对应编号
     */

    private int getIndex(int tabId) {
        switch (tabId) {
            case R.id.to_refund_rule_tv:
                return 0;
            case R.id.to_trip_warning_tv:
                return 1;
            case R.id.to_shopping_instruction_tv:
                return 2;
            case R.id.to_recommend_project_tv:
                return 3;
        }
        return -1;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.to_select_products_tv) {
            Intent intent = new Intent(this, SelectProductActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, ProductDetailActivity.class);
            intent.putExtra("product_detail_tab", getIndex(v.getId()));     //点击定位
            startActivity(intent);
        }
    }
}
