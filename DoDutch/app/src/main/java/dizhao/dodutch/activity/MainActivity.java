package dizhao.dodutch.activity;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import dizhao.dodutch.R;
import dizhao.dodutch.activity.base.ActivityFrame;
import dizhao.dodutch.adapter.AdapterAppGrid;


public class MainActivity extends ActivityFrame {

    private GridView gvAppGrid ;
    private AdapterAppGrid mAdapterAppGrid ;


    public void InitVariable () {
     mAdapterAppGrid = new AdapterAppGrid(this);
    }

    public void InitView(){
     gvAppGrid = (GridView)findViewById(R.id.gvAppGrid);
    }

    //public void InitListener(){  }

    //绑定数据
    public void BindData(){
      gvAppGrid.setAdapter(mAdapterAppGrid);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       AddMainBody(R.layout.main_body);
        InitVariable();
        InitView();
       // InitListener();
        BindData();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
