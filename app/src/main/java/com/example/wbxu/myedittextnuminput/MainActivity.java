package com.example.wbxu.myedittextnuminput;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View view) {
        final LemonDialog lemonDialog = new LemonDialog(this, LemonDialog.dialogTypes.ACTIVITYCODE.name());
        lemonDialog.show();
        lemonDialog.setConfirmClickListener(new LemonDialog.ConfirmClickListener() {
            @Override
            public void confirmClick() {
                if (!TextUtils.isEmpty(lemonDialog.getActivityCode())) {
                    Toast.makeText(MainActivity.this, "活动码为：" + lemonDialog.getActivityCode(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
