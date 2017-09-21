package com.example.administrator.reservationnotesactivity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/28.
 */

/**
 * 推荐项目界面，包含：ListView：题目、地点、时间、费用。TextView：温馨提示
 */

public class RecommendProjectFragment extends Fragment {
    private ExpandListView lv_recommend_projects;
    private TextView tv_recommend_projects_tips;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.holiday_recommend_projects_fragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        lv_recommend_projects = (ExpandListView) view.findViewById(R.id.recommend_projects_listview);
        tv_recommend_projects_tips = (TextView) view.findViewById(R.id.recommend_projects_tips_tv);
        initTextView();
        initListView();
    }

    private void initTextView() {
        tv_recommend_projects_tips.setText("1.以上内容属推荐项目，游客可在自由活动期间自愿选择。\n" +
                " \n" +
                "2.请跟团的游客在自由活动期间购物或参加活动时，注意遵守导游/领队规定的集合时间。\n" +
                " \n" +
                "3.自由活动期间的购物或相关活动为游客自愿参加，请您注意保留凭证及游玩安全。");
    }

    private void initListView() {
        List<Map<String, String>> list = getData();
        SimpleAdapter adapter = getAdapter(list);
        lv_recommend_projects.setAdapter(adapter);

    }

    private SimpleAdapter getAdapter(List<Map<String, String>> list) {
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), list, R.layout.item_recommend_projects, new String[]{"title", "place", "cost", "time"},
                new int[]{R.id.recommend_projects_titles_tv, R.id.recommend_projects_place_tv, R.id.recommend_projects_cost_tv, R.id.recommend_projects_time_tv});
        return simpleAdapter;

    }


    private List<Map<String, String>> getData() {
        List<Map<String, String>> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("title", "title" + i);
            map.put("place", "place" + i);
            map.put("cost", " cost" + i);
            map.put("time", "time" + i);
            list.add(map);
        }
        return list;

    }

}
