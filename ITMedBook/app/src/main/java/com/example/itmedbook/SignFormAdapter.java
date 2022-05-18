package com.example.itmedbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SignFormAdapter extends RecyclerView.Adapter{
    public LayoutInflater inflater;
    public List<SignForm> signforms;

    interface OnStateClickListener{
        void onStateClick(SignForm signForm, int position);
    }



    SignFormAdapter(Context context, List<SignForm> signforms) {
        this.signforms = signforms;
        this.inflater = LayoutInflater.from(context);

    }
    @Override
    public int getItemViewType(int position) {
        if (signforms.get(position) instanceof SignFormMain) {
            return SignForm.TWO_TEXT;
        } else if (signforms.get(position) instanceof SignFormTitle) {
            return SignForm.TEXT_TITLE;
        } else if (signforms.get(position) instanceof SignFormSwitch) {
            return SignForm.SWITCH;
        } else if (signforms.get(position) instanceof SignFormDate){
            return SignForm.DATE;
        }
        else{
            return -1;
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == SignForm.TWO_TEXT) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.signform1, parent, false);
            return new TwoTextViewHolder(view);
        } else if (viewType == SignForm.TEXT_TITLE) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.signform2, parent, false);
            return new TitleViewHolder(view);
        } else if (viewType == SignForm.SWITCH) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.signform_switch, parent, false);
            return new SwitchViewHolder(view);
        } else if (viewType == SignForm.DATE){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.signform_date, parent, false);
            return new DateViewHolder(view);
        }
        else{
            return null;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TwoTextViewHolder) {
            ((TwoTextViewHolder) holder).textInfo
                    .setText(((SignFormMain) signforms.get(position)).getTextInfo());
        } else if (holder instanceof TitleViewHolder) {
            ((TitleViewHolder) holder).textSignTitle
                    .setText(((SignFormTitle) signforms.get(position)).getTitleSignForm());
        } else if (holder instanceof SwitchViewHolder) {
            ((SwitchViewHolder) holder).switchSign
                    .setText(((SignFormSwitch) signforms.get(position)).getQuestionSign());
        } else if( holder instanceof DateViewHolder){
            ((DateViewHolder)holder).textInfoDate
                    .setText(((SignFormDate)signforms.get(position)).getTextInfoDate());
        }

    }

    @Override
    public int getItemCount() {
        return signforms.size();
    }

    public static class TwoTextViewHolder extends RecyclerView.ViewHolder {
        TextView textInfo,PersonDataText;
        TwoTextViewHolder(View view){
            super(view);
            textInfo = view.findViewById(R.id.textSignInfo);
            PersonDataText = view.findViewById(R.id.PersonData);

        }
    }

    public static class TitleViewHolder extends  RecyclerView.ViewHolder{
        TextView textSignTitle;
        TitleViewHolder(View view){
            super(view);
            textSignTitle = view.findViewById(R.id.textSignTitle);
        }
    }
    public static class SwitchViewHolder extends  RecyclerView.ViewHolder{
        Switch switchSign;
        SwitchViewHolder(View view){
            super(view);
            switchSign = view.findViewById(R.id.switchSign);
        }

    }
    public static class DateViewHolder extends  RecyclerView.ViewHolder{
        TextView textInfoDate;
        DateViewHolder(View view){
            super(view);
            textInfoDate = view.findViewById(R.id.textInfoDate);
        }
    }


}
