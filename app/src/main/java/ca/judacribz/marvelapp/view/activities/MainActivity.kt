package ca.judacribz.marvelapp.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.judacribz.marvelapp.R
import ca.judacribz.marvelapp.databinding.ActivityMainBinding
import ca.judacribz.marvelapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var offset = 20;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        val mainViewModel = MainViewModel()
        activityMainBinding.viewmodel = mainViewModel
        activityMainBinding.lifecycleOwner = this

        rvCharacters.layoutManager = LinearLayoutManager(this)

        rvCharacters.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(1)) {
                    mainViewModel.getMarvelData(offset)
                    offset +=20
                }
            }
        })

//        mainViewModel.mutableCharacters.observe(this, Observer<ArrayList<Result>> { results ->
//            mainViewModel.addCharacters(results)
//        })
        mainViewModel.getMarvelData()
    }

//    companion object {
//        @BindingAdapter("bind:adapter")
//        fun initRecyclerView(view: RecyclerView, adapter: MarvelCharacterAdapter) {
//            view.layoutManager = LinearLayoutManager(view.context)
//            view.adapter = adapter
//        }
//    }
}
