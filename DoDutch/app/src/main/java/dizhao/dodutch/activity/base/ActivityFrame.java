package dizhao.dodutch.activity.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import dizhao.dodutch.R;

/**
 * Created by Di on 15/05/2015.
 */
public class ActivityFrame extends ActivityBase {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //动态加载资源布局
    protected void AddMainBody(int pResID) {
        LinearLayout _MainBody = (LinearLayout) findViewById(R.id.layMainBody);
        View _View = LayoutInflater.from(this).inflate(pResID,null);
        RelativeLayout.LayoutParams _LayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        _MainBody.addView(_View,_LayoutParams);

    }
}

