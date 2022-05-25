package com.akash.retroassign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.akash.retroassign.DataClass.Commits
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var commitAdapter: CommitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCommits()

    }

    private fun getCommits(){
        val commits = RetrofitInstance.retrofitInstance.getCommits()
        commits.enqueue(object : Callback<List<Commits>>{
            override fun onResponse(call: Call<List<Commits>>, response: Response<List<Commits>>) {
            val commits = response.body()
                if(commits!=null){
                    commitAdapter =  CommitAdapter(this@MainActivity,commits)
                    rvCommits.adapter = commitAdapter
                    rvCommits.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<List<Commits>>, t: Throwable) {
                Log.d("Main","Network Call Failure")
            }
        })

        }
    }
