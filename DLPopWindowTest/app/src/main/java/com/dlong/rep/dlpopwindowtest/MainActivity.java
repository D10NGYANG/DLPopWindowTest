package com.dlong.rep.dlpopwindowtest;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dlong.rep.dlpopwindow.DLPopItem;
import com.dlong.rep.dlpopwindow.DLPopupWindow;

import org.jetbrains.annotations.NotNull;

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

        int color = 0;
        DLPopItem item = new DLPopItem(R.mipmap.message, color,0,
                0,0,0,0,
                0.5f,0, "发起群聊", "消息在这里");
        mList.add(item);
        item = new DLPopItem(R.mipmap.add_friend, color,0,
                0,0,0,0,
                0.5f,0,  "添加朋友", "消息在这里");
        mList.add(item);
        item = new DLPopItem(R.mipmap.scaning, color,0,
                0,0,0,0,
                0.5f,0,  "扫一扫", "消息在这里");
        mList.add(item);
        item = new DLPopItem(R.mipmap.pay, color,0,
                0,0,0,0,
                0.5f,0,  "收付款", "消息在这里");
        mList.add(item);
        popupWindow = new DLPopupWindow(mContext, mList);
        popupWindow.setOnItemClickListener(new DLPopupWindow.OnItemClickListener() {
            @Override
            public void onClick(int position, @NotNull DLPopItem item) {
                Toast.makeText(mContext, item.getTextTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void OpenPop(View view){
        popupWindow.showAsDropDown(view, 0, 0);
    }
}
