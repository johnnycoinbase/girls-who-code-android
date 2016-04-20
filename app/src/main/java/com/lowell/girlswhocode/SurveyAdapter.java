package com.lowell.girlswhocode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.lowell.girlswhocode.api.Response;
import com.lowell.girlswhocode.api.Survey;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by johnnychan on 4/17/16.
 */
public class SurveyAdapter extends RecyclerView.Adapter<SurveyAdapter.ViewHolder> {
    private Context mContext;
    List<Survey> mSurveys;
    RoundedBitmapDrawable placeholderDrawable;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context mContext;

        @Bind(R.id.survey_title_text_view)
        TextView surveyTitleTv;

        @Bind(R.id.user_image_view)
        ImageView userImageView;

        public ViewHolder(Context context, View view) {
            super(view);

            ButterKnife.bind(this, view);

            mContext = context;
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            Survey survey = mSurveys.get(position);

            Intent intent = new Intent(mContext, SurveyActivity.class);
            mContext.startActivity(intent);
        }
    }

    public SurveyAdapter(Context context, List<Survey> surveys) {
        mContext = context;
        mSurveys = surveys;

        Bitmap resource = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.user_profile_empty);
        placeholderDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
        placeholderDrawable.setCircular(true);
    }

    @Override
    public SurveyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_survey, parent, false);

        ViewHolder vh = new ViewHolder(context, v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final SurveyAdapter.ViewHolder viewHolder, int position) {
        Survey survey = mSurveys.get(position);

        viewHolder.surveyTitleTv.setText(survey.getSurveyQuestion());

        String profileURL = null;
//        if (survey.getProfileUrl() != null) {
//            profileURL = survey.getProfileUrl();
//        }

        Glide.with(mContext).load(profileURL).asBitmap().centerCrop()
                .placeholder(placeholderDrawable).into(new BitmapImageViewTarget(viewHolder.userImageView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                viewHolder.userImageView.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSurveys.size();
    }
}
