package traore.adama.nextcut_android.services.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import traore.adama.nextcut_android.database.model.Nextcuter
import java.util.*

class NextcuterRepository() {

    companion object {
        val instance = NextcuterRepository()
    }

    fun getNextcuters():LiveData<List<Nextcuter>>{
        val data = MutableLiveData<List<Nextcuter>>()

        val list = ArrayList<Nextcuter>()
        val random = Random()
        list.add(Nextcuter(1, "Traore", "Adama", ""))
        list.add(Nextcuter(2, "Eliko", "Elige", ""))
        list.add(Nextcuter(3, "Traore", "Tali", ""))
        list.add(Nextcuter(4, "Lori", "Evan",""))
        list.add(Nextcuter(5, "Traore", "Adama", ""))
        list.add(Nextcuter(6, "Eliko", "Elige", ""))
        list.add(Nextcuter(7, "Traore", "Tali", ""))
        list.add(Nextcuter(8, "Lori", "Evan", ""))
        list.add(Nextcuter(9, "Traore", "Adama", ""))
        list.add(Nextcuter(10, "Eliko", "Elige", ""))
        list.add(Nextcuter(11, "Traore", "Tali", ""))
        list.add(Nextcuter(12, "Lori", "Evan", ""))

        data.value = list

        return data
    }
}

/*

Sample with callback
public class ProjectRepository {
    private GitHubService gitHubService;

    //…

    public LiveData<List<Project>> getProjectList(String userId) {
        final MutableLiveData<List<Project>> data = new MutableLiveData<>();

        gitHubService.getProjectList(userId).enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                data.setValue(response.body());
            }

            // Error handling will be explained in the next article …
        });

        return data;
    }

    // …
}

 */