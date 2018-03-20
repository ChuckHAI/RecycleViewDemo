package client.mimi.com.mimiclient.util;

import android.app.Activity;

import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.share.WbShareHandler;

/**
 * Created by chuck on 2018/3/5.
 */

public class WBShareUtil {


    private WbShareHandler shareHandler;

    public static WBShareUtil wBShareUtil;

    public static WBShareUtil getInstace(Activity activity) {
        if (wBShareUtil == null) {
            wBShareUtil = new WBShareUtil(activity);
        }
        return wBShareUtil;
    }

    public WBShareUtil(Activity activity) {
        WbSdk.install(activity, new AuthInfo(activity, WBConstants.APP_KEY, WBConstants.REDIRECT_URL, WBConstants.SCOPE));
        shareHandler = new WbShareHandler(activity);
        shareHandler.registerApp();
        shareHandler.setProgressColor(0xff33b5e5);
    }

    public WbShareHandler getWbShareHandler() {
        return shareHandler;
    }


    public void toTextObj(String title, String value, String actionUrl) {
        TextObject textObject = new TextObject();
        textObject.title = title;
        textObject.text = value;
        textObject.actionUrl = actionUrl;

        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.textObject = textObject;
        shareHandler.shareMessage(weiboMultiMessage, false);
    }

    public void toImageObj(String title, String imagePath, String actionUrl) {
        ImageObject imageObject = new ImageObject();
        imageObject.title = title;
        imageObject.imagePath = imagePath;
        imageObject.actionUrl = actionUrl;

        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.imageObject = imageObject;
        shareHandler.shareMessage(weiboMultiMessage, false);
    }


}
