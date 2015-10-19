package com.yoyo.test;



import android.os.RemoteException;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;



public class TestYoYo extends UiAutomatorTestCase{
    public void testRandom() throws RemoteException {

        if (!UiDevice.getInstance().isScreenOn()) {
            UiDevice.getInstance().wakeUp();
        }

        while (true) {
            int i = (int) (Math.random()*10);
            if (i<6) {
                pressLike();
            } else {
                comment();
            }
        }
    }


    /**点赞方法**/
    public void pressLike() {
        UiObject like = new UiObject(new UiSelector().className("android.widget.RelativeLayout").index(0).
                childSelector(new UiSelector().className("android.widget.RelativeLayout").index(1).
                        childSelector(new UiSelector().className("android.widget.RelativeLayout").index(2).
                                childSelector(new UiSelector().className("android.widget.ImageView").index(1)))));
        try {
            for (int i=0; i<5; i++) {
                like.click();
                sleep(100);
            }
        } catch (UiObjectNotFoundException e) {
            System.out.println("点赞失败");
        }
        sleep(200);
    }


    /**评论方法**/
    public void comment() {
        UiObject text = new UiObject(new UiSelector().className("android.widget.EditText"));
        try {
            text.click();
        } catch (UiObjectNotFoundException e) {
            System.out.println("点击输入框失败");
        }
        sleep(200);

        try {
            text.setText("test");
        } catch (UiObjectNotFoundException e) {
            System.out.println("输入失败");
        }
        sleep(100);

        UiObject send = new UiObject(new UiSelector().text("发送"));
        try {
            send.click();
        } catch (UiObjectNotFoundException e) {
            System.out.println("发送失败");
        }
        sleep(100);
    }
}
