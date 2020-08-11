package com.example.androidstudiofirsttry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_scissor.isChecked = true
        btn_mora.setOnClickListener {
            if(!user_name.text.equals("")){
                text_name.text = "名字\n${user_name.text}"
            }
            //我方出拳
            var user_punch = 1
            if (btn_scissor.isChecked) {
                text_mmora.text = "我方出拳\n剪刀"
                user_punch = 1
            }
            else if(btn_stone.isChecked){
                text_mmora.text = "我方出拳\n石頭"
                user_punch = 2
            }
            else if(btn_paper.isChecked){
                text_mmora.text = "我方出拳\n布"
                user_punch = 3
            }
        //電腦出拳
        var r = (Math.random()*3+1).toInt()
        when(r){
            1->text_cmora.text="電腦出拳\n剪刀"
            2->text_cmora.text="電腦出拳\n石頭"
            3->text_cmora.text="電腦出拳\n布"
        }
        //勝負判定
        when{
            //判定玩家獲勝
            user_punch==1 && r==3 ||
            user_punch==2 && r==1 ||
            user_punch==3 && r==2->{
                text_winner.text = "勝利者\n${user_name.text}"
            }
            //判定電腦獲勝
            user_punch==3 && r==1 ||
            user_punch==1 && r==2 ||
            user_punch==2 && r==3->{
                text_winner.text = "勝利者\n電腦"
            }
            else->{
                text_winner.text = "勝利者\n平手"
            }
        }
        }
    }
}