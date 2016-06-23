package bigsong.app.firstcode.chapter04;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import bigsong.app.firstcode.R;
import bigsong.app.firstcode.chapter04.fragment.AnotherRightFragment;
import bigsong.app.firstcode.chapter04.fragment.RightFragment;

/**
 * Created by Administrator on 2016/6/23.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter04_main);
        Button fragmentLeftBtn = (Button) findViewById(R.id.btn_04_fragment_left);
        fragmentLeftBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_04_fragment_left:
                AnotherRightFragment newFragment = new AnotherRightFragment();
                FragmentManager manager = getSupportFragmentManager();
                RightFragment rightFragment = (RightFragment) manager.findFragmentById(R.id.fragment_04_right);
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.layout_04_right, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            default:
                break;
        }
    }
}
