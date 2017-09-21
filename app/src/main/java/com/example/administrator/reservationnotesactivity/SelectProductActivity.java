package com.example.administrator.reservationnotesactivity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * 选择产品页Activity界面，用于显示预定须知的内容
 * 由三个Fragment组成：出行警示、费用说明、退改规则
 */


public class SelectProductActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView bt_cost_detail;            //费用说明
    private TextView bt_trip_warning;       //出行警示
    private TextView bt_refund_rule;        //  退改规则
    private FragmentManager fm_reservation_notes;
    private FragmentTransaction ft_reservation_notes;
    private Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //没有Tab
//        setContentView(R.layout.select_product_activity);
//        initView();
//        initFragment();
//        setListener();

        //有tab
        setContentView(R.layout.select_product_tab_activity);
        initTabView();

    }


    /**
     * 添加TabLayout 和 ViewPaper
     * 可设置fragment之间可滑动性，
     */

    private void initTabView() {

        bundle = new Bundle();
        bundle.putString("include", "1");
        bundle.putString("not include", "2");

        ArrayList<String> list_tab_title = new ArrayList<>();     // 添加Tab的标题
        list_tab_title.add("出行警示");
        list_tab_title.add("费用说明");
        list_tab_title.add("退改规则");
        ArrayList<Fragment> list_fragment = new ArrayList<>();  // 添加Fragment


        list_fragment.add(new TripWarningFragment());
        list_fragment.add(new CostDetailedFragment(bundle));
        list_fragment.add(new RefundRuleFragment());

        TabLayout tab_reservation_notes = (TabLayout) findViewById(R.id.select_product_tab);          //     关联xml文件中布局
        MyTabViewPager vp_reservation_notes = (MyTabViewPager) findViewById(R.id.select_product_viewpaper);
        MyTabAdapter myTabAdapter = new MyTabAdapter(getSupportFragmentManager(), list_fragment,list_tab_title);    //   声明、实例化适配器
        vp_reservation_notes.setCanScroll(true);                     //设置tab不能滑动  ，默认为可以滑动
        vp_reservation_notes.setAdapter(myTabAdapter);                                                                //   在ViewPaper中添加适配器
        tab_reservation_notes.setupWithViewPager(vp_reservation_notes, true);                                        //     在tablayout 中添加 viewpaper
        tab_reservation_notes.setTabsFromPagerAdapter(myTabAdapter);                                                 //    在TabLayout中添加 是适配器
    }

    /**
     * 没有添加TabLayout 和 ViewPaper
     * fragment之间点击tab切换
     * 默认为出行警示页面
     */

    private void initFragment() {
        fm_reservation_notes = getSupportFragmentManager();
        ft_reservation_notes = fm_reservation_notes.beginTransaction();
        ft_reservation_notes.replace(R.id.select_product_fragment, new TripWarningFragment());
        setTextColor(bt_trip_warning, bt_cost_detail, bt_refund_rule);
        ft_reservation_notes.commit();
    }

    private void initView() {
        bt_cost_detail = (TextView) findViewById(R.id.bt_cost_detail);
        bt_trip_warning = (TextView) findViewById(R.id.bt_trip_warning);
        bt_refund_rule = (TextView) findViewById(R.id.bt_refuned_rule);
    }

    private void setListener() {
        bt_trip_warning.setOnClickListener(this);
        bt_cost_detail.setOnClickListener(this);
        bt_refund_rule.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        fm_reservation_notes = getSupportFragmentManager();
        ft_reservation_notes = fm_reservation_notes.beginTransaction();

        switch (view.getId()) {
            case R.id.bt_trip_warning:
                ft_reservation_notes.replace(R.id.select_product_fragment, new TripWarningFragment());
                setTextColor(bt_trip_warning, bt_cost_detail, bt_refund_rule);
                break;
            case R.id.bt_cost_detail:
                ft_reservation_notes.replace(R.id.select_product_fragment, new CostDetailedFragment(bundle));
                setTextColor(bt_cost_detail, bt_trip_warning, bt_refund_rule);
                break;
            case R.id.bt_refuned_rule:
                ft_reservation_notes.replace(R.id.select_product_fragment, new RefundRuleFragment());
                setTextColor(bt_refund_rule, bt_trip_warning, bt_cost_detail);
                break;
            default:
                break;
        }
        ft_reservation_notes.commit();
    }

    /**
     * 传入的第一个参数为当前tab，显示不同的颜色，第二个第三个参数对应的tab颜色相同
     */
    private void setTextColor(TextView press, TextView unpress1, TextView unpress2) {
        press.setTextColor(getResources().getColor(R.color.color_333333));
        unpress1.setTextColor(getResources().getColor(R.color.color_666666));
        unpress2.setTextColor(getResources().getColor(R.color.color_666666));
    }

}
