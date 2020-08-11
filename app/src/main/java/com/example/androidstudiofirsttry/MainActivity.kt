package com.example.androidstudiofirsttry

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val array = arrayOf("剪刀", "石頭", "布")
    var position =0

    //使用預設Toast顯示文字訊息
    private fun showToast(text: String) =
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_action.setOnClickListener {
            //宣告變數用以保存選擇位置
            //宣告AlertDialog物件，setSingleChoiceItems可以在Dialog顯示單選框
            AlertDialog.Builder(this)
                .setTitle("出拳") //顯示標題
                .setSingleChoiceItems(array, 0) { dialogInterface, i ->
                    position = i
                }
                .setPositiveButton("確定") { dialog, which ->
                    showToast("你出的是" + array[position])
                }.show()    //顯示Dialog
        }

        btn_mora.setOnClickListener {

            if(!user_name.text.equals("")){
                text_name.text = "名字\n${user_name.text}"
            }

            text_mmora.text = "我方出拳\n${array[position]}"

        //電腦出拳
        var con = (Math.random()*3+1).toInt()
        when(con){
            1->text_cmora.text="電腦出拳\n剪刀"
            2->text_cmora.text="電腦出拳\n石頭"
            3->text_cmora.text="電腦出拳\n布"
        }
        //勝負判定
        when{
            //判定玩家獲勝
            position==0 && con==3 ||
            position==1 && con==1 ||
            position==2 && con==2->{
                text_winner.text = "勝利者\n${user_name.text}"
            }
            //判定電腦獲勝
            position==2 && con==1 ||
            position==0 && con==2 ||
            position==1 && con==3->{
                text_winner.text = "勝利者\n電腦"
            }
            else->{
                text_winner.text = "勝利者\n平手"
            }
        }
        }
    }
}