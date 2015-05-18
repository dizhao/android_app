package dizhao.dodutch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import dizhao.dodutch.R;

/**
 * Created by Di on 15/05/2015.
 */
public class AdapterAppGrid extends BaseAdapter {


    private class Holder {
        ImageView ivItem;
        TextView tvItem;

    }

    private Integer[] m_ivItem = {
            R.drawable.item1,
            R.drawable.item2,
            R.drawable.item3,
            R.drawable.item4,
            R.drawable.item5,
            R.drawable.item6,
    };

    private String[] m_tvItem = new String[6];
    private Context m_Context;

    public AdapterAppGrid (Context pContext) {
        m_Context = pContext;
        m_tvItem[0] = pContext.getString(R.string.appGridPayoutAdd);
        m_tvItem[1] = pContext.getString(R.string.appGridPayoutManage);
        m_tvItem[2] = pContext.getString(R.string.appGridStatisticsManage);
        m_tvItem[3] = pContext.getString(R.string.appGridAccountBookManage);
        m_tvItem[4] = pContext.getString(R.string.appGridCategoryManage);
        m_tvItem[5] = pContext.getString(R.string.appGridUserManage);
    }

    @Override
    public int getCount() {
        return m_tvItem.length;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return m_tvItem[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder _Holder ;

        if (convertView == null) {
            LayoutInflater _LayoutInflater = LayoutInflater.from(m_Context);

            convertView = _LayoutInflater.inflate(R.layout.main_body_item,null);
            _Holder = new Holder();
            _Holder.ivItem = (ImageView) convertView.findViewById(R.id.ivItem);
            _Holder.tvItem = (TextView) convertView.findViewById(R.id.tvItem);
            convertView.setTag (_Holder);
        }
        else {
            _Holder = (Holder)convertView.getTag();
        }

        _Holder.ivItem.setImageResource(m_ivItem[position]);
        LinearLayout.LayoutParams _LayoutParams = new LinearLayout.LayoutParams(72,72);
        _Holder.ivItem.setLayoutParams(_LayoutParams);
      // _Holder.ivItem.setScaleType(ImageView.ScaleType.FIT_XY);  //缩放
        _Holder.tvItem.setText(m_tvItem[position]);

        return convertView;
    }
}
