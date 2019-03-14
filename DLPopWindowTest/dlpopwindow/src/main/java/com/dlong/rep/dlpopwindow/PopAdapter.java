package com.dlong.rep.dlpopwindow;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * 列表适配器
 * @author  dlong
 * created at 2019/3/14 1:45 PM
 */
public class PopAdapter extends BaseAdapter {
    private Context mContext;
    private List<DLPopItem> mList;
    private DLPopItem mItem;

    public PopAdapter(Context context, List<DLPopItem> list){
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder mHolder;
        if (convertView == null) {
            mHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pop_item, parent, false);
            mHolder.imgIcon = (ImageView) convertView.findViewById(R.id.img_icon);
            mHolder.imgLine = (ImageView) convertView.findViewById(R.id.img_line);
            mHolder.txt = (TextView) convertView.findViewById(R.id.txt);

            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        mItem = mList.get(position);
        // 设置图标
        mHolder.imgIcon.setImageResource(mItem.getIcon());
        // 设置文本
        mHolder.txt.setText(mItem.getText());
        // 设置图标颜色
        int cd = mItem.getColor();
        if (cd < 0x01000000){
            cd = 0xff000000 + cd;
        }
        mHolder.imgIcon.setColorFilter(cd);
        // 设置下拉线颜色
        int cc = cd & 0x33ffffff;
        mHolder.imgLine.setBackgroundColor(cc);
        // 设置文本颜色
        mHolder.txt.setTextColor(cd);
        // 如果是最后一项就不显示下划线
        if (position == mList.size()-1){
            mHolder.imgLine.setVisibility(View.GONE);
        }else {
            mHolder.imgLine.setVisibility(View.VISIBLE);
        }
        // 如果没有图标文字就居中显示
        if (mItem.getIcon() == 0){
            mHolder.txt.setGravity(Gravity.CENTER);
            mHolder.imgIcon.setVisibility(View.GONE);
        }else {
            mHolder.txt.setGravity(Gravity.CENTER_VERTICAL);
            mHolder.imgIcon.setVisibility(View.VISIBLE);
        }
        return convertView;
    }

    private class ViewHolder{
        ImageView imgIcon, imgLine;
        TextView txt;
    }
}
