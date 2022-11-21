package com.modul3.einfachtierisch

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import com.modul3.einfachtierisch.data.Repository
import com.modul3.einfachtierisch.data.models.Member
import com.modul3.einfachtierisch.data.models.NewsArticle
import com.modul3.einfachtierisch.remote.DogApi


/** Aufgaben meines MainViewModels
 *  Das MainViewModel kümmert sich um die Kommunikation mit der Firebase Authentication
 *  SpeicherOrt der Daten was von FireBase Auth oder Storage kommen
 *  Ansonsten teilen sich nur das Login und SignUp Fragment ein MainViewModel
 *  Alle anderen haben ein eigenes ViewModel zum Speichern ihrer Daten
 *  Steuert das Verhalten wenn Nutzer ausgeloggt ist
 *  Steuert das Verhalten wenn Nutzer sich falsch anmeldet oder Registriert und wirft dann einen ToastText
 **********************************************************************************************************
 *  SHA Code generieren
 *  Diesen Code zum Erhalten des SHACodes einfach in den Terminal folgenden Code einfügen
 *
 *  >>keytool -alias androiddebugkey -keystore ~/.android/debug.keystore -list -v -storepass android<<
 * **********************************************************************************************************
   **********************************************************************************************************

 *  ACHTUNG: in der Firestore Datenbank folgende Regel festlegen
 *
 *  >> allow read, write: if request.auth != null; <<
 *
 *   **********************************************************************************************************

 */

const val TAG = "MainViewModel"

class MainViewModel(application: Application) : AndroidViewModel(application) {


    private val repository = Repository(DogApi)

    private val _news = MutableLiveData<List<NewsArticle>>()
    val news: LiveData<List<NewsArticle>>
        get() = _news

    init {
        _news.value = repository.loadNews()
    }


// Kommunikationspunkt mit der Firestore Datenbank
    private val db = FirebaseFirestore.getInstance()

    // Kommunikationspunkt mit der FirebaseAuth
    private val firebaseAuth = FirebaseAuth.getInstance()

    // currentuser ist null wenn niemand eingeloggt ist
    private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser: LiveData<FirebaseUser?>
        get() = _currentUser

    // Member enthält alle relevanten Daten aus dem Firestore
    private val _member = MutableLiveData<Member>()
    val member: LiveData<Member>
        get() = _member

    private val _toast = MutableLiveData<String?>()
    val toast: LiveData<String?>
        get() = _toast

    // hier wird versucht einen User zu erstellen um diesen anschließend auch gleich
    // einzuloggen
    fun signUp(email: String, password: String, member: Member) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        _currentUser.value = firebaseAuth.currentUser
                        setNameAndLevel(member)
                        _toast.value = "welcome"
                        _toast.value = null
                    } else {
                        Log.e(TAG, "Login failed: ${it.exception}")
                        _toast.value = "login failed\n${it.exception?.localizedMessage}"
                        _toast.value = null
                    }
                }
            } else {
                Log.e(TAG, "SignUp failed: ${it.exception}")
                _toast.value = "signup failed\n${it.exception?.localizedMessage}"
                _toast.value = null
            }
        }
    }

    /**
     *  hier wird der Member, nickname und Level in die Firestore Datenbank gespeichert
     */

    private fun setNameAndLevel(member: Member) {
        db.collection("user").document(currentUser.value!!.uid)
            .set(member)
            .addOnFailureListener {
                Log.w(TAG, "Error writing document: $it")
                _toast.value = "error creating player\n${it.localizedMessage}"
                _toast.value = null
            }
    }
    /**
     *  Funktion für den Login
     */
    fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                _currentUser.value = firebaseAuth.currentUser
                _toast.value = "welcome"
                _toast.value = null
            } else {
                Log.e(TAG, "Login failed: ${it.exception}")
                _toast.value = "login failed\n${it.exception?.localizedMessage}"
                _toast.value = null
            }
        }
    }

    fun logout() {
        firebaseAuth.signOut()
        _currentUser.value = firebaseAuth.currentUser
    }
    /**
     *  hier werden Spielerdaten mittles userid aus dem Firestore geladen (Daten werden geholt)
     */
    fun getMemberData() {
        db.collection("user").document(currentUser.value!!.uid)
            .get().addOnSuccessListener {
                _member.value = it.toObject(Member::class.java)
            }
            .addOnFailureListener {
                Log.e(TAG, "Error reading document: $it")
            }
//            .addSnapshotListener { value, error ->
//                if (value != null && value.exists()) {
//                    _member.value = value.toObject(Member::class.java)
//                }
//            }
    }

    // hier wird das level des Spielers erhöht und in den FireStore geschrieben
    fun levelUp() {
        val newLevel = member.value!!
        db.collection("user").document(currentUser.value!!.uid)
            .update("level", newLevel)
            .addOnSuccessListener { getMemberData() }
    }
}
