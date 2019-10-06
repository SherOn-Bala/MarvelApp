package ca.judacribz.marvelapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import ca.judacribz.marvelapp.R
import ca.judacribz.marvelapp.databinding.ActivityMainBinding
import ca.judacribz.marvelapp.model.marvaldata.MarvelDataResponse
import ca.judacribz.marvelapp.model.marvaldata.Result
import ca.judacribz.marvelapp.view.adapters.MarvelCharacterAdapter
import ca.judacribz.marvelapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        val mainViewModel = MainViewModel()
        activityMainBinding.viewmodel = mainViewModel

        rvCharacters.layoutManager = LinearLayoutManager(this)

        mainViewModel.getMarvelData()



        mainViewModel.marvelDataResponse.observe(this, Observer<MarvelDataResponse>{ response ->
            rvCharacters.adapter = MarvelCharacterAdapter(response.data.results as ArrayList<Result>)
        })

    }
}
