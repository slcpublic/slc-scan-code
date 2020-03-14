package android.slc.scancode;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;

import cn.bingoogolapple.qrcode.zxing.ZXingView;

/**
 * 修复ZXingView 1080p分辨率的bug
 * @author slc
 * @date 2019/10/19 15:23
 */
public class ZXingViewFix2kBug {
    /**
     * 设置二维码宽度
     *
     * @param zXingView
     * @param rectWidth
     */
    public static void setRectWidth(ZXingView zXingView, int rectWidth) {
        int screenWidth = getScreenWidth(zXingView.getContext());
        if (screenWidth > 1080) {
            int allowMaxHeight = screenWidth - (screenWidth - 1080) * 2;
            rectWidth = rectWidth > allowMaxHeight ? allowMaxHeight : rectWidth;
        }
        zXingView.getScanBoxView().setRectWidth(rectWidth);
    }

    /**
     * 设置条形码高度
     *
     * @param zXingView
     * @param rectWidth
     */
    public static void setBarcodeRectHeight(ZXingView zXingView, int rectWidth) {
        int screenWidth = getScreenWidth(zXingView.getContext());
        if (screenWidth > 1080) {
            int allowMaxHeight = screenWidth - (screenWidth - 1080) * 2;
            rectWidth = rectWidth > allowMaxHeight ? allowMaxHeight : rectWidth;
        }
        zXingView.getScanBoxView().setBarcodeRectHeight(rectWidth);
    }

    /**
     * Return the width of screen, in pixel.
     *
     * @return the width of screen, in pixel
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        if (wm == null) return -1;
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            wm.getDefaultDisplay().getRealSize(point);
        } else {
            wm.getDefaultDisplay().getSize(point);
        }
        return point.x;
    }

    /**
     * Return the height of screen, in pixel.
     *
     * @return the height of screen, in pixel
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        if (wm == null) return -1;
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            wm.getDefaultDisplay().getRealSize(point);
        } else {
            wm.getDefaultDisplay().getSize(point);
        }
        return point.y;
    }
}
