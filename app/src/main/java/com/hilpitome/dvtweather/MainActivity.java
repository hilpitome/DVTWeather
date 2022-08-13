package com.hilpitome.dvtweather;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.gson.Gson;
import com.hilpitome.dvtweather.contract.WeatherContract;
import com.hilpitome.dvtweather.data.CurrentWeatherResponse;
import com.hilpitome.dvtweather.databinding.ActivityMainBinding;
import com.hilpitome.dvtweather.presenter.WeatherPresenter;

import android.view.Menu;
import android.view.MenuItem;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements WeatherContract.View{

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private WeatherContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        presenter = new WeatherPresenter(this);
        presenter.getCurrentWeather();
        presenter.getForecastedWeather();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        presenter.cleanUp();
    }

    @Override
    public void setCurrentWeather(CurrentWeatherResponse data) {
        Timber.i("setting current weather");
        Timber.i(new Gson().toJson(data));
    }

    @Override
    public void setWeatherForecast(CurrentWeatherResponse data) {
        Timber.i("setting forecasted weather");
        Timber.i(new Gson().toJson(data));
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void removeProgress() {

    }
}