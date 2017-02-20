package org.wowtools.learnopencv.lesson.l5;

import org.bytedeco.javacpp.opencv_core;

import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgproc.cvDilate;

/**
 * 膨胀
 * @author liuyu
 * @date 2017/2/20
 */
public class L_5_7_Dilate {
    public static void main(String[] args) {
        opencv_core.IplImage img = Commonality.loadOriginal("road/1.jpg");
        cvDilate(img,img);
        /*
        膨胀会使得图片中亮度高的部分被扩展和连通，于是图中的电线更容易识别了
         */
        Commonality.showImg("cvDilate",img);
        cvWaitKey(0);
    }
}
