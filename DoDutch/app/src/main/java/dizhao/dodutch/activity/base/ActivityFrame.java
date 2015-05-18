package dizhao.dodutch.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import dizhao.dodutch.R;
import dizhao.dodutch.controls.SlideMenuItem;
import dizhao.dodutch.controls.SlideMenuView;

/**
 * Created by Di on 15/05/2015.
 */
public class ActivityFrame extends ActivityBase {

    private SlideMenuView m_SlideMenuView;

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

    protected void CreateSlideMenu (int pResID){
        m_SlideMenuView = new SlideMenuView(this);
        String[] _MenuItemArray = getResources().getStringArray(pResID);

        for (int i = 0; i <_MenuItemArray.length;i++)
        {
            SlideMenuItem _Item = new SlideMenuItem(i,_MenuItemArray[i]);
            m_SlideMenuView.Add(_Item);
        }

        m_SlideMenuView.BindList();
    }
}

