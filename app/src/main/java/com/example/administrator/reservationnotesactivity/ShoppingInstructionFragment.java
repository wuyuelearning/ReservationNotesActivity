package com.example.administrator.reservationnotesactivity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by Administrator on 2017/8/28.
 */

/**
 * 购物说明页面，由ListView组成，每一个Iitem中包含：题目，地点，时间，商品，其他。
 */


public class ShoppingInstructionFragment extends Fragment {
    private ListView lv_shopping_instrction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.holiday_shopping_instruction_fragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        lv_shopping_instrction = (ListView) view.findViewById(R.id.shopping_instruction_listview);
//        lv_shopping_instrction.setDivider(getResources().);
        initListView();
    }

    private void initListView() {
        List<Map<String, String>> list = getData();
        SimpleAdapter simpleAdapter = getAdapter(list);
        lv_shopping_instrction.setAdapter(simpleAdapter);
    }

    private SimpleAdapter getAdapter(List<Map<String, String>> list) {
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), list, R.layout.item_shopping_instruction, new String[]{"title", "place", "time", "goods", "others"},
                new int[]{R.id.shopping_instruction_title_tv, R.id.shopping_instruction_place_tv, R.id.shopping_instruction_time_tv,
                        R.id.shopping_instruction_goods_tv, R.id.shopping_instruction_others_tv});
        return simpleAdapter;
    }


    public List<Map<String, String>> getData() {
        List<Map<String, String>> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("title", "title" + i);
            map.put("place", "place" + i);
            map.put("time", "time" + i);
            map.put("goods", "goods" + i);
            map.put("others", "others" + i);
            list.add(map);
        }

        //    Log.d("++++++",""+list);

        return list;
    }
}
