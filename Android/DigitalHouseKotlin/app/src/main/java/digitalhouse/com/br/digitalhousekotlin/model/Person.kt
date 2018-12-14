package digitalhouse.com.br.digitalhousekotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(var name: String? = "",
                  var profession: String? = ""): Parcelable