package com.example.administrator.reservationnotesactivity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/21.
 */

/**
 * 退改须知
 */

public class RefundRuleFragment extends Fragment {
    private TextView refund_rule_tv;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle saveInstanceState) {
        View view = layoutInflater.inflate(R.layout.holiday_refund_rule_fragment, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        refund_rule_tv = (TextView) view.findViewById(R.id.refund_rule_tv);
        refund_rule_tv.setText("1.旅游者在行程开始前7日以内提出解除合同或者按照本合同第十二条第2款约定由旅行社在行程开始前解除合同的，按下列标准扣除必要的费用\n" +
                " \n" +
                "2.行程开始前6日至4日，按旅游费用总额的20%；\n" +
                " \n" +
                "3.行程开始前3日至1日，按旅游费用总额的40%；\n" +
                " \n" +
                "4.行程开始当日，按旅游费用总额的60%\n" +
                " \n" +
                "5.如按上述比例支付的业务损失费不足以赔偿组团社的实际损失，旅游者应当按实际损失对组团社予以赔偿，但最高额不应当超过旅游费用总额\n" +
                " \n" +
                "5.游客转让：出行前，在符合办理团队签证或签注期限或其他条件许可情况下，旅游者可以向组团社书面提出将其自身在本合同中的权利和义务转让给符合出游条件的第三人；并且由第三人与组团社重新签订合同；因此增加的费用由旅游者或第三人承担，减少的费用由组团社退还旅游者\n" +
                " \n" +
                "6.此为特卖商品，若机票一经开出，不做任何退改签，费用全损！");

    }

}
