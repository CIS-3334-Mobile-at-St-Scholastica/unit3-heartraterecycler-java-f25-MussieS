package cis3334.java_heartrate_start;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private HeartrateRepository heartrateRepository;
    private LiveData<List<Heartrate>> heartrateList;

    public MainViewModel(Application application) {
        super(application);
        heartrateRepository = new HeartrateRepository(application);
        heartrateList = heartrateRepository.getAll();
    }

    public void insert(Integer heartrate, Integer age) {
        Heartrate hr = new Heartrate(heartrate, age);
        heartrateRepository.insert(hr);
    }

    public LiveData<List<Heartrate>> getAllHeartrates() {
        heartrateList = heartrateRepository.getAll();
        return heartrateList;
    }

    // ✅ Add these methods below

    public Heartrate getHeartrateAt(int position) {
        if (heartrateList.getValue() == null) return null;
        if (position < 0 || position >= heartrateList.getValue().size()) return null;
        return heartrateList.getValue().get(position);
    }

    public int getHeartrateCount() {
        if (heartrateList.getValue() == null) return 0;
        return heartrateList.getValue().size();
    }

}
