package pm.sp.com.tabactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by jjx on 15-1-29.
 */
public class ColorPickerActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.color_picker_layout);
    }
}
