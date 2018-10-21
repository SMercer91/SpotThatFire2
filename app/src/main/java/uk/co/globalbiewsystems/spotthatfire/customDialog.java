package uk.co.globalbiewsystems.spotthatfire;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.support.v4.app.Fragment;

public class customDialog extends Dialog implements
        View.OnClickListener {

    public Activity c;
    public Dialog d;
    public Button help;
    private Dialog.OnClickListener callback;

    public customDialog(@NonNull Context context) {
        super(context);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.customdialog);
        callback = (Dialog.OnClickListener) getOwnerActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
        }
        dismiss();
    }
}
