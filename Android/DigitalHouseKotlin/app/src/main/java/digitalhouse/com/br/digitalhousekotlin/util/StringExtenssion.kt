package digitalhouse.com.br.digitalhousekotlin.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun String.jessicaLinda(): String {
    return "$this : Jessica linda e Brava :)"
}


fun ImageView.load(url: String) {
    Picasso.get().load(url).into(this)
}
