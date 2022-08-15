package com.hilpitome.dvtweather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hilpitome.dvtweather.adapter.WeatherReportAdapter;
import com.hilpitome.dvtweather.contract.WeatherContract;
import com.hilpitome.dvtweather.data.CurrentWeatherResponse;
import com.hilpitome.dvtweather.data.CustomList;
import com.hilpitome.dvtweather.data.ForecastWeatherResponse;
import com.hilpitome.dvtweather.databinding.WeatherFragmentBinding;
import com.hilpitome.dvtweather.presenter.WeatherPresenter;

import java.util.ArrayList;
import java.util.Objects;

public class WeatherFragment extends Fragment implements WeatherContract.View {

    private WeatherContract.Presenter presenter;

    private WeatherFragmentBinding binding;
    WeatherReportAdapter adapter = null;
    RecyclerView recyclerview;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = WeatherFragmentBinding.inflate(inflater, container, false);
        populateViews();
        return binding.getRoot();
    }

    private void populateViews() {
        adapter = new WeatherReportAdapter(new ArrayList<CustomList>());
        recyclerview = binding.forecastTv;
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(adapter);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new WeatherPresenter(this);
        presenter.getCurrentWeather();
        presenter.getForecastedWeather();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @SuppressLint("StringFormatMatches")
    @Override
    public void setCurrentWeather(CurrentWeatherResponse data) {
        if(data != null){
            binding.currentTemperature.setText(String.format(requireActivity().getResources().getString(R.string.current_temp)
            , data.getMain().getTemp()));
            binding.weatherDescription.setText(data.getWeather().get(0).getDescription());
        }
    }

    @Override
    public void setWeatherForecast(ForecastWeatherResponse data) {
        if(data!=null){
            adapter.setmCustomList(data.getList());
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void removeProgress() {

    }
}