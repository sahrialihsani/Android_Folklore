package com.sahrial.ceritarakyatbengkulu.home.fragment

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.sahrial.ceritarakyatbengkulu.DetailCeritaActivity
import com.sahrial.ceritarakyatbengkulu.DetailDaerahActivity

import com.sahrial.ceritarakyatbengkulu.R
import com.sahrial.ceritarakyatbengkulu.home.CeritaAdapter
import com.sahrial.ceritarakyatbengkulu.home.DaerahAdapter
import com.sahrial.ceritarakyatbengkulu.home.model.Cerita
import com.sahrial.ceritarakyatbengkulu.utils.Preferences
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentHome : Fragment() {

    private lateinit var preferences: Preferences
    lateinit var mDatabase: DatabaseReference
    lateinit var mDatabase2: DatabaseReference
    private var dataList = ArrayList<Cerita>()
   /* private var dataList2 = ArrayList<Daerah>()*/
    lateinit var data: Cerita
   /* lateinit var data2: Daerah*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        /*val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager == null) {
            Toast.makeText(context, "Mohon Cek Koneksi Internet Anda", Toast.LENGTH_LONG)
                .show()
        } else {*/
            preferences = Preferences(requireActivity().applicationContext)

        mDatabase = FirebaseDatabase.getInstance().getReference("Cerita")
        if(context?.let { isNetworkAvailable(it) }!!){

                rv_daerah.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                rv_populer.layoutManager = LinearLayoutManager(context?.applicationContext)
                getData()
            }

        else{
            Toast.makeText(context,"Mohon Cek Koneksi Internet Anda.\nLalu tekan kembali tombol Home", Toast.LENGTH_LONG).show()

        }

        }


    fun isNetworkAvailable(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var activeNetworkInfo: NetworkInfo? = null
        activeNetworkInfo = cm.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }
    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataList.clear()
                for (getdataSnapshot in dataSnapshot.getChildren()) {
                    val cerita = getdataSnapshot.getValue(Cerita::class.java!!)
                    dataList.add(cerita!!)
                }
                rv_daerah?.adapter = DaerahAdapter(dataList) {
                    val intent = Intent(context,
                        DetailDaerahActivity::class.java).putExtra("data", it)
                    startActivity(intent)
                }
                rv_populer?.adapter = CeritaAdapter(dataList) {
                    val intent = Intent(
                        context,
                        DetailCeritaActivity::class.java
                    ).putExtra("data", it)
                    startActivity(intent)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "" + error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
    /*private fun getDataDaerah() {
        mDatabase2.orderByChild("asal").equalTo(data2.asal).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                dataList2.clear()
                for (getdataSnapshot in dataSnapshot.getChildren()) {
                    val daerah = getdataSnapshot.getValue(Daerah::class.java!!)
                    dataList2.add(daerah!!)
                }
                rv_daerah?.adapter = DaerahAdapter(dataList2) {
                    val intent = Intent(context,
                        DetailDaerahActivity::class.java).putExtra("data", it)
                    startActivity(intent)
                }
                *//*rv_populer?.adapter = CeritaAdapter(dataList) {
                    val intent = Intent(context,
                        DetailCeritaActivity::class.java).putExtra("data", it)
                    startActivity(intent)
                }*//*
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, ""+error.message, Toast.LENGTH_LONG).show()
            }
        })}*/
}
