package cis3334.java_heartrate_start;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HeartrateAdapter extends RecyclerView.Adapter<HeartrateViewHolder> {

    private final Application application;
    private final MainViewModel mainViewModel;
    private List<Heartrate> heartrateList;
    public HeartrateAdapter(Application application, MainViewModel mainViewModel) {
        this.application = application;
        this.mainViewModel = mainViewModel;
    }

    public void setData(List<Heartrate> newData) {
        this.heartrateList = newData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HeartrateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.heartrate_row, parent, false);
        return new HeartrateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeartrateViewHolder holder, int position) {
        if (heartrateList == null || heartrateList.isEmpty()) return;

        Heartrate heartrate = heartrateList.get(position);
        holder.textViewPulse.setText("Pulse: " + heartrate.pulse);
        holder.textViewRange.setText("Range: " + heartrate.getRangeName());
        holder.textViewDescription.setText("\"" + heartrate.getRangeDescrtiption() + "\"");
    }



    @Override
    public int getItemCount() {
        return mainViewModel.getHeartrateCount();
    }
}
