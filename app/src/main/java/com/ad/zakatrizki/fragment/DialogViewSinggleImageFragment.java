package com.ad.zakatrizki.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ad.zakatrizki.R;
import com.ad.zakatrizki.Zakat;
import com.ad.zakatrizki.widget.RobotoLightTextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.joanzapata.iconify.widget.IconTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class DialogViewSinggleImageFragment extends DialogFragment {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.loading)
    ProgressBar loading;
    @BindView(R.id.btn_close)
    IconTextView btnClose;
    @BindView(R.id.caption_photo)
    RobotoLightTextView captionPhoto;
    private Unbinder unbinder;

    @OnClick(R.id.btn_close)
    void btnClose() {
        dismiss();
    }

    private String photo;
    private String caption_photo;

    public DialogViewSinggleImageFragment() {

    }

    public static DialogViewSinggleImageFragment newInstance(String photo, String caption_photo) {
        DialogViewSinggleImageFragment f = new DialogViewSinggleImageFragment();
        Bundle args = new Bundle();
        args.putString(Zakat.PHOTO, photo);
        args.putString(Zakat.CAPTION_PHOTO, caption_photo);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photo = getArguments().getString(Zakat.PHOTO);
        caption_photo = getArguments().getString(Zakat.CAPTION_PHOTO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_slider, container, false);
       unbinder= ButterKnife.bind(this, view);

        Glide.with(getActivity()).load(photo)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        image.setImageBitmap(resource);
                        loading.setVisibility(View.GONE);
                    }
                });

        captionPhoto.setText(caption_photo);

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}