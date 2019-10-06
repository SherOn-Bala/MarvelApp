package ca.judacribz.marvelapp.viewmodel

import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.judacribz.marvelapp.model.constants.Url.Companion.PRIVATE_KEY
import ca.judacribz.marvelapp.model.constants.Url.Companion.PUBLIC_KEY
import ca.judacribz.marvelapp.model.datasource.remote.retrofit.MarvelHelper
import ca.judacribz.marvelapp.model.datasource.remote.retrofit.MarvelObserver
import ca.judacribz.marvelapp.model.marvaldata.MarvelDataResponse
import ca.judacribz.marvelapp.model.util.Encrypt.getMD5Hash
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel(), Observable, MarvelObserver.MarvelDataListener {

    val marvelDataResponse : MutableLiveData<MarvelDataResponse> = MutableLiveData()

    override fun onMarvelDataReceived(response: MarvelDataResponse) {
        val jsonInString = Gson().toJson(response)
        marvelDataResponse.value = response

        Log.d("TAG", response.data.results.size.toString())
    }

    private val propertyChangeRegistry = PropertyChangeRegistry()
    private val marvelHelper = MarvelHelper()

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }


    fun getMarvelData() {
        val md5Hash = getMD5Hash(PUBLIC_KEY, PRIVATE_KEY)
        Log.d("TAG", md5Hash)
        if (md5Hash != null) {
            marvelHelper.observeMarvelService.getMarvelCharacters("1", PUBLIC_KEY, md5Hash)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(MarvelObserver(this))
        }
    }


    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }
}