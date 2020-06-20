package com.sahrial.ceritarakyatbengkulu.home.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.*


import com.sahrial.ceritarakyatbengkulu.R
import com.sahrial.ceritarakyatbengkulu.utils.Preferences
import kotlinx.android.synthetic.main.fragment_developer.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentDeveloper : Fragment() {
       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_developer, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        iv_telp.setOnClickListener{
        /*    val intent = Intent(Intent.ACTION_SEND)

            val chooser = Intent.createChooser(intent, title)

// Verify the intent will resolve to at least one activity
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(chooser)
            }
*/
            iv_mail.setOnClickListener{
                

            }
        }
    }
}

