package com.lowell.girlswhocode.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lowell.girlswhocode.R;
import com.lowell.girlswhocode.api.survey.Response;
import com.lowell.girlswhocode.api.survey.Survey;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by johnnychan on 4/19/16.
 */
public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceAdapter.ViewHolder> {

    Context mContext;
    Survey mSurvey;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context mContext;

        @Bind(R.id.checkBox)
        CheckBox checkBox;

        @Bind(R.id.tvChoice)
        TextView tvChoice;

        public ViewHolder(Context context, View view) {
            super(view);

            ButterKnife.bind(this, view);

            mContext = context;
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();

            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
                mSurvey.getResponses().get(position).setSelected(false);
            } else {
                checkBox.setChecked(true);
                mSurvey.getResponses().get(position).setSelected(true);
                clearAll(position);
            }
        }
    }

    public ChoiceAdapter(Context context, Survey survey) {
        mContext = context;
        mSurvey = survey;
    }

    private void clearAll(int skipPosition) {
        for (int i = 0; i < mSurvey.getResponses().size(); ++i) {
            if (i == skipPosition)
                continue;
            Response response = mSurvey.getResponses().get(i);
            response.setSelected(false);
        }

        notifyDataSetChanged();
    }

    @Override
    public ChoiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_choice, parent, false);

        ViewHolder vh = new ViewHolder(context, v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ChoiceAdapter.ViewHolder viewHolder, int position) {
        Response response = mSurvey.getResponses().get(position);

        viewHolder.tvChoice.setText(response.getChoice());

        boolean isSelected = false;
        if (response.getSelected() != null)
            isSelected = response.getSelected();

        viewHolder.checkBox.setChecked(isSelected);

        viewHolder.itemView.setOnClickListener(viewHolder);
    }

    @Override
    public int getItemCount() {
        return mSurvey.getResponses().size();
    }
}
