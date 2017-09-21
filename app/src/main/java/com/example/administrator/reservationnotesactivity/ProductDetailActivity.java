package com.example.administrator.reservationnotesactivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/4.
 */


/**
 * 产品详情页的费用说明 ：退改须知、出行警示、购物说明、推荐项目
 */
public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_refund_rule;            //退改规则
    private TextView tv_trip_warning;       //出行警示
    private TextView tv_shopping_instruction;        //  购物说明
    private TextView tv_recommend_project;                //   推荐项目
    private FragmentManager fm_reservation_notes;
    private FragmentTransaction ft_reservation_notes;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.product_detail_tab_activity);
//        initTabView();



        setContentView(R.layout.product_detail_activity);
        Intent intent=getIntent();
        int tabnumber=intent.getIntExtra("product_detail_tab",-1);
        initView();
        initFragment(tabnumber);
        setLister();
    }

/**
 * tab通过 MyTabAdapter完成点击
 */


    private void initTabView() {
        ArrayList<String> list_tab_title = new ArrayList<>();     // 添加Tab的标题
        list_tab_title.add("退改说明");
        list_tab_title.add("出行警示");
        list_tab_title.add("购物说明");
        list_tab_title.add("推荐项目");

        ArrayList<Fragment> list_fragment = new ArrayList<>();  // 添加Fragment


        list_fragment.add(new RefundRuleFragment());
        list_fragment.add(new TripWarningFragment());
        list_fragment.add(new ShoppingInstructionFragment());
        list_fragment.add(new RecommendProjectFragment());

        TabLayout tab_reservation_notes = (TabLayout) findViewById(R.id.product_detail_tab);          //     关联xml文件中布局
        MyTabViewPager vp_reservation_notes = (MyTabViewPager) findViewById(R.id.product_detail_viewpaper);
        MyTabAdapter myTabAdapter = new MyTabAdapter(getSupportFragmentManager(), list_fragment,list_tab_title);    //   声明、实例化适配器
        vp_reservation_notes.setCanScroll(false);                     //设置tab不能滑动  ，默认为可以滑动
        vp_reservation_notes.setAdapter(myTabAdapter);                                                                //   在ViewPaper中添加适配器
        tab_reservation_notes.setupWithViewPager(vp_reservation_notes, true);                                        //     在tablayout 中添加 viewpaper
        tab_reservation_notes.setTabsFromPagerAdapter(myTabAdapter);                                                 //    在TabLayout中添加 是适配器

    }

    /**
     * tab通过Textview完成，点击切换
     *
     */

    private void initView() {
        tv_refund_rule = (TextView) findViewById(R.id.tv_refund_rule);
        tv_trip_warning = (TextView) findViewById(R.id.tv_trip_warning);
        tv_shopping_instruction = (TextView) findViewById(R.id.tv_shopping_instruction);
        tv_recommend_project = (TextView) findViewById(R.id.tv_recommend_project);
    }

    /**初始化 fragment
     *
     * @param tabnumber   根据点击的按钮，初始化对应的fragment
     */

    private void initFragment(int tabnumber) {

        fm_reservation_notes = getSupportFragmentManager();
        ft_reservation_notes = fm_reservation_notes.beginTransaction();
        switch(tabnumber){
            case 0:
                ft_reservation_notes.replace(R.id.product_detail_fragment,new RefundRuleFragment());

                setTextColor(tv_refund_rule,tv_trip_warning,tv_shopping_instruction,tv_recommend_project);
                break;
            case 1:
                ft_reservation_notes.replace(R.id.product_detail_fragment,new TripWarningFragment());
                setTextColor(tv_trip_warning,tv_refund_rule,tv_shopping_instruction,tv_recommend_project);
                break;
            case 2:
                ft_reservation_notes.replace(R.id.product_detail_fragment,new ShoppingInstructionFragment());
                setTextColor(tv_shopping_instruction,tv_refund_rule,tv_trip_warning,tv_recommend_project);
                break;
            case 3:
                ft_reservation_notes.replace(R.id.product_detail_fragment,new RecommendProjectFragment());
                setTextColor(tv_recommend_project,tv_shopping_instruction,tv_refund_rule,tv_trip_warning);
                break;
            default:
                break;
        }
        ft_reservation_notes.commit();
    }

    private void setLister(){
        tv_refund_rule.setOnClickListener(this);
        tv_trip_warning.setOnClickListener(this);
        tv_shopping_instruction.setOnClickListener(this);
        tv_recommend_project.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        fm_reservation_notes = getSupportFragmentManager();
        ft_reservation_notes = fm_reservation_notes.beginTransaction();
        switch (v.getId()) {
            case R.id.tv_refund_rule:
                ft_reservation_notes.replace(R.id.product_detail_fragment, new RefundRuleFragment());
                setTextColor(tv_refund_rule,tv_trip_warning,tv_shopping_instruction,tv_recommend_project);
                break;
            case R.id.tv_trip_warning:
                ft_reservation_notes.replace(R.id.product_detail_fragment, new TripWarningFragment());
                setTextColor(tv_trip_warning,tv_refund_rule,tv_shopping_instruction,tv_recommend_project);
                break;
            case R.id.tv_shopping_instruction:
                ft_reservation_notes.replace(R.id.product_detail_fragment,new ShoppingInstructionFragment());
                setTextColor(tv_shopping_instruction,tv_refund_rule,tv_trip_warning,tv_recommend_project);
                break;
            case R.id.tv_recommend_project:
                ft_reservation_notes.replace(R.id.product_detail_fragment,new RecommendProjectFragment());
                setTextColor(tv_recommend_project,tv_shopping_instruction,tv_refund_rule,tv_trip_warning);
                break;
            default:
                break;
        }
        ft_reservation_notes.commit();

    }

    /**
     * 传入的第一个参数为当前tab，显示不同的颜色，第二个第三个第四个参数对应的tab颜色相同
     */

    private void setTextColor(TextView press, TextView unpress1, TextView unpress2,TextView unpress3) {
        press.setTextColor(getResources().getColor(R.color.color_333333));
        unpress1.setTextColor(getResources().getColor(R.color.color_666666));
        unpress2.setTextColor(getResources().getColor(R.color.color_666666));
        unpress3.setTextColor(getResources().getColor(R.color.color_666666));

    }
}
