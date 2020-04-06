package com.danielopareaddo.swoosh.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danielopareaddo.swoosh.Model.Player
import com.danielopareaddo.swoosh.R
import com.danielopareaddo.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeaguesText.text = "Looking for ${player.league} ${player.skill} near you..."

    }
}
