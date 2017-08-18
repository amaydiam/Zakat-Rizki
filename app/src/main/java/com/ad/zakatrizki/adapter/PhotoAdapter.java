package com.ad.zakatrizki.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ad.zakatrizki.R;
import com.ad.zakatrizki.model.Photo;
import com.ad.zakatrizki.utils.ApiHelper;
import com.ad.zakatrizki.widget.RobotoBoldTextView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import agency.tango.android.avatarview.loader.PicassoLoader;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> implements View.OnTouchListener, View.OnClickListener {

    public final ArrayList<Photo> data;
    private final GestureDetector gestureDetector;
    private final PicassoLoader imageLoader;
    GradientDrawable bgShape = new GradientDrawable();
    private Activity activity;
    private OnPhotoItemClickListener OnPhotoItemClickListener;


    public PhotoAdapter(Activity activity, ArrayList<Photo> photoList) {
        this.activity = activity;
        this.data = photoList;
        gestureDetector = new GestureDetector(activity, new SingleTapConfirm());
        imageLoader = new PicassoLoader();

    }

    public void setOnPhotoItemClickListener(OnPhotoItemClickListener onPhotoItemClickListener) {
        this.OnPhotoItemClickListener = onPhotoItemClickListener;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        final int viewId = v.getId();
        if (viewId == R.id.btn_action) {
            if (gestureDetector.onTouchEvent(event)) {
                if (OnPhotoItemClickListener != null) {
                    AudioManager audioManager = (AudioManager) activity.getSystemService(Context.AUDIO_SERVICE);
                    audioManager.playSoundEffect(SoundEffectConstants.CLICK);
                    OnPhotoItemClickListener.onActionClick(v, (Integer) v.getTag());
                }
            }
        }

        return false;
    }

    @Override
    public void onClick(View v) {
        if (OnPhotoItemClickListener != null) {
            OnPhotoItemClickListener.onRootClick(v, (Integer) v.getTag());
        }
    }


    public void delete_all() {
        int count = getItemCount();
        if (count > 0) {
            data.clear();
            notifyDataSetChanged();
        }

    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_photo_list, parent, false);
        ViewHolder holder = new ViewHolder(v);
        holder.rootParent.setOnClickListener(this);
        return holder;
    }

    public void onBindViewHolder(final ViewHolder holder, int position) {
        Photo photo = data.get(position);

        Log.v("foto",ApiHelper.getBaseUrl(activity)+photo.getPhoto());
        Glide.with(activity)
                .load(ApiHelper.getBaseUrl(activity)+photo.getPhoto())
                .asBitmap()
                .placeholder(R.drawable.default_placeholder)
                .override(200, 200)
                .centerCrop()
                .into(holder.photo);
        holder.captionPhoto.setText(photo.getCaption_photo());
        holder.captionPhoto.setVisibility(View.GONE);

        holder.rootParent.setTag(position);

    }

    public int getItemCount() {
        return data.size();
    }

    /**
     * Here is the key method to apply the animation
     */

    public void remove(int position) {
        data.remove(data.get(position));
        notifyDataSetChanged();
    }



    public interface OnPhotoItemClickListener {
        void onActionClick(View v, int position);

        void onRootClick(View v, int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.photo)
        ImageView photo;
        @BindView(R.id.caption_photo)
        RobotoBoldTextView captionPhoto;
        @BindView(R.id.root_parent)
        CardView rootParent;
        public ViewHolder(View vi) {
            super(vi);
            ButterKnife.bind(this, vi);

        }

    }

    private class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            return true;
        }


    }

}
