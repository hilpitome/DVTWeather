package com.hilpitome.dvtweather.adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hilpitome.dvtweather.R;
import com.hilpitome.dvtweather.data.CurrentWeatherResponse;
import com.hilpitome.dvtweather.data.CustomList;
import com.hilpitome.dvtweather.data.ForecastWeatherResponse;
import com.hilpitome.dvtweather.databinding.WeatherItemBinding;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import timber.log.Timber;

public class WeatherReportAdapter extends RecyclerView.Adapter<WeatherReportAdapter.ViewHolder>{
    private List<CustomList> mCustomList;

    public WeatherReportAdapter(List<CustomList> customList){
        mCustomList = customList;
    }

    public void setmCustomList(List<CustomList> customList) {
        mCustomList.clear();
        mCustomList.addAll(customList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_item, parent, false);
        return new ViewHolder(view) ;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CustomList data = mCustomList.get(position);
        LocalDate localDate = LocalDate.now();
        TextView dayOfWeek = holder.itemView.findViewById(R.id.day_of_week);
        ImageView icon = holder.itemView.findViewById(R.id.icon);
        TextView temp = holder.itemView.findViewById(R.id.temparature);
        dayOfWeek.setText(localDate.plusDays(position+1).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
        String iconUrl = String.format("https://openweathermap.org/img/w/%s.png",data.getWeather().get(0).getIcon());
        Glide.with(holder.itemView).load(iconUrl).into(icon);
        temp.setText(String.valueOf(data.getMain().getTemp()));

    }

    @Override
    public int getItemCount() {
        return mCustomList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
