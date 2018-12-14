package digitalhouse.com.br.digitalhousekotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        preferences = getSharedPreferences("APP", Context.MODE_PRIVATE)

        edittext_user_login.setText(preferences.getString("EMAIL", ""))
        edittext_password_login.setText(preferences.getString("PASSWORD", ""))

        btn_goto_login.setOnClickListener {

            if (switch_remember.isChecked) {
                preferences.edit().putString("EMAIL", edittext_user_login.text.toString()).apply()
                preferences.edit().putString("PASSWORD", edittext_password_login.text.toString()).apply()
            }


            if (!edittext_user_login.text.toString().isEmpty() ||
                !edittext_password_login.text.toString().isEmpty()
            ) {

                startActivity(Intent(this, PersonActivity::class.java))
            }
        }
    }
}
