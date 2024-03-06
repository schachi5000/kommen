package pro.schacher.kommon.android

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


fun Context.showToast(@StringRes resId: Int) {
    this.getString(resId).let { this.showToast(it) }
}

fun Context.showToast(message: String) {
    val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)

    MainScope().launch { toast.show() }
}