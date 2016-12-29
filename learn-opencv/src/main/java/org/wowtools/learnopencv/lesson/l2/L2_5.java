package org.wowtools.learnopencv.lesson.l2;

import static org.bytedeco.javacpp.opencv_core.IPL_DEPTH_8U;
import static org.bytedeco.javacpp.opencv_core.cvCreateImage;
import static org.bytedeco.javacpp.opencv_core.cvGetSize;
import static org.bytedeco.javacpp.opencv_core.cvRelease;
import static org.bytedeco.javacpp.opencv_highgui.CV_WINDOW_AUTOSIZE;
import static org.bytedeco.javacpp.opencv_highgui.cvDestroyWindow;
import static org.bytedeco.javacpp.opencv_highgui.cvNamedWindow;
import static org.bytedeco.javacpp.opencv_highgui.cvShowImage;
import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgproc.CV_GAUSSIAN;
import static org.bytedeco.javacpp.opencv_imgproc.cvSmooth;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.wowtools.learnopencv.Constant;
import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
/**
 * 创建一副原图大小一半的图片
 * @author liuyu
 *
 */
public class L2_5 {
	public static void main(String[] args) {
		String imgName = "logo.png";
		IplImage img = cvLoadImage(Constant.filePath + imgName);
		cvNamedWindow(imgName, CV_WINDOW_AUTOSIZE);// CV_WINDOW_AUTOSIZE 根据图片大小自动设置窗口大
		cvShowImage(imgName, img);
		IplImage out = cvCreateImage(cvSize(img.width()/2, img.height()/2),img.depth(),img.nChannels());
		cvPyrDown(img, out);
		cvShowImage("out", out);
		cvWaitKey(0);
		cvRelease(img);
		cvRelease(out);
		cvDestroyWindow(imgName);
		cvDestroyWindow("out");
		System.out.println("ok");
	}
}
