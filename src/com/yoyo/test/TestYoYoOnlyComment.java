package com.yoyo.test;

import android.os.RemoteException;
import com.android.uiautomator.core.*;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class TestYoYoOnlyComment extends UiAutomatorTestCase{
    public void testComment() throws RemoteException {
        Configurator.getInstance().setActionAcknowledgmentTimeout(10);

        if (!UiDevice.getInstance().isScreenOn()) {
            UiDevice.getInstance().wakeUp();
        }

        comment();
    }


    /**点赞方法**/
    public void pressLike() {
        UiObject like = new UiObject(new UiSelector().className("android.widget.RelativeLayout").index(0).
                childSelector(new UiSelector().className("android.widget.RelativeLayout").index(1).
                        childSelector(new UiSelector().className("android.widget.RelativeLayout").index(2).
                                childSelector(new UiSelector().className("android.widget.ImageView")))));
        try {
            for (int i=0; i<15; i++) {
                like.click();
            }
        } catch (UiObjectNotFoundException e) {
            System.out.println("点赞失败");
        }
    }


    /**评论方法**/
    public void comment() {
        UiObject text = new UiObject(new UiSelector().className("android.widget.EditText"));
        try {
            text.click();
        } catch (UiObjectNotFoundException e) {
            System.out.println("点击输入框失败");
        }
        while (true) {
            Configurator.getInstance().setActionAcknowledgmentTimeout(10);
            try {
                text.setText("T");
            } catch (UiObjectNotFoundException e) {
                System.out.println("输入失败");
            }

            UiObject send = new UiObject(new UiSelector().text("发送"));
            try {
                send.click();
            } catch (UiObjectNotFoundException e) {
                System.out.println("发送失败");
            }
        }
    }
}
