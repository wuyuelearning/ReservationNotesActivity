package com.example.administrator.reservationnotesactivity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Administrator on 2017/8/21.
 */

/**
 * 出行警告
 */

public class TripWarningFragment extends Fragment {

    public View onCreateView(LayoutInflater layoutInflater , ViewGroup viewGroup, Bundle savedinstanceState){
        View view =layoutInflater.inflate(R.layout.holiday_trip_warning_fragment,null);
        initFragment(view);
        return  view;
    }

    private void initFragment(View view) {

    }
}
