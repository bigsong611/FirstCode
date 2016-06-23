package bigsong.app.firstcode.chapter04.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bigsong.app.firstcode.R;
import bigsong.app.firstcode.chapter04.MainActivity;

/**
 * Created by Administrator on 2016/6/23.
 */
public class RightFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapter04_right, container, false);
        MainActivity mainActivity = (MainActivity) getActivity();
        return view;
    }
}
