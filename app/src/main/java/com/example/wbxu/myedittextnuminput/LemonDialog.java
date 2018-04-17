package com.example.wbxu.myedittextnuminput;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by xwb on 2018/3/17.
 */

public class LemonDialog extends Dialog implements View.OnClickListener {
  private Context mContext;
  private NumberEditText active_code_edit;
  private TextView dialogTitle, tv_cancel, tv_sure;
  private TextView dialogDescribe; // dialog中间描述
  private ConfirmClickListener mConfirmClickListener;
  private String type;
  private String desString, sureText, cancelText, titleText;
  private LinearLayout ll_active_code_layout;
  private String currentActiveCode;

  public enum dialogTypes {
    ACTIVITYCODE, CHILDEINFO, UPDATAAPK
  }

  public LemonDialog(@NonNull Context context, String type) {
    super(context);
    this.mContext = context;
    this.type = type;
  }

  public interface ConfirmClickListener {
    void confirmClick();
  }

  public void setConfirmClickListener(ConfirmClickListener mConfirmClickListener) {
    this.mConfirmClickListener = mConfirmClickListener;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.new_lemon_dialog);
    // 设置遮罩透明度
    WindowManager.LayoutParams params = getWindow().getAttributes();
    params.dimAmount = 0.7f;
    getWindow().setAttributes(params);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    initView();
  }

  private void initView() {
    tv_cancel = (TextView) findViewById(R.id.tv_cancel);
    tv_sure = (TextView) findViewById(R.id.tv_sure);
    tv_cancel.setOnClickListener(this);
    tv_sure.setOnClickListener(this);
    active_code_edit = (NumberEditText) findViewById(R.id.active_code_edit);
    ll_active_code_layout = (LinearLayout) findViewById(R.id.ll_active_code_layout);
    dialogTitle = (TextView) findViewById(R.id.tv_title);
    dialogDescribe = (TextView) findViewById(R.id.tv_lemon_dialog_describe);
    // 孩子信息
    if (dialogTypes.CHILDEINFO.name().equals(type)) {
      ViewUtils.setVisibility(ll_active_code_layout, View.GONE);
      ViewUtils.setVisibility(dialogDescribe, View.VISIBLE);
    } else if (dialogTypes.UPDATAAPK.name().equals(type)) { // 升级dialog
      ViewUtils.setVisibility(ll_active_code_layout, View.GONE);
      ViewUtils.setVisibility(dialogDescribe, View.VISIBLE);
      dialogDescribe.setText(desString);
    } else if (dialogTypes.ACTIVITYCODE.name().equals(type)) { // 活动码
      ViewUtils.setVisibility(ll_active_code_layout, View.VISIBLE);
      ViewUtils.setVisibility(dialogDescribe, View.GONE);
      active_code_edit.setOnInputFinish(new NumberEditText.OnInputFinishListener() {
        @Override
        public void onInputFinish(String text) {
          currentActiveCode = text;
        }
      });
    }
    if (!TextUtils.isEmpty(sureText)) {
      tv_sure.setText(sureText);
    }
    if (!TextUtils.isEmpty(cancelText)) {
      tv_cancel.setText(cancelText);
    }
    if (!TextUtils.isEmpty(titleText)) {
      dialogTitle.setText(titleText);
    }
  }

  public String getActivityCode() {
    return currentActiveCode;
  }

  public void clearActiveCode() {
    active_code_edit.clearText();
  }

  public void setTitle(String title) {
    titleText = title;
  }

  public void setSureText(String sureText) {
    this.sureText = sureText;
  }

  public void setCancelText(String cancelText) {
    this.cancelText = cancelText;
  }

  public void setDescribeText(String desText) {
    desString = desText;
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.tv_cancel:
        dismiss();
        break;
      case R.id.tv_sure:
        mConfirmClickListener.confirmClick();
        dismiss();
        break;
    }
  }
}
