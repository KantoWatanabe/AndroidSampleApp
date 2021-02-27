package kantowatanabe.androidsampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import kantowatanabe.androidsampleapp.databinding.ActivityMainBinding
import kantowatanabe.androidsampleapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MainViewModel by viewModels()

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val m = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(m)
        val w = m.widthPixels
        val h = m.heightPixels
        binding.metrics.text = "$w x $h"

        val rm = DisplayMetrics()
        windowManager.defaultDisplay.getRealMetrics(rm)
        val rw = rm.widthPixels
        val rh = rm.heightPixels
        binding.realMetrics.text = "$rw x $rh"


        binding.vmUpdBtn.setOnClickListener {
            viewModel.count.value = viewModel.count.value!! + 1
        }

        val observer = Observer<Int> {
            binding.vmText.text = it.toString()
        }
        viewModel.count.observe(this, observer)
    }
}
