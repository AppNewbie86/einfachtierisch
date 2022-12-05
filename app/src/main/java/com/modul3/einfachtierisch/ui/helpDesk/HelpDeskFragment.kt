package com.modul3.einfachtierisch.ui.helpDesk

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.firebase.database.DatabaseReference
import com.modul3.einfachtierisch.MainViewModel
import com.modul3.einfachtierisch.R
import com.modul3.einfachtierisch.TAG
import com.modul3.einfachtierisch.data.models.Member
import com.modul3.einfachtierisch.data.models.Post
import com.modul3.einfachtierisch.databinding.FragmentHelpDeskBinding
import com.modul3.einfachtierisch.databinding.FragmentSignUpBinding


class HelpDeskFragment : Fragment() {
/*

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var binding: FragmentHelpDeskBinding

    private lateinit var database: DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help_desk, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
binding.btnSend.setOnClickListener {
    database.child("user").child().setValue(user)
        .addOnSuccessListener {
            viewModel.updateMember()

        }
        .addOnFailureListener {
            // Write failed
            // ...
        }


}


    }


    private fun writeNewPost(userId: String, username: String, title: String, body: String) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        val key = database.child("posts").push().key
        if (key == null) {
            Log.w(TAG, "Couldn't get push key for posts")
            return
        }

        val post = Post(userId, username, title, body)
        val postValues = post.toMap()

        val childUpdates = hashMapOf<String, Any>(
            "/posts/$key" to postValues,
            "/user-posts/$userId/$key" to postValues
        )

        database.updateChildren(childUpdates)
    }
    */

}

