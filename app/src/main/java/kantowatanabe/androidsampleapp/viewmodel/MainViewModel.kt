package kantowatanabe.androidsampleapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val count: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val bindingText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        count.value = 0
        bindingText.value = "hoge"
    }
}

