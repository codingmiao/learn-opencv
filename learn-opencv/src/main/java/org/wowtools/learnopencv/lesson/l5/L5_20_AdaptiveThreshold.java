package org.wowtools.learnopencv.lesson.l5;

import org.bytedeco.javacpp.opencv_core;

import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgproc.CV_FLOODFILL_FIXED_RANGE;

/**
 * 自适应阈值
 *
 * @author liuyu
 * @date 2017/2/28
 */
public class L5_20_AdaptiveThreshold {
    public static void main(String[] args) {
        opencv_core.IplImage img = Commonality.loadOriginal("road/2.jpg");
        //二值阈值化， 超过阈值的值转为120 阈值由block_size区域内的均值减掉常数p1得到
        //于是下面的方法将高于周围均值10灰度的区域置为255，其它取0
        cvAdaptiveThreshold(img, img, 255,
                /*
                对方法 CV_ADAPTIVE_THRESH_MEAN_C，先求出块中的均值，再减掉 param1。
                对方法 CV_ADAPTIVE_THRESH_GAUSSIAN_C ，先求出块中的加权和(gaussian)， 再减掉 param1
                 */
                CV_ADAPTIVE_THRESH_MEAN_C,
                CV_THRESH_BINARY,//阈值化方式
                5,//周围n*n个像素求均值
                -10//常数
        );
        Commonality.showImg("AdaptiveThreshold", img);
        cvWaitKey(0);
    }

}
