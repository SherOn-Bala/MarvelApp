package ca.judacribz.marvelapp.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.judacribz.marvelapp.model.constants.Url.Companion.PRIVATE_KEY
import ca.judacribz.marvelapp.model.constants.Url.Companion.PUBLIC_KEY
import ca.judacribz.marvelapp.model.datasource.remote.retrofit.MarvelHelper
import ca.judacribz.marvelapp.model.datasource.remote.retrofit.MarvelObserver
import ca.judacribz.marvelapp.model.marvaldata.MarvelDataResponse
import ca.judacribz.marvelapp.model.marvaldata.Result
import ca.judacribz.marvelapp.model.util.Encrypt.getMD5Hash
import ca.judacribz.marvelapp.view.adapters.MarvelCharacterAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel(), Observable, MarvelObserver.MarvelDataListener {

    val mutableCharacters: MutableLiveData<ArrayList<Result>> = MutableLiveData()

    override fun onMarvelDataReceived(response: MarvelDataResponse) {
        addCharacters(response.data.results as ArrayList<Result>)
    }

    private val propertyChangeRegistry = PropertyChangeRegistry()
    private val marvelHelper = MarvelHelper()
    private val md5Hash: String by lazy {
        getMD5Hash(PUBLIC_KEY, PRIVATE_KEY)
    }

    @Bindable
    var marvelCharacterAdapter: MarvelCharacterAdapter = MarvelCharacterAdapter(ArrayList())

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    fun getMarvelData() {
        getMarvelData(0)
    }

    fun getMarvelData(offset: Int) {
        marvelHelper.observeMarvelService.getMarvelCharacters(1, offset, PUBLIC_KEY, md5Hash)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(MarvelObserver(this))
    }


    fun setAdapter(results: ArrayList<Result>) {
        marvelCharacterAdapter = MarvelCharacterAdapter(results)
        notifyAllPropertiesChanged()
    }

    private fun notifyAllPropertiesChanged() {
        propertyChangeRegistry.notifyChange(this, 0)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }

    fun addCharacters(results: ArrayList<Result>) {
        marvelCharacterAdapter.addCharacters(results)
    }
}