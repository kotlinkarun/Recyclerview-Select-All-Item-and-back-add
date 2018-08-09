package com.demo.add

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.WindowManager
import android.widget.LinearLayout
import com.demo.MainActivity
import com.demo.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_add.*


class AddActivity : AppCompatActivity(), SearchView.OnQueryTextListener {


    private lateinit var addAdapter: AddAdapter
    private lateinit var list: ArrayList<AddModel>
    private var context: Context = this@AddActivity
    private var data: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

       this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        data = intent.getStringExtra("key")

        add_rec.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        list = ArrayList()

        list.add(AddModel(12374, "Karun Kumar", "http://1.bp.blogspot.com/-Mk5AyGkeYnw/Va1k6pum6eI/AAAAAAAAFlg/Tlorcet_EQ8/s1600/20150712_174650.jpg", false))
        list.add(AddModel(16553, "Shaneha Beta", "http://www.tellychakkar.com/sites/tellychakkar.com/files/imagecache/Display_445x297/images/story/2013/03/04/neha.jpg", false))
        list.add(AddModel(373, "Kunal  Kaouie", "http://static.sbuys.in/media/registration_users/DRC031.JPG", false))
        list.add(AddModel(6354, "Dhaere Tussd", "http://images.desimartini.com/media/uploads/2017-5/salman-khan-3.jpg", false))
        list.add(AddModel(13745, "Katrina Mehata", "https://i.pinimg.com/736x/a6/02/e6/a602e6c8c300bcae750bf88d2b28e41b--katrina-wallpaper-katrina-kaif-wallpapers.jpg", false))
        list.add(AddModel(7434, "Tinkui Kushiw", "http://stat3.bollywoodhungama.in/wp-content/uploads/2017/04/Akshay-Kumars-remark-on-taking-away-his-National-award-Serious-or-sarcasm.jpg", false))
        list.add(AddModel(94363, "Kursg Dharma", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/Neha_Sharma_at_the_Promo_launch_of_%27Jayanta_Bhai_Ki_Luv_Story%27_07.jpg/398px-Neha_Sharma_at_the_Promo_launch_of_%27Jayanta_Bhai_Ki_Luv_Story%27_07.jpg", false))


         list.add(AddModel(12374, "Karun Kumar", "http://1.bp.blogspot.com/-Mk5AyGkeYnw/Va1k6pum6eI/AAAAAAAAFlg/Tlorcet_EQ8/s1600/20150712_174650.jpg", false))
        list.add(AddModel(11253, "Shaneha Beta", "http://www.tellychakkar.com/sites/tellychakkar.com/files/imagecache/Display_445x297/images/story/2013/03/04/neha.jpg", false))
        list.add(AddModel(14543, "Kunal  Kaouie", "http://static.sbuys.in/media/registration_users/DRC031.JPG", false))
        list.add(AddModel(17243, "Dhaere Tussd", "http://images.desimartini.com/media/uploads/2017-5/salman-khan-3.jpg", false))
        list.add(AddModel(84123, "Katrina Mehata", "https://i.pinimg.com/736x/a6/02/e6/a602e6c8c300bcae750bf88d2b28e41b--katrina-wallpaper-katrina-kaif-wallpapers.jpg", false))
        list.add(AddModel(16523, "Tinkui Kushiw", "http://stat3.bollywoodhungama.in/wp-content/uploads/2017/04/Akshay-Kumars-remark-on-taking-away-his-National-award-Serious-or-sarcasm.jpg", false))
        list.add(AddModel(96523, "Kursg Dharma", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/Neha_Sharma_at_the_Promo_launch_of_%27Jayanta_Bhai_Ki_Luv_Story%27_07.jpg/398px-Neha_Sharma_at_the_Promo_launch_of_%27Jayanta_Bhai_Ki_Luv_Story%27_07.jpg", false))


        list.add(AddModel(5446, "Karun Kumar", "http://1.bp.blogspot.com/-Mk5AyGkeYnw/Va1k6pum6eI/AAAAAAAAFlg/Tlorcet_EQ8/s1600/20150712_174650.jpg", false))
        list.add(AddModel(7333, "Shaneha Beta", "http://www.tellychakkar.com/sites/tellychakkar.com/files/imagecache/Display_445x297/images/story/2013/03/04/neha.jpg", false))
        list.add(AddModel(36964, "Kunal  Kaouie", "http://static.sbuys.in/media/registration_users/DRC031.JPG", false))
        list.add(AddModel(56743, "Dhaere Tussd", "http://images.desimartini.com/media/uploads/2017-5/salman-khan-3.jpg", false))
        list.add(AddModel(53454, "Katrina Mehata", "https://i.pinimg.com/736x/a6/02/e6/a602e6c8c300bcae750bf88d2b28e41b--katrina-wallpaper-katrina-kaif-wallpapers.jpg", false))
        list.add(AddModel(63453, "Tinkui Kushiw", "http://stat3.bollywoodhungama.in/wp-content/uploads/2017/04/Akshay-Kumars-remark-on-taking-away-his-National-award-Serious-or-sarcasm.jpg", false))
        list.add(AddModel(865544, "Kursg Dharma", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d6/Neha_Sharma_at_the_Promo_launch_of_%27Jayanta_Bhai_Ki_Luv_Story%27_07.jpg/398px-Neha_Sharma_at_the_Promo_launch_of_%27Jayanta_Bhai_Ki_Luv_Story%27_07.jpg", false))



        addAdapter = AddAdapter(context, list)
        add_rec.adapter = addAdapter
        setupSearchView()

        if (data != null) {
            Log.d("TAGS", "Reponse Data With array $data")
            if (data != null && data != "") {
                val d = data!!.split("~")
                for (j in 0 until d.size) {
                    for (i in 0 until list.size) {
                        val m: AddModel = list[i]
                        if (m.ids == d[j].toInt()) {
                            m.isSelected = true
                            addAdapter.notifyDataSetChanged()
                        }
                    }
                }
            }
        }

        checkAll.setOnCheckedChangeListener({ _, isChecked ->
            for (i in 0 until list.size) {
                val addModel_addStudent: AddModel = list[i]
                addModel_addStudent.isSelected = isChecked
                addAdapter.notifyDataSetChanged()
            }
        })





        back.setOnClickListener({
            startActivity(Intent(context, MainActivity::class.java))
            onBackPressed()

        })





        submit1.setOnClickListener({
            val mylist: ArrayList<HashMap<String, String>> = ArrayList()
            var map: HashMap<String, String>? = null
            for (i in 0 until list.size) {
                val m: AddModel = list[i]
                if (m.isSelected) {
                    map = HashMap()
                    map.put("id", m.ids.toString())
                    map.put("name", m.name)
                    map.put("avatar", m.avatar)
                    mylist.add(map)
                }

            }
            var data = Gson().toJson(mylist)
            Log.d("TAGS", data)


            startActivity(Intent(context, MainActivity::class.java).putExtra("key", data))
            finish()
        })


    }


    private fun setupSearchView() {
        search_view.setIconifiedByDefault(false);
        search_view.setOnQueryTextListener(this);
        search_view.isSubmitButtonEnabled = true;
        search_view.queryHint = "Search friends...";
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false;
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        addAdapter.filter(newText!!);
        return true;
    }



}
