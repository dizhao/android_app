package dizhao.dodutch.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Di on 15/05/2015.
 */
public class ActivityBase extends Activity {

      protected void ShowMsg(String pMsg){
        Toast.makeText(this,pMsg,Toast.LENGTH_SHORT).show();
    }

    protected void OpenActivity(Class pClass){
        Intent _Intent = new Intent();
        _Intent. setClass(this,pClass);
        startActivity(_Intent);
    }

}
