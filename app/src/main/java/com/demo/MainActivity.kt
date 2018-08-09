package com.demo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.WindowManager
import android.widget.LinearLayout
import com.demo.add.AddActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.json.JSONArray


class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var list: ArrayList<Model>
    var context: Context=this@MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


       // rec1.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        rec1.layoutManager=GridLayoutManager(this,4)
        list = ArrayList()


        val datas=intent.getStringExtra("key")
        Log.d("TAGS ","Response: "+datas)
        if(datas!=null){
            val array=JSONArray(datas)
            for(i in 0 until array.length()){
                val obj=array.getJSONObject(i)
                list.add(Model(obj.getInt("id"), obj.getString("name"),obj.getString("avatar")))
            }
        }

        btn_add.setOnClickListener({
            val sb=StringBuilder()
            for(m: Model in list){
                sb.append("${m.ids}~")
            }
            try {
                sb.deleteCharAt(sb.lastIndex)
                    Log.d("TAGS ","Response StringBuilder: "+sb.toString())
                startActivity(Intent(context, AddActivity::class.java).putExtra("key",sb.toString()))
            } catch (e: Exception) {
                startActivity(Intent(context, AddActivity::class.java).putExtra("key",sb.toString()))
            }
        })


        myAdapter = MyAdapter(context, list)
        rec1.adapter = myAdapter
        myAdapter.notifyDataSetChanged()

    }
}