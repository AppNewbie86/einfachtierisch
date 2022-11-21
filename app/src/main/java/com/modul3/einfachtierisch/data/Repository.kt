package com.modul3.einfachtierisch.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.data.models.GallerieImage
import com.modul3.einfachtierisch.data.models.NewsArticle
import com.modul3.einfachtierisch.data.models.Request
import com.modul3.einfachtierisch.remote.DogApi
import kotlinx.coroutines.delay

class Repository(private val api: DogApi) {


    private val _imageList = MutableLiveData<List<String>>()
    val imageList: LiveData<List<String>>
        get() = _imageList

    private val _currentRequest = MutableLiveData<Request>()
    val currentRequest: LiveData<Request>
        get() = _currentRequest

    suspend fun getImages() {
        // für Testzwecke
        delay(2000)
        _imageList.value = api.retrofitService.getImages().images
    }


}

/***
 * Methode zum laden der Kontakte aus der Liste
 */


fun loadNews(): List<NewsArticle> {

    return listOf(
        NewsArticle(
            1,
            "Das langersehnte Warten hat endlich ein Ende!!",
            R.drawable.american,
            "Deutschland",
            "21.11.2022",
            "Sensation Sensation!\nPumpa endlich wieder im Altenheim als TherapieHund unterwegs" +
                    "# Therapie, # Pflege, # Therapiemaßnahmen"
        ),
        NewsArticle(
            2,
            "Er ist ein Held unser Bello Sales, unser RettungsHund aus den Alpen",
            R.drawable.sales,
            "Deutschland",
            "20.11.2022",
            "kühn und unerschrocken witterte er die Färhte und rettete eine Dame die beim Skifahren " +
                    "verunglückte und durch das jahrelange Training und Harte Arbeit zahlte sich jetzt aus." +
                    "#Held, #Retter, #Bergretter"
        ),
        NewsArticle(
            3,
            "Erste BlindenhundAusbildung ist endlich beendet!!! ",
            R.drawable.sourcer,
            "Deutschland",
            "19.11.2022",
            "Sourcer ist unser Favorit und war Jahresbester im Landesverband und konnte sich so weit von anderen Hunden absetzen  "
        ),
        NewsArticle(
            4,
            "Schockiert !!! Wie kan man nur mit Hunden so umgehen ",
            R.drawable.baxter,
            "Deutschland",
            "18.11.2022",
            "Dieser und viele andere halbverhungerten Hunde fand man in Bayern eingesperrt im Keller gefunden als Anwohner das bellen und jaulen meldeten waren TierschutzBund und Anwohner entsetzt"
        ),
        NewsArticle(
            5,
            "Sparen sie nicht an einer HundeVersicherung",
            R.drawable.square,
            "Deutschland",
            "17.11.2022",
            "TierArztBesuche sind meist sehr teuer und können bei vielen finanzielle Schwierigkeiten bedeuten deswegen " +
                    "scheuen sie sich nicht und kommen sie sich bei einer Hundeversicherung kompetent beraten "
        )
    )
}

fun loadGallerie(): List<GallerieImage> {

    return listOf(
        GallerieImage(
            1,
            "Das langersehnte Warten hat endlich ein Ende!!",
            R.drawable.american,
            "Deutschland",
            "21.11.2022"

        ),
        GallerieImage(
            2,
            "Er ist ein Held unser Bello Sales, unser RettungsHund aus den Alpen",
            R.drawable.sales,
            "Deutschland",
            "20.11.2022"

        ),
        GallerieImage(
            3,
            "Erste BlindenhundAusbildung ist endlich beendet!!! ",
            R.drawable.sourcer,
            "Deutschland",
            "19.11.2022"
        ),
        GallerieImage(
            4,
            "Schockiert !!! Wie kan man nur mit Hunden so umgehen ",
            R.drawable.baxter,
            "Deutschland",
            "18.11.2022"
        ),
        GallerieImage(
            5,
            "Sparen sie nicht an einer HundeVersicherung",
            R.drawable.square,
            "Deutschland",
            "17.11.2022"

        )
    )
}
