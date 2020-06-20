package com.sahrial.ceritarakyatbengkulu

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.firebase.database.*
import com.sahrial.ceritarakyatbengkulu.home.DetailDaerahAdapter
import com.sahrial.ceritarakyatbengkulu.home.model.Cerita
import com.sahrial.ceritarakyatbengkulu.utils.Preferences
import kotlinx.android.synthetic.main.activity_detail_daerah.*


class DetailDaerahActivity : AppCompatActivity() {
    private lateinit var mDatabase: DatabaseReference
    private lateinit var preferences: Preferences
    private var dataList = ArrayList<Cerita>()
    lateinit var data: Cerita

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_daerah)
        data = intent.getParcelableExtra<Cerita>("data")!!

        mDatabase = FirebaseDatabase.getInstance().getReference("Cerita")
        preferences = Preferences(this)

        tv_asal_daerah.text=data.asal

        Glide.with(this)
            .load(data.poster_daerah)
            .into(iv_image)
        rv_detail.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getData()
    }

    private fun getData() {
        mDatabase.orderByChild("asal").equalTo(data.asal).addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataList.clear()
                for (getdataSnapshot in dataSnapshot.getChildren()) {

                    val urut = getdataSnapshot.getValue(Cerita::class.java!!)
                    dataList.add(urut!!)
                }

                rv_detail.adapter = DetailDaerahAdapter(dataList) {

                        val intent = Intent(this@DetailDaerahActivity,
                            DetailCeritaActivity::class.java).putExtra("data", it)
                        startActivity(intent)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DetailDaerahActivity, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
