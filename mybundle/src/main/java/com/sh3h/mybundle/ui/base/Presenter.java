package com.sh3h.mybundle.ui.base;

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
