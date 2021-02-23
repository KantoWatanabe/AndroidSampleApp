package kantowatanabe.androidsampleapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val count: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    init {
        count.value = 0
    }
}

