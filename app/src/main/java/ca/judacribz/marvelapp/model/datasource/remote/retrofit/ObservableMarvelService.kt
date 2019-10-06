package ca.judacribz.marvelapp.model.datasource.remote.retrofit

import ca.judacribz.marvelapp.model.marvaldata.MarvelDataResponse
import io.reactivex.Single
import io.reactivex.SingleObserver
import retrofit2.http.GET
import retrofit2.http.Query

interface ObservableMarvelService {
    @GET("characters")
    fun getMarvelCharacters(
        @Query("ts") num: String,
        @Query("apikey") publicKey: String,
        @Query("hash") hashDigest: String
        ): Single<MarvelDataResponse>
}