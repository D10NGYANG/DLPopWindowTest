package com.dlong.rep.dlpopwindow

import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import java.io.Serializable

/**
 * 选项的属性
 */
data class DLPopItem(
        // 图片
        var iconResId: Int = R.drawable.ic_baseline_error_24,
        var iconColorValue: Int = 0xffffffff.toInt(),
        var iconPadding: Int = 0,
        // 图片背景
        var iconBgResId: Int = 0,
        var iconBgColorValue: Int = 0xffffffff.toInt(),
        // Item背景
        var itemBgResId: Int = 0,
        var itemBgColorValue: Int = 0x00ffffff.toInt(),
        // 分割线
        var dividerAlpha: Float = 0.5f,
        var dividerColorValue: Int = 0xffffffff.toInt(),
        // 文本信息
        var textTitle: String = "",
        var textMsg: String = ""
): Serializable {

    companion object{

        @JvmStatic
        @BindingAdapter("srcInt")
        fun setImageRes(img: ImageView, srcInt: Int) {
            img.setImageResource(srcInt)
        }

        @JvmStatic
        @BindingAdapter("bgSrcInt")
        fun setImageBgRes(img: ImageView, bgSrcInt: Int) {
            img.setBackgroundResource(bgSrcInt)
        }

        @JvmStatic
        @BindingAdapter("itemBgSrcInt")
        fun setConstraintLayoutBgRes(cl: ConstraintLayout, bgSrcInt: Int) {
            cl.setBackgroundResource(bgSrcInt)
        }
    }

}