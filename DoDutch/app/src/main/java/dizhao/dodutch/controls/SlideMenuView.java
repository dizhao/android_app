package dizhao.dodutch.controls;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
    private ListView m_lvSlideList;

    private OnSlideMenuListener m_OnSlideMenuListener;

    public interface OnSlideMenuListener {
        public abstract void onSlideMenuItemClick (View p_View, SlideMenuItem p_SlideMenuItem);
    }

    public SlideMenuView(Activity p_Activity) {

        m_OnSlideMenuListener = (OnSlideMenuListener) p_Activity;
        m_Activity = p_Activity;
        initView();
        initVariable();
        initListeners();
    }

    public void initVariable(){
        m_MenuList = new ArrayList();
        m_IsClose = true ;
    }
    public void initView(){
        m_layBottomBox =(RelativeLayout) m_Activity.findViewById(R.id.includeBottomBox);
        m_lvSlideList = (ListView) m_Activity.findViewById(R.id.lvSlideList);
    }
    public void initListeners(){
        m_layBottomBox.setOnClickListener(new onSlideMenuClick());
        m_lvSlideList.setOnItemClickListener(new onSlideMenuItemClick());
    }

    private void open(){
        //动态调整布局
        RelativeLayout.LayoutParams _LayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        _LayoutParams.addRule(RelativeLayout.BELOW,R.id.includeTopTitle);
        m_layBottomBox.setLayoutParams(_LayoutParams);
        m_IsClose = false ;
    }
    private void close(){
        RelativeLayout.LayoutParams _LayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,136);
        _LayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        m_layBottomBox.setLayoutParams(_LayoutParams);
        m_IsClose = true;
    }
    //判断当前开还是关，如果是关就开，如果是开就关。
    private void toggle(){
        if (m_IsClose) open();
        else close();
    }

    public void add( SlideMenuItem p_SlideMenuItem){
       m_MenuList.add(p_SlideMenuItem);
    }

    public void bindList(){
        AdapterSlideMenu _AdapterSlideMenu = new AdapterSlideMenu(m_Activity,m_MenuList);
        ListView _ListView = (ListView) m_Activity.findViewById(R.id.lvSlideList);
        _ListView.setAdapter(_AdapterSlideMenu);
       // _ListView.setOnClickListener(new onSlideMenuItemClick());

    }
    private class onSlideMenuClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
              toggle();
        }
    }

    private class onSlideMenuItemClick implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              SlideMenuItem _SlideMenuItem = (SlideMenuItem) parent.getItemAtPosition(position);
              m_OnSlideMenuListener.onSlideMenuItemClick(view,_SlideMenuItem);
           //  Toast.makeText(m_Activity,_SlideMenuItem.getTitle(),Toast.LENGTH_SHORT).show();
        }
    }

}
