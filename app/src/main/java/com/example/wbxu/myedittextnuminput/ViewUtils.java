package com.example.wbxu.myedittextnuminput;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * 封装对View的操作
 * Created by dongming on 2017/2/14.
 */
public class ViewUtils {

  public static <T extends View> T inflate(ViewGroup parent, int resId) {
    View view = newInstance(parent, resId);
    if (view != null) {
      return (T) view;
    }
    return null;
  }

  public static View newInstance(ViewGroup parent, int resId) {
    return LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
  }

  public static void setVisibility(View host, int id, int visibility) {
    if (host != null) {
      setVisibility(host.findViewById(id), visibility);
    }
  }

  public static void setVisibility(View view, int visibility) {
    if (view != null) {
      view.setVisibility(visibility);
    }
  }

  public static void setText(View host, int id, String text) {
    if (host != null) {
      setText(host.findViewById(id), text);
    }
  }

  public static void setText(View view, String text) {
    if (view instanceof TextView) {
      ((TextView) view).setText(text);
    }
  }


  public static void setImage(View host, int id, int imageDefault) {
    if (host != null) {
      setImage(host.findViewById(id), imageDefault);
    }
  }

  public static void setImage(View view, int imageDefault) {
    if (view instanceof ImageView) {
      ImageView imageView = (ImageView) view;
      imageView.setImageResource(imageDefault);
    }
  }

  public static void setBackgroundColor(View host, int id, int color) {
    if (host != null) {
      setBackgroundColor(host.findViewById(id), color);
    }
  }

  public static void setBackgroundColor(View view, int color) {
    if (view != null) {
      view.setBackgroundColor(color);
    }
  }

  /**
   * 设置TextView中划线
   * 
   * @param host
   * @param id
   */
  public static void setTextMidDecoration(View host, int id) {
    if (host != null) {
      setTextMidDecoration(host.findViewById(id));
    }
  }

  public static void setTextMidDecoration(View view) {
    if (view instanceof TextView) {
      ((TextView) view).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
    }
  }

  public static void setTextColor(View host, int id, int color) {
    if (host != null) {
      setTextColor(host.findViewById(id), color);
    }
  }

  public static void setTextColor(View view, int color) {
    if (view instanceof TextView) {
      ((TextView) view).setTextColor(color);
    }
  }



  public static void setTypeface(View host, int id, Typeface typeface) {
    if (host != null) {
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        setTypeface(host.findViewById(id), typeface);
      }
    }
  }

  public static void setTypeface(View view, Typeface typeface) {
    if (view instanceof TextView) {
      ((TextView) view).setTypeface(typeface);
    }
  }

  public static void bindClick(View host, int id, View.OnClickListener listener) {
    if (host != null) {
      View view = host.findViewById(id);
      if (view != null) {
        view.setOnClickListener(listener);
      }
    }
  }

  public static void bindClick(View view, View.OnClickListener listener) {
    if (view != null) {
      view.setOnClickListener(listener);
    }
  }

  public static void requestLayout(View host, int id) {
    if (host != null) {
      View view = host;
      if (id > 0) {
        view = host.findViewById(id);
      }
      if (view != null) {
        view.requestLayout();
      }
    }
  }

}

