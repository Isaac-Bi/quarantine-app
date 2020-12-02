package com.example.app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Custom ArrayAdapter for the Answer class, allows for customization of TextViews and Listviews
 *
 */
public class AnswerArrayAdapter extends ArrayAdapter<Answer> {
    private Activity myContext;
    private Answer[] datas;

    /**
     * AnswerArrayAdapter Constructor
     *
     * @param context The activity
     * @param textViewResourceId
     * @param objects
     */
    public AnswerArrayAdapter(Context context, int textViewResourceId, Answer[] objects) {
        super(context, textViewResourceId, objects);
        myContext = (Activity) context;
        datas = objects;
    }

    public View getView(int position, View conterView, ViewGroup parent) {
        LayoutInflater inflater = myContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_view, null);
        TextView answerRow = (TextView) rowView.findViewById(R.id.answer_row);
        answerRow.setText(datas[position].getContent());

        return rowView;
    }
}
