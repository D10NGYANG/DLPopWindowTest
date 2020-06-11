package com.dlong.rep.dlpopwindow

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * 右上角菜单弹窗
 * @author  dlong
 * created at 2019/3/14 11:05 AM
 */
class DLPopupWindow(
        /** 上下文  */
        private val mContext: Context,
        /** 数据列表  */
        private var mList: MutableList<DLPopItem>
) : PopupWindow() {
    /**
     * 定义一个接口
     */
    interface OnItemClickListener {
        fun onClick(position: Int, item: DLPopItem)
    }

    /** 点击监听  */
    private var adapterClickListener: OnItemClickListener = object : OnItemClickListener{
        override fun onClick(position: Int, item: DLPopItem) {
            onItemClickListener?.onClick(position, item)
            dismiss()
        }
    }

    private var onItemClickListener: OnItemClickListener? = null

    /**
     * 设置点击回调
     * @param on
     */
    fun setOnItemClickListener(on: OnItemClickListener) {
        onItemClickListener = on
    }

    private val mInflater: LayoutInflater = LayoutInflater.from(mContext)
    private val mContentView: View
    /** 适配器  */
    private val mAdapter: PopAdapter

    init {
        mContentView = mInflater.inflate(R.layout.pop_window, null, false)
        // 设置View
        contentView = mContentView
        // 设置宽与高
        width = LinearLayout.LayoutParams.WRAP_CONTENT
        height = LinearLayout.LayoutParams.WRAP_CONTENT
        // 设置可以获取集点
        isFocusable = true
        // 设置背景只有设置了这个才可以点击外边和BACK消失
        setBackgroundDrawable(ColorDrawable())
        // 设置点击外边可以消失
        isOutsideTouchable = true

        // 获得列表
        val rcv = mContentView.findViewById<View>(R.id.rcv) as RecyclerView
        mAdapter = PopAdapter(mList, adapterClickListener)
        rcv.layoutManager = LinearLayoutManager(mContext)
        rcv.adapter = mAdapter
    }

    /** 更新列表 */
    fun updateList(list: MutableList<DLPopItem>) {
        mAdapter.update(list)
    }
}