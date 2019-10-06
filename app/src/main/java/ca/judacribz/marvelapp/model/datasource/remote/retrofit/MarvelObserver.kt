package ca.judacribz.marvelapp.model.datasource.remote.retrofit

import android.util.Log
import ca.judacribz.marvelapp.model.marvaldata.MarvelDataResponse
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MarvelObserver(private val marvelDataListener: MarvelDataListener) :
    SingleObserver<MarvelDataResponse> {

    val TAG = MarvelObserver::class.java.simpleName

    interface MarvelDataListener {
        fun onMarvelDataReceived(response: MarvelDataResponse)
    }

    override fun onSuccess(response: MarvelDataResponse) {
        Log.d(TAG, "onSuccess: ")
        marvelDataListener.onMarvelDataReceived(response)
    }

    override fun onSubscribe(d: Disposable) {
        Log.d(TAG, "onSubscribe: ")
    }

    override fun onError(e: Throwable) {
        Log.e(TAG, "onError: ", e)
    }

}


