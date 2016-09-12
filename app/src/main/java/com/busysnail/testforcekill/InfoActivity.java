package com.busysnail.testforcekill;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InfoActivity extends BaseActivity {
    TextView textView;

    @Override
    protected void setupContentView() {
        setContentView(R.layout.activity_info);
    }

    @Override
    protected void setupView() {
        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void setupData(Bundle savedInstanceState) {
        textView.setText(MyApplication.list.get(0));
    }

}
