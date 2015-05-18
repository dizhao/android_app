package dizhao.dodutch.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Di on 18/05/2015.
 */
public abstract class AdapterBase extends BaseAdapter {

    private List m_List;
    private Context m_Context;

    private LayoutInflater m_LayoutInflater;

    public AdapterBase (Context p_Context,List p_List) {
        m_Context = p_Context ;
        m_List = p_List;
        m_LayoutInflater = LayoutInflater.from(m_Context);
    }

    public LayoutInflater getLayoutInflater (){
        return m_LayoutInflater;
    }

    public List getList() {
        return m_List;
    }

    public Context getContext (){
        return m_Context;
    }

    @Override
    public int getCount() {
        return m_List.size();
    }

    @Override
    public Object getItem(int position) {
        return m_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
