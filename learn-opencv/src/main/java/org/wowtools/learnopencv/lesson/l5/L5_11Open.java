package org.wowtools.learnopencv.lesson.l5;

import org.bytedeco.javacpp.opencv_core;

import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgproc.CV_MOP_OPEN;
import static org.bytedeco.javacpp.opencv_imgproc.cvMorphologyEx;
/**
 * 开运算
 * @author liuyu
 * @date 2017/2/21
 */
public class L5_11Open {
    public static void main(String[] args) {
        opencv_core.IplImage img = Commonality.loadOriginal("road/1.jpg");
        cvMorphologyEx(img,img,null,null,CV_MOP_OPEN,1);
        /**
         * 树梢、电缆等离散的明亮小区域被去除
         */
        Commonality.showImg("OPEN", img);
        cvWaitKey(0);
    }
}
