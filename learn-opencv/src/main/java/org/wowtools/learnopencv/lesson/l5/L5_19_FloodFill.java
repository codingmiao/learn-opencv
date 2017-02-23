package org.wowtools.learnopencv.lesson.l5;

import org.bytedeco.javacpp.opencv_core;

import static org.bytedeco.javacpp.opencv_core.CV_8UC1;
import static org.bytedeco.javacpp.opencv_core.cvCreateMat;
import static org.bytedeco.javacpp.opencv_core.cvZero;
import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgproc.*;

/**
 * 浸水填充算法扣取图像中的物体
 * @author liuyu
 * @date 2017/2/23
 */
public class L5_19_FloodFill {
    public static void main(String[] args) {
        opencv_core.IplImage img = Commonality.loadOriginal("road/2.jpg");
        int x = 350, y = 208;//选取湖中的一个点

        //填充到面具上
        org.bytedeco.javacpp.helper.opencv_core.CvArr mask = cvCreateMat(img.height() + 2, img.width() + 2, CV_8UC1);
        cvZero(mask);
        cvFloodFill(img, new opencv_core.CvPoint(x, y),
                new opencv_core.CvScalar(255),//填充色
                new opencv_core.CvScalar(2, 2, 2, 0),//负误差
                new opencv_core.CvScalar(3, 3, 3, 0),//正误差
                null,
                getFillFlag(true, false),
                mask);
        Commonality.showImg("mask", mask);


        /**
         * 用白色填充湖泊
         */

        cvFloodFill(img, new opencv_core.CvPoint(x, y),
                new opencv_core.CvScalar(255, 255, 255, 0),//填充色
                new opencv_core.CvScalar(2, 2, 2, 0),//负误差
                new opencv_core.CvScalar(3, 3, 3, 0),//正误差
                null,
                getFillFlag(false, false),
                null);
        Commonality.showImg("cvFloodFill", img);
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
