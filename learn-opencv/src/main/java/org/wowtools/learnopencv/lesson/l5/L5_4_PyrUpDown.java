package org.wowtools.learnopencv.lesson.l5;

import org.bytedeco.javacpp.opencv_core;

import static org.bytedeco.javacpp.opencv_core.CV_8UC3;
import static org.bytedeco.javacpp.opencv_core.cvCreateMat;
import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgproc.cvPyrDown;
import static org.bytedeco.javacpp.opencv_imgproc.cvPyrUp;

/**
 * 图像金字塔，即如同gis中map的level一样，缩放级别时缩放两倍,只是级别和gis相反
 *
 * @author liuyu
 * @date 2017/2/23
 */
public class L5_4_PyrUpDown {
    public static void main(String[] args) {
        opencv_core.IplImage img = Commonality.loadOriginal("road/2.jpg");
        //lv-1
        org.bytedeco.javacpp.helper.opencv_core.CvArr res = cvCreateMat(img.height() / 2, img.width() / 2, CV_8UC3);
        cvPyrDown(img, res);
        Commonality.showImg("cvPyrDown lv-1", res);

        //lv+1
        res = cvCreateMat(img.height() * 2, img.width() * 2, CV_8UC3);
        cvPyrUp(img, res);
        Commonality.showImg("cvPyrUp lv+1", res);

        cvWaitKey(0);
    }
}
