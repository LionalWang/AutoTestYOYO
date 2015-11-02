package com.yoyo.test;



import android.os.RemoteException;
import com.android.uiautomator.core.*;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;



public class TestYoYo extends UiAutomatorTestCase{
    public void testRandom() throws RemoteException {
        Configurator.getInstance().setActionAcknowledgmentTimeout(10);

        if (!UiDevice.getInstance().isScreenOn()) {
            UiDevice.getInstance().wakeUp();
        }

        while (true) {
            int i = (int) (Math.random()*10);
            if (i<5) {
                pressLike();
            } else {
                comment();
            }
        }
    }


    /**点赞方法**/
    public void pressLike() {
        UiObject like = new UiObject(new UiSelector().resourceId("com.yixia.videoeditor:id/live_im_send_zan"));
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
        int a = (int) (Math.random()*5);
        try {
            text.click();
        } catch (UiObjectNotFoundException e) {
            System.out.println("点击输入框失败");
        }

        try {
            if (a==0) {
                text.setText("test0");
            } else if (a==1) {
                text.setText("test1");
            } else if (a==2) {
                text.setText("test2");
            } else if (a==3) {
                text.setText("test3");
            } else if (a==4) {
                text.setText("test4");
            } else {
                text.setText("test5");
            }
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
