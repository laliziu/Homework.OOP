package view;

import presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    Presenter getPresenter();

    void repeatLine();
}
