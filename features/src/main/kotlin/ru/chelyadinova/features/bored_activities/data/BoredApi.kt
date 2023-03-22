package ru.chelyadinova.features.activities.data

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query
import ru.chelyadinova.features.activities.data.dto.BoredActivityResponse

interface BoredApi {

    @GET("/api/activity")
    suspend fun getActivity(@Query("type") type: String? = null): BoredActivityResponse

}