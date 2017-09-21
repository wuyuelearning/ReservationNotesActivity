package com.example.administrator.reservationnotesactivity;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2017/8/22.
 */

/**
 * 费用说明，使用ListView显示具体内容
 */
@SuppressLint("ValidFragment")
public class CostDetailedFragment extends Fragment {
    private ExpandListView lv_cost_detailed_include;
    private ExpandListView lv_cost_detailed_not_include;
     private Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.holiday_cost_detailed_fragment, null);
        initView(view);
        return view;
    }
    public CostDetailedFragment(){}

    public CostDetailedFragment(Bundle bundle){
       this.bundle=bundle;
    }


    private void initView(View view ) {
        lv_cost_detailed_include = (ExpandListView) view.findViewById(R.id.cost_include_listview);
        lv_cost_detailed_not_include = (ExpandListView) view.findViewById(R.id.cost_not_include_listview);
        initListView();
    }

    private void initListView() {
        List<Map<String, String>> cost_include_data = getData(bundle.getString("include"));
        List<Map<String, String>> cost_not_include_data = getData(bundle.getString("not include"));

        SimpleAdapter cost_include_adpter = getAdpter(cost_include_data);
        SimpleAdapter cost_not_include_adaptr = getAdpter(cost_not_include_data);

        lv_cost_detailed_include.setAdapter(cost_include_adpter);
        lv_cost_detailed_not_include.setAdapter(cost_not_include_adaptr);

    }

    private SimpleAdapter getAdpter(List<Map<String, String>> data) {
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), data, R.layout.item_cost_detail, new String[]{"title", "detail"},
                new int[]{R.id.cost_include_item_detail, R.id.cost_include_item_title});
        return simpleAdapter;
    }


    public List<Map<String, String>> getData(String s) {
        List<Map<String, String>> list = new ArrayList<>();


        if (s.equals("1")) {

            for (int i = 0; i < 20; i++) {
                Map<String, String> map = new HashMap<>();
                map.put("title", "+++" + i);
                map.put("detail", "---" + i);
                list.add(map);
            }

        } else if (s.equals("2")) {
            for (int i = 0; i < 20; i++) {
                Map<String, String> map = new HashMap<>();
                map.put("title", "!!!!!!!!!!!!" + i);
                map.put("detail", "**************" + i);
                list.add(map);
            }

        }
        return list;
    }
}
