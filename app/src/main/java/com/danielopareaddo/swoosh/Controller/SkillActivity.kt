package com.danielopareaddo.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.danielopareaddo.swoosh.Model.Player
import com.danielopareaddo.swoosh.R
import com.danielopareaddo.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    lateinit var player : Player //LATEINIT IS USED TO INDICATE THAT THE VARIABLE WILL LATER RECEIVE ITS VALUES

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
        }
    }


    fun onBeginnerClicked (view: View){
        ballerSkillBtn.isChecked = false //THIS WILL UNCHECK THE BALLERKILLBTN
        player.skill = "beginner"        //THIS WILL PASS BEGINNER TO SKILL VARIABLE
    }


    fun onBallerClicked (view: View){
        beginnerSkillBtn.isChecked = false
        player.skill = "baller"
    }


    fun onSkillFinishedClicked (view: View){
        if ((player.skill != "") && ((beginnerSkillBtn.isChecked == false && ballerSkillBtn.isChecked == false)==false)){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)   //THIS WILL PASS ALL VARIABLES OF PLAYER TO THE NEXT ACTIVITY
        }else {
            Toast.makeText(this, "Please select a skill level",Toast.LENGTH_SHORT).show()
        }
    }

}
