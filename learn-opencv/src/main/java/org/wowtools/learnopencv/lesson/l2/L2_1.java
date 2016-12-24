package org.wowtools.learnopencv.lesson.l2;

import static org.bytedeco.javacpp.opencv_core.*;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.wowtools.learnopencv.Constant;

import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import static org.bytedeco.javacpp.opencv_highgui.*;
/**
 * 加载一张图片并在屏幕上显示
 * @author liuyu
 *
 */
public class L2_1 {
	public static void main(String[] args) {
		String imgName = "logo.png";
		IplImage img = cvLoadImage(Constant.filePath + imgName);
		cvNamedWindow(imgName, CV_WINDOW_AUTOSIZE);// CV_WINDOW_AUTOSIZE 根据图片大小自动设置窗口大
		cvShowImage(imgName, img);
		cvWaitKey(0);
		cvRelease(img);
		cvDestroyWindow(imgName);
		System.out.println("ok");
	}
}
