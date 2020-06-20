package com.sahrial.ceritarakyatbengkulu.home.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Contacts
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.sahrial.ceritarakyatbengkulu.PdfViewActivity

import com.sahrial.ceritarakyatbengkulu.R
import com.sahrial.ceritarakyatbengkulu.home.model.RequestCerita
import com.sahrial.ceritarakyatbengkulu.utils.Preferences
import kotlinx.android.synthetic.main.fragment_upload.*

class FragmentUpload : Fragment() {
    private lateinit var mDatabase: DatabaseReference
    lateinit var data: RequestCerita
    lateinit var title: String
    lateinit var from: String
    private lateinit var preferences: Preferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upload, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tv_upload.setOnClickListener {
            val intent = Intent(context, PdfViewActivity::class.java)
            intent.putExtra("ViewType", "assets")
            startActivity(intent)
        }
        /**/
        /* preferences = Preferences(requireActivity().applicationContext)*/
        mDatabase = FirebaseDatabase.getInstance().getReference("Request Cerita")
       btn_upload.setOnClickListener {
            title = et_judul.text.toString()
            from = et_asal.text.toString()
            if (title.equals("")) {
                et_judul.error = "Masukkan Judul Cerita"
                et_judul.requestFocus()
            } else if (from.equals("")) {
                et_asal.error = "Masukkan Asal Daerah Cerita"
                et_asal.requestFocus()
            } else {
                val dialogBuilder = AlertDialog.Builder(context)

                // set message of alert dialog
                dialogBuilder.setMessage("Ingin Request Cerita?")
                    // if the dialog is cancelable
                    .setCancelable(false)
                    // positive button text and action
                    .setPositiveButton("Request", DialogInterface.OnClickListener {
                            dialog, id ->
                        writeNewPost(title, from)
                        Toast.makeText(
                            context,
                            "Terimakasih Telah Mengisi Cerita.\nPermintaan Anda Akan Segera Diproses oleh Admin",
                            Toast.LENGTH_LONG
                        ).show()

                    })
                    // negative button text and action
                    .setNegativeButton("Batal", DialogInterface.OnClickListener {
                            dialog, id -> dialog.cancel()
                    })

                // create dialog box
                val alert = dialogBuilder.create()
                // set title for alert dialog box
                alert.setTitle("Request Cerita")
                // show alert dialog
                alert.show()
            }
       }
    }
    /*val builder = AlertDialog.Builder(context)
    //set title for alert dialog
    builder.setTitle("Upload Cerita")
    //set message for alert dialog
    builder.setMessage("Upload Cerita?")
    builder.setIcon(android.R.drawable.ic_dialog_alert)

    //performing positive action
    builder.setPositiveButton("Upload") { dialogInterface, which ->*/

                /* //performing negative action
                    builder.setNegativeButton("Tidak") { dialogInterface, which ->
                        Toast.makeText(context, "Operasi dibatalkan", Toast.LENGTH_LONG).show()
                    }
                    // Create the AlertDialog
                    val alertDialog: AlertDialog = builder.create()
                    // Set other dialog properties
                    alertDialog.setCancelable(false)
                    alertDialog.show()
                }*/

        private fun writeNewPost(title: String, from: String) {
            val post = RequestCerita()
            post.judul = title
            post.asal = from
            val postValues = post.toMap()

            val childUpdates = HashMap<String, Any>()
            /*childUpdates["User$key"] = postValues*/
            childUpdates["$title"] = postValues
            mDatabase.updateChildren(childUpdates)
            }
/*        }

private fun checkCerita(judul: String, data:RequestCerita){
    mDatabase.child(judul).addValueEventListener(object : ValueEventListener{
        override fun onDataChange(datasnapshot: DataSnapshot) {
            val user = datasnapshot.getValue(RequestCerita::class.java)
            if(user==null){
                mDatabase.child(judul).setValue(data)
                preferences.setValues("nama", data.judul.toString())
                preferences.setValues("user", data.asal.toString())
                Toast.makeText(
                    context,
                    "Terimakasih Telah Mengisi Cerita.\nPermintaan Anda Akan Segera Diproses oleh Admin",
                    Toast.LENGTH_LONG
                ).show()
            }
            else{
                Toast.makeText(
                    context,
                    "Cerita Telah Tersedia",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        override fun onCancelled(error: DatabaseError) {
            Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
        }
    })*/
}




