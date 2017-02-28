package org.wowtools.learnopencv.lesson.l5;

import org.bytedeco.javacpp.opencv_core;

import static org.bytedeco.javacpp.opencv_core.IPL_DEPTH_8U;
import static org.bytedeco.javacpp.opencv_core.cvCreateImage;
import static org.bytedeco.javacpp.opencv_core.cvGetSize;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import org.wowtools.learnopencv.Constant;

import static org.bytedeco.javacpp.opencv_highgui.CV_WINDOW_AUTOSIZE;
import static org.bytedeco.javacpp.opencv_highgui.cvNamedWindow;
import static org.bytedeco.javacpp.opencv_highgui.cvShowImage;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;

/**
 * @author liuyu
 * @date 2017/2/20
 */
public class Commonality {
    /**
     * 加载并显示原始图片
     *
     * @return
     */
    public static opencv_core.IplImage loadOriginal(String imgName) {
        opencv_core.IplImage img = cvLoadImage(Constant.filePath + imgName);
        if (null == img) {
            throw new RuntimeException("加载图片出错" + Constant.filePath + imgName);
        }
        showImg("original",img);
        img = toGrayscale(img);
        showImg("grayscale",img);
        return img;
    }

    public static void showImg(String windowName,opencv_core.CvArr img){
        cvNamedWindow(windowName, CV_WINDOW_AUTOSIZE);// CV_WINDOW_AUTOSIZE 根据图片大小自动设置窗口大
        cvShowImage(windowName, img);
    }

    /**
     * 得到图片对应的灰度图
     * @param img
     * @return
     */
    public static opencv_core.IplImage toGrayscale(opencv_core.IplImage img){
        opencv_core.IplImage dst = cvCreateImage(cvGetSize(img), IPL_DEPTH_8U, 1);//创建目标图像
        cvCvtColor(img,dst,CV_BGR2GRAY);
        return dst;
    }
}
