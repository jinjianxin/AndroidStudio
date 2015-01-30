package pm.sp.com.swipelistview;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;

public class SwipeActivity extends Activity
{
    private EnhancedListView m_lisView = null;

    private static final String PREF_UNDO_STYLE = "de.timroes.android.listviewdemo.UNDO_STYLE";
    private static final String PREF_SWIPE_TO_DISMISS = "de.timroes.android.listviewdemo.SWIPE_TO_DISMISS";
    private static final String PREF_SWIPE_DIRECTION = "de.timroes.android.listviewdemo.SWIPE_DIRECTION";
    private static final String PREF_SWIPE_LAYOUT = "de.timroes.android.listviewdemo.SWIPE_LAYOUT";

    MyAdapter adapter = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        m_lisView = (EnhancedListView) findViewById(R.id.lisView);

        adapter = new MyAdapter(getApplicationContext());
        m_lisView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        m_lisView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub

            }


        });
        m_lisView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                // TODO Auto-generated method stub
                return true;
            }
        });

        /*
        m_lisView.setDismissCallback(new OnDismissCallback() {

            @Override
            public Undoable onDismiss(EnhancedListView listView, int position) {
                // TODO Auto-generated method stub
                final String item = (String) adapter.getItem(position);
                //  adapter.remove(position);
                return new EnhancedListView.Undoable() {
                    @Override
                    public void undo() {
                        //adapter.insert(position, item);
                    }
                };
            }
        }); */

        m_lisView.setDismissCallback(new EnhancedListView.OnDismissCallback() {
            @Override
            public EnhancedListView.Undoable onDismiss(EnhancedListView listView, int position) {
                return  null;
            }
        });

        setListView();

    }

    private void setListView()
    {
        getPreferences(MODE_PRIVATE).edit().putBoolean(PREF_SWIPE_TO_DISMISS, true).commit();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);


        EnhancedListView.UndoStyle style;
        switch(prefs.getInt(PREF_UNDO_STYLE, 0)) {
            default: style = EnhancedListView.UndoStyle.SINGLE_POPUP; break;
            case 1: style = EnhancedListView.UndoStyle.MULTILEVEL_POPUP; break;
            case 2: style = EnhancedListView.UndoStyle.COLLAPSED_POPUP; break;
        }
        //m_lisView.setUndoStyle(style);

        m_lisView.setSwipeDirection(EnhancedListView.SwipeDirection.BOTH);
        m_lisView.enableSwipeToDismiss();



    }
}