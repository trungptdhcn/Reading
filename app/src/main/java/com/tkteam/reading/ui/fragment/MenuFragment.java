package com.tkteam.reading.ui.fragment;

import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import com.tkteam.reading.base.BaseFragment;
import com.tkteam.reading.R;
import com.tkteam.reading.base.event.ChangedFragmentEvent;
import de.greenrobot.event.EventBus;

/**
 * Created by Trung on 5/14/2015.
 */
public class MenuFragment extends BaseFragment
{
    @InjectView(R.id.text)
    TextView tvText;

    @Override
    public int getLayout()
    {
        return R.layout.menu_fragment;
    }

    @Override
    public void setupView()
    {
        tvText.setText("Trung dai ca");
    }

    @OnClick(R.id.text)
    public void click()
    {
        EventBus.getDefault().post(new ChangedFragmentEvent(new NewFragment()));
    }
}
