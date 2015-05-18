package dizhao.dodutch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import dizhao.dodutch.R;
import dizhao.dodutch.adapter.base.AdapterBase;
import dizhao.dodutch.controls.SlideMenuItem;
import dizhao.dodutch.controls.SlideMenuView;

/**
 * Created by Di on 15/05/2015.
 */
public class AdapterSlideMenu extends AdapterBase {


    private class Holder {
        //ImageView ivItem;
        TextView tvSlideItem;

    }


    public AdapterSlideMenu(Context p_Context, List p_List){
        super(p_Context,p_List);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder _Holder ;

        if (convertView == null) {
            convertView = super.getLayoutInflater().inflate(R.layout.slidemenu_list_item, null);
            _Holder = new Holder();
            _Holder.tvSlideItem = (TextView) convertView.findViewById(R.id.tvSlide);
            convertView.setTag (_Holder);
        }
        else {
            _Holder = (Holder)convertView.getTag();
        }

        SlideMenuItem _Item =(SlideMenuItem)getList().get(position);
        _Holder.tvSlideItem.setText(_Item.getTitle());

        return convertView;
    }
}
