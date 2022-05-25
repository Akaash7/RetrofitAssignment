package com.akash.retroassign

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.akash.retroassign.DataClass.Commit
import com.akash.retroassign.DataClass.CommitDetails
import com.akash.retroassign.DataClass.Commits
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.detail_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPage: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_page)

        val sha : String? = intent.getStringExtra("sha")
        if (sha != null) {
            getCommit(sha)
        }
    }

    private fun setTexts(commitDetails: CommitDetails){

        author.text = commitDetails.commit.author.name
        date.text = commitDetails.commit.author.date.subSequence(0,10)
        sha.text = commitDetails.sha
        totalChanges.text = commitDetails.stats.total.toString()
        filesChanged.text = commitDetails.files.size.toString()
        message.text = commitDetails.commit.message



    }


    private fun getCommit(sha : String){
        val commits = RetrofitInstance.retrofitInstance.getCommitDetails(sha)

        commits.enqueue(object : Callback<CommitDetails> {
            override fun onResponse(call: Call<CommitDetails>, response: Response<CommitDetails>) {

                val commit:CommitDetails = response.body()!!
                setTexts(commit)
            }

            override fun onFailure(call: Call<CommitDetails>, t: Throwable) {
                Log.d("Details","Network Call Failure")
            }


            })
    }
}