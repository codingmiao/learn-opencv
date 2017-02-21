package org.wowtools.learnopencv.lesson.l5;

import org.bytedeco.javacpp.opencv_core;

import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgproc.*;

/**
 * 闭运算
 * @author liuyu
 * @date 2017/2/21
 */
public class L5_11_Close {
    public static void main(String[] args) {
        opencv_core.IplImage img = Commonality.loadOriginal("road/1.jpg");

        opencv_core.IplConvKernel elementEx =
                cvCreateStructuringElementEx(3, 6, 0, 0, CV_SHAPE_RECT);
        cvMorphologyEx(img,img,null,elementEx,CV_MOP_CLOSE,1);
        /**
         * 闭运算使得离散的电线连在一起，且不像膨胀一样会使得亮的区域明显变大
         */
        Commonality.showImg("CV_MOP_CLOSE", img);
        cvWaitKey(0);
    }
}
