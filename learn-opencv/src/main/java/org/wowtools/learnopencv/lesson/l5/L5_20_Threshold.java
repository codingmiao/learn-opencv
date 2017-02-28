package org.wowtools.learnopencv.lesson.l5;

import org.bytedeco.javacpp.opencv_core;

import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgproc.*;

/**
 * 阈值化操作
 * @author liuyu
 * @date 2017/2/28
 */
public class L5_20_Threshold {
    public static void main(String[] args) {
        opencv_core.IplImage img = Commonality.loadOriginal("road/2.jpg");
        int x = 350, y = 208;//选取湖中的一个点

        //先用填充算法将湖泊染成255
        cvFloodFill(img, new opencv_core.CvPoint(x, y),
                new opencv_core.CvScalar(255, 255, 255, 0),//填充色
                new opencv_core.CvScalar(2, 2, 2, 0),//负误差
                new opencv_core.CvScalar(3, 3, 3, 0),//正误差
                null,
                getFillFlag(false, false),
                null);
        Commonality.showImg("cvFloodFill", img);
        //二值阈值化，阈值254.9 超过阈值的值转为120
        cvThreshold(img,img,254.9,120,CV_THRESH_BINARY);
        Commonality.showImg("cvThreshold", img);
        cvWaitKey(0);
    }

    /**
     * 得到填充标志
     *
     * @param maskOnly   是否仅将填充色涂到面具上
     * @param fixedRange 是否将相邻像素比较切换为与种子比较
     * @return
     */
    private static int getFillFlag(boolean maskOnly, boolean fixedRange) {
        int flag = 8;
        if (maskOnly) {
            flag = flag | CV_FLOODFILL_MASK_ONLY;
        }
        if (fixedRange) {
            flag = flag | CV_FLOODFILL_FIXED_RANGE;
        }
        return flag | (47 << 8);
    }
}
