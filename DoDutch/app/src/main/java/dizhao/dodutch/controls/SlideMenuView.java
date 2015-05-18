package dizhao.dodutch.controls;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import dizhao.dodutch.R;
import dizhao.dodutch.adapter.AdapterSlideMenu;

/**
 * Created by Di on 18/05/2015.
 */
public class SlideMenuView {

    private Activity m_Activity;
    private List m_MenuList; //数据源变量
    private boolean m_IsClose;
    private RelativeLayout m_layBottomBox;

    public SlideMenuView(Activity p_Activity) {
        m_Activity = p_Activity;
        InitView();
        InitVariable();
        InitListeners();
    }

    public void InitVariable(){
        m_MenuList = new ArrayList();
        m_IsClose = true ;
    }
    public void InitView(){
        m_layBottomBox =(RelativeLayout) m_Activity.findViewById(R.id.includeBottomBox);
    }
    public void InitListeners(){
        m_layBottomBox.setOnClickListener(new onSlideMenuClick());
    }

    private void Open(){
        //动态调整布局
        RelativeLayout.LayoutParams _LayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        _LayoutParams.addRule(RelativeLayout.BELOW,R.id.includeTopTitle);
        m_layBottomBox.setLayoutParams(_LayoutParams);
        m_IsClose = false ;
    }
    private void Close(){
        RelativeLayout.LayoutParams _LayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,136);
        _LayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        m_layBottomBox.setLayoutParams(_LayoutParams);
        m_IsClose = true;
    }
    //判断当前开还是关，如果是关就开，如果是开就关。
    private void Toggle(){
        if (m_IsClose) Open();
        else Close();
    }

    public void Add( SlideMenuItem p_SlideMenuItem){
       m_MenuList.add(p_SlideMenuItem);
    }

    public void BindList(){
        AdapterSlideMenu _AdapterSlideMenu = new AdapterSlideMenu(m_Activity,m_MenuList);
        ListView _ListView = (ListView) m_Activity.findViewById(R.id.lvSlideList);
        _ListView.setAdapter(_AdapterSlideMenu);
       // _ListView.setOnClickListener(new onSlideMenuItemClick());

    }
    private class onSlideMenuClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
              Toggle();
        }
    }

    private class onSlideMenuItemClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
             Toggle();
        }
    }

}
