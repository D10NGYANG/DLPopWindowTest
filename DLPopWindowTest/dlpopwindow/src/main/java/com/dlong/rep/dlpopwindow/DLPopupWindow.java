package com.dlong.rep.dlpopwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.List;

/**
 * 右上角菜单弹窗
 * @author  dlong
 * created at 2019/3/14 11:05 AM
 */
public class DLPopupWindow extends PopupWindow{

    /**
     * 定义一个接口
     */
    public interface OnItemClickListener{
        void OnClick(int position);
    }

    /** 实例化 */
    private OnItemClickListener onItemClickListener = null;

    /**
     * 设置点击回调
     * @param on
     */
    public void setOnItemClickListener(OnItemClickListener on){
        this.onItemClickListener = on;
    }

    /** 微信样式 */
    public static final int STYLE_WEIXIN = 1;
    /** 默认样式 */
    public static final int STYLE_DEF = 2;

    /** 上下文 */
    private Context mContext;
    private LayoutInflater mInflater;
    private View mContentView;
    /** 适配器 */
    private PopAdapter mAdapter;
    /** 数据列表 */
    private List<DLPopItem> mList;

    public DLPopupWindow(Context context, List<DLPopItem> list, int style){
        this.mContext = context;
        this.mList = list;

        // 打气筒
        mInflater = LayoutInflater.from(mContext);
        // 打气
        mContentView = mInflater.inflate(R.layout.pop_window,null, false);
        // 设置View
        setContentView(mContentView);
        // 设置宽与高
        setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        // 设置可以获取集点
        setFocusable(true);
        // 设置背景只有设置了这个才可以点击外边和BACK消失
        setBackgroundDrawable(new ColorDrawable());
        // 设置点击外边可以消失
        setOutsideTouchable(true);

        // 获得listview
        ListView listView = (ListView) mContentView.findViewById(R.id.listview);
        mAdapter = new PopAdapter(mContext, mList);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 回调
                onItemClickListener.OnClick(position);
                dismiss();
            }
        });
        LinearLayout llBG = (LinearLayout) mContentView.findViewById(R.id.ll_bg);
        // 根据类型修改背景
        switch (style){
            case STYLE_WEIXIN:
                llBG.setBackgroundResource(R.drawable.menu_open_weixin);
                break;
            default:
                llBG.setBackgroundResource(R.drawable.menu_open);
                break;
        }
    }
}
