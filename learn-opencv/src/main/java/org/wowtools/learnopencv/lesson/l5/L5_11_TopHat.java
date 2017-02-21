package org.wowtools.learnopencv.lesson.l5;

import org.bytedeco.javacpp.opencv_core;

import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgproc.*;

/**
 * 礼帽
 * @author liuyu
 * @date 2017/2/21
 */
public class L5_11_TopHat {
    public static void main(String[] args) {
        opencv_core.IplImage img = Commonality.loadOriginal("road/1.jpg");

        opencv_core.IplConvKernel elementEx =
                cvCreateStructuringElementEx(3, 6, 0, 0, CV_SHAPE_RECT);
        cvMorphologyEx(img,img,null,elementEx,CV_MOP_TOPHAT,1);
        /**
         * 礼帽运算会分隔出比周围亮的点，
         * 于是屋顶被明显地标识出来(变黑了--)
         */
        Commonality.showImg("CV_MOP_GRADIENT", img);
        cvWaitKey(0);
    }
}
