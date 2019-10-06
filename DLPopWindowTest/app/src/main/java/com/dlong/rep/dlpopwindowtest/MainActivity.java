package com.dlong.rep.dlpopwindowtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dlong.rep.dlpopwindow.DLPopItem;
import com.dlong.rep.dlpopwindow.DLPopupWindow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mContext = this;
    private DLPopupWindow popupWindow;
    private List<DLPopItem> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DLPopItem item = new DLPopItem(R.mipmap.message, "发起群聊", 0xffffff);
        mList.add(item);
        item = new DLPopItem(R.mipmap.add_friend, "添加朋友", 0xffffff);
        mList.add(item);
        item = new DLPopItem(R.mipmap.scaning, "扫一扫", 0xffffff);
        mList.add(item);
        item = new DLPopItem(R.mipmap.pay, "收付款", 0xffffff);
        mList.add(item);
        popupWindow = new DLPopupWindow(mContext, mList, DLPopupWindow.STYLE_WEIXIN);

        /*DLPopItem item = new DLPopItem(0, "添加设备", 0x888888);
        mList.add(item);
        item = new DLPopItem(0, "扫一扫", 0x888888);
        mList.add(item);
        popupWindow = new DLPopupWindow(mContext, mList, DLPopupWindow.STYLE_DEF);*/

        popupWindow.setContentViewBg(com.dlong.rep.dlpopwindow.R.drawable.menu_open);
        popupWindow.setOnItemClickListener(new DLPopupWindow.OnItemClickListener() {
            @Override
            public void OnClick(int position) {
                Toast.makeText(mContext, mList.get(position).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void OpenPop(View view){
        popupWindow.showAsDropDown(view, 0, 0);
    }
}
