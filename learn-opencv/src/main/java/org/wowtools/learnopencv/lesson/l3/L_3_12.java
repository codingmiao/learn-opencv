package org.wowtools.learnopencv.lesson.l3;

import org.bytedeco.javacpp.opencv_core;
import org.wowtools.learnopencv.Constant;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_highgui.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;

/**
 * 通过设置ROI(兴趣区域)，快速将兴趣区域染色
 *
 * @author liuyu
 * @date 2017/2/15
 */
public class L_3_12 {
    public static void main(String[] args) {
        String imgName = "logo.png";
        opencv_core.IplImage img = cvLoadImage(Constant.filePath + imgName);
        CvRect roi = cvRect(0, 10, 50, 90);
        cvSetImageROI(img, roi);
        int add = 200;
        //cvScalar(b,g,r,alpha)，所以只填一个参数的话，蓝色通道+200
        cvAddS(img, cvScalar(add), img);
        cvNamedWindow(imgName, CV_WINDOW_AUTOSIZE);
        cvResetImageROI(img);//取消Roi区域，否则下面showImage也只显示roi
        cvShowImage(imgName, img);
        cvWaitKey(0);
    }
}
