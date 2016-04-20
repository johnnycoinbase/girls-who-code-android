package com.lowell.girlswhocode.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lowell.girlswhocode.R;
import com.lowell.girlswhocode.api.survey.Record;
import com.lowell.girlswhocode.api.votes.Vote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by johnnychan on 4/19/16.
 */
public class ChoiceAdapter extends RecyclerView.Adapter<ChoiceAdapter.ViewHolder> {
    private static final String UNSELECTED = "UNSELECTED";

    Context mContext;
    Record mSurvey;
    Vote mVote;
    ArrayList<Choice> mChoices = new ArrayList<>();
    String selectedChoiceName = UNSELECTED;

    private class Choice {
        int id;
        String name;
        int count;

        public Choice(int id, String name) {
            this.id = id;
            this.name = name;
            this.count = 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context mContext;

        @Bind(R.id.checkBox)
        CheckBox checkBox;

        @Bind(R.id.tvChoice)
        TextView tvChoice;

        // TODO: Show vote count

        public ViewHolder(Context context, View view) {
            super(view);

            ButterKnife.bind(this, view);

            mContext = context;
        }

        @Override
        public void onClick(View view) {
            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
                selectedChoiceName = UNSELECTED;
            } else {
                checkBox.setChecked(true);
                selectedChoiceName = tvChoice.getText().toString();
            }

            notifyDataSetChanged();
        }
    }

    public ChoiceAdapter(Context context, Record survey, Vote vote) {
        mContext = context;
        mSurvey = survey;
        mVote = vote;

        // Filter choices based on current survey id.
        ArrayList<Choice> tmpAl = new ArrayList<>();
        HashMap<String, Choice> tmpHm = new HashMap<>();
        for (com.lowell.girlswhocode.api.votes.Record voteRecord : vote.getRecords()) {
            Choice choice = new Choice(voteRecord.getFields().getId(), voteRecord.getFields().getVote());
            if (voteRecord.getFields().getSurveyId() == survey.getFields().getId()) {
                tmpAl.add(choice);
                tmpHm.put(voteRecord.getFields().getVote(), choice);
            }
        }

        // tmpAl contains all choices for this survey, use that to tally up votes.
        for (Choice tmpChoice : tmpAl) {
            Choice choice = tmpHm.get(tmpChoice.name);
            choice.count++;
            tmpHm.put(choice.name, choice);
        }

        // Store tally'ed up choices in array.
        mChoices.clear();
        mChoices.addAll(tmpHm.values());
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
        Choice choice = mChoices.get(position);

        viewHolder.tvChoice.setText(choice.name);

        boolean isSelected = selectedChoiceName.equalsIgnoreCase(choice.name);
        viewHolder.checkBox.setChecked(isSelected);

        viewHolder.itemView.setOnClickListener(viewHolder);
    }

    @Override
    public int getItemCount() {
        return mChoices.size();
    }
}
