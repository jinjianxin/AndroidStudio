package pm.sp.com.tabactivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


public class MytabActivity extends TabActivity {

    TabHost tabHost;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tab);
        tabHost = getTabHost();
        setTabs();
    }
    private void setTabs()
    {
        addTab("调色", R.drawable.tab_home, ColorPickerActivity.class);
        addTab("管理", R.drawable.tab_group, GroupListActivity.class);
    }
    private void addTab(String labelId, int drawableId, Class<?> c)
    {
        Intent intent = new Intent(this, c);
        intent.putExtra("group", getIntent().getStringExtra("group"));
        TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);

        View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
        TextView title = (TextView) tabIndicator.findViewById(R.id.title);
        title.setText(labelId);
        ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
        icon.setImageResource(drawableId);
        spec.setIndicator(tabIndicator);
        spec.setContent(intent);
        tabHost.addTab(spec);
    }
}
