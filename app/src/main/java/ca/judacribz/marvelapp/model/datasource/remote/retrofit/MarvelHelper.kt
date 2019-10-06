package ca.judacribz.marvelapp.model.datasource.remote.retrofit

import ca.judacribz.marvelapp.model.constants.Url.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MarvelHelper {
    private val retrofitInstance: Retrofit
        get() =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

    val observeMarvelService: ObservableMarvelService
        get() = retrofitInstance.create(ObservableMarvelService::class.java)
}