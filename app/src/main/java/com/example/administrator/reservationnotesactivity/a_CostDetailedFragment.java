package com.example.administrator.reservationnotesactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/21.
 */

/**
 * 费用说明，使用TableLayout显示具体内容
 */

public class a_CostDetailedFragment extends Fragment {
    private TableLayout tl_cost_detailed_include;
    private TableLayout tl_cost_detailed_not_include;
    private TextView cost_include_table_title;
    private TextView cost_include_table_detail;
    private LinearLayout ll_cost_include;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle saveInstanceState) {
        View view = layoutInflater.inflate(R.layout.a_holiday_cost_detailed_fragment, null);
        tl_cost_detailed_include = (TableLayout) view.findViewById(R.id.cost_include_tablelayout);
        tl_cost_detailed_not_include = (TableLayout) view.findViewById(R.id.cost_not_include_tablelayout);
        initView(view);
        showDetail();

        return view;
    }

//    public a_CostDetailedFragment(Bundle Bundle){
//        showDetail(Bundle bundle);
//    }

    private void initView(View view) {
        cost_include_table_title = (TextView) view.findViewById(R.id.cost_include_table_title);
        cost_include_table_detail = (TextView) view.findViewById(R.id.cost_include_table_detail);
        ll_cost_include = (LinearLayout) view.findViewById(R.id.cost_include_layout);


    }


    public void showDetail() {

        tl_cost_detailed_include.setStretchAllColumns(true);
        tl_cost_detailed_not_include.setStretchAllColumns(true);

        for (int row = 0; row < 5; row++) {
            TableRow tableRow = new TableRow(getActivity());

            for (int col = 0; col < 2; col++) {
                if (col / 2 == 0) {
                    cost_include_table_title.setText("+++++++++++++++++++");
//                    tl_cost_detailed_include.removeAllViewsInLayout();
                    tableRow.addView(cost_include_table_title);
                } else {
                    cost_include_table_detail.setText("----");
//                    tl_cost_detailed_include.removeAllViewsInLayout();
                    tableRow.addView(cost_include_table_detail);
                }

            }
            tl_cost_detailed_include.addView(tableRow, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));

        }

        for (int row = 0; row < 5; row++) {
            TableRow tableRow = new TableRow(getActivity());
            for (int col = 0; col < 2; col++) {
                TextView textView = new TextView(getActivity());
                textView.setText("(" + row + "," + col + ")");
                tableRow.addView(textView);
            }
            tl_cost_detailed_not_include.addView(tableRow, new TableLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }


    }

}
