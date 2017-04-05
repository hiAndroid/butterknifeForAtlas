package com.sh3h.mybundle.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sh3h.mybundle.MyApplication;
import com.sh3h.mybundle.R;
import com.sh3h.mybundle.R2;
import com.sh3h.mybundle.injection.component.ActivityComponent;
import com.sh3h.mybundle.injection.component.DaggerActivityComponent;
import com.sh3h.mybundle.injection.module.ActivityModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FirstActivity extends AppCompatActivity implements FirstMvpView {
    @BindView(R2.id.tv_first)
    TextView mTextView;

    @Inject
    FirstPresenter mFirstPresenter;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        getActivityComponent().inject(this);
        mFirstPresenter.attachView(this);
        mUnbinder = ButterKnife.bind(this);
        mTextView.setText("hello first");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        mFirstPresenter.detachView();
    }

    private ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(MyApplication.get(this).getComponent())
                .build();
    }
}
