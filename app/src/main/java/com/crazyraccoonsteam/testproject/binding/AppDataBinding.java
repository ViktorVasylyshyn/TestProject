package com.crazyraccoonsteam.testproject.binding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AppDataBinding {

    private AppDataBinding(){

    }

    @BindingAdapter("android:src")
    public static void loadImage(ImageView view, String url) {
        if (url != null) {
            Glide.with(view.getContext()).load(url)
                    .into(view);
        }
    }
}
