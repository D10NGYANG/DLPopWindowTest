package com.dlong.rep.dlpopwindow

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import java.io.Serializable

/**
 * 选项的属性
 */
data class DLPopItem(
        var iconResId: Int = R.drawable.ic_baseline_error_24,
        var iconColorValue: Int = 0xffffffff.toInt(),

        var textTitle: String = "",

        var textMsg: String = ""
): Serializable {

    companion object{

        @JvmStatic
        @BindingAdapter("srcInt")
        fun setImageRes(img: ImageView, srcInt: Int) {
            img.setImageResource(srcInt)
        }
    }

}