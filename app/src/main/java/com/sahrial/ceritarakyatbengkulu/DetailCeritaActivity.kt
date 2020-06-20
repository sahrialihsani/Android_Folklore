package com.sahrial.ceritarakyatbengkulu

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.database.*
import com.sahrial.ceritarakyatbengkulu.home.model.Cerita
import com.sahrial.ceritarakyatbengkulu.utils.Preferences
import kotlinx.android.synthetic.main.activity_detail_cerita.*
import kotlinx.android.synthetic.main.row_populer.iv_poster_image
import kotlinx.android.synthetic.main.row_populer.tv_title

class DetailCeritaActivity : AppCompatActivity() {

    private lateinit var preferences: Preferences
    lateinit var mDatabase: DatabaseReference
    private var dataList = ArrayList<Cerita>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_cerita)
        val data = intent.getParcelableExtra<Cerita>("data")

        mDatabase = FirebaseDatabase.getInstance().getReference("Cerita")
            .child(data.judul.toString())
        preferences = Preferences(this)
        tv_title.text=data.judul
        tv_asal.text=data.asal
        tv_baca.text=data.cerita
        tv_tengok.text=data.see.toString()
        mDatabase.child("see").setValue((data.see!!.toInt()+1))
            .addOnSuccessListener {
            }
            .addOnFailureListener {
                Toast.makeText(this,it.message,Toast.LENGTH_LONG).show()
            }
       /* currentScore = child.child("Score").getValue(Int::class.java)
        child.getRef().child("Score").setValue(42)*/
    /*    mDatabase.child("Cerita").child("Asal Mula Buaya Pisang Emas ").setValue(tv_tengok)*/


        /*   tv_asal_daerah.setText = data.judul
           tv_genre.text = data.genre
           tv_desc.text = data.desc
           tv_rate.text = data.rating
   */
        Glide.with(this)
            .load(data.poster)
            .into(iv_poster_image)


    }}
