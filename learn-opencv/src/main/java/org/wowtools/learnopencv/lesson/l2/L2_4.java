package org.wowtools.learnopencv.lesson.l2;

import static org.bytedeco.javacpp.opencv_core.cvRelease;
import static org.bytedeco.javacpp.opencv_highgui.CV_WINDOW_AUTOSIZE;
import static org.bytedeco.javacpp.opencv_highgui.cvDestroyWindow;
import static org.bytedeco.javacpp.opencv_highgui.cvNamedWindow;
import static org.bytedeco.javacpp.opencv_highgui.cvShowImage;
import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.wowtools.learnopencv.Constant;

/**
 * 载入一幅图像并进行平滑处理
 * @author liuyu
 *
 */
public class L2_4 {
	public static void main(String[] args) {
		String imgName = "logo.png";
		IplImage img = cvLoadImage(Constant.filePath + imgName);
		cvNamedWindow(imgName, CV_WINDOW_AUTOSIZE);// CV_WINDOW_AUTOSIZE 根据图片大小自动设置窗口大
		cvShowImage(imgName, img);
		IplImage out = cvCreateImage(cvGetSize(img), IPL_DEPTH_8U, 3);
		cvSmooth(img, out,CV_GAUSSIAN,3,3,0,0);
		cvShowImage("out", out);
		cvWaitKey(0);
		cvRelease(img);
		cvRelease(out);
		cvDestroyWindow(imgName);
		cvDestroyWindow("out");
		System.out.println("ok");
	}
}
