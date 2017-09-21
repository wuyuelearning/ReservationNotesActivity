package com.example.administrator.reservationnotesactivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/23.
 */

/**
 * 自定义适配器
 */

public class MyTabAdapter extends FragmentPagerAdapter {
    private ArrayList<String> list_tab_title;
    private ArrayList<Fragment> list_fragment;
    private FragmentManager fm_reservation_notes;
    private FragmentTransaction ft_reservation_notes;


    public MyTabAdapter(FragmentManager fragmentManager, ArrayList<Fragment> list_fragment, ArrayList<String> list_tab_title) {
        super(fragmentManager);
        this.list_fragment = list_fragment;
        this.list_tab_title = list_tab_title;
    }


    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_tab_title.get(position);
    }




}
