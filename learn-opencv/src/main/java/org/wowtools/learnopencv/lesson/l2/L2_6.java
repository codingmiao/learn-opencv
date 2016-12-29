package org.wowtools.learnopencv.lesson.l2;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_highgui.CV_WINDOW_AUTOSIZE;
import static org.bytedeco.javacpp.opencv_highgui.cvDestroyWindow;
import static org.bytedeco.javacpp.opencv_highgui.cvNamedWindow;
import static org.bytedeco.javacpp.opencv_highgui.cvShowImage;
import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.wowtools.learnopencv.Constant;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.*;

/**
 * cvCanny边缘检测
 * @author liuyu
 *
 */
public class L2_6 {

	public static void main(String[] args) {
		String imgName = "logo.png";
		IplImage img = cvLoadImage(Constant.filePath + imgName);
		cvNamedWindow(imgName, CV_WINDOW_AUTOSIZE);
		cvShowImage(imgName, img);
		System.out.println(img.depth());
		IplImage out = cvCreateImage(cvGetSize(img), IPL_DEPTH_8U, 1);
		/**
		 * 第一个参数表示输入图像
		 * 
		 * 第二个参数表示输出的边缘图像，为单通道黑白图。
		 * 
		 * 第三个参数和第四个参数表示阈值，这二个阈值中当中的小阈值用来控制边缘连接，大的阈值用来控制强边缘的初始分割即如果一个像素的梯度大与上限值，
		 * 则被认为是边缘像素，如果小于下限阈值，则被抛弃。如果该点的梯度在两者之间则当这个点与高于上限值的像素点连接时我们才保留，否则删除。
		 */
		cvCanny(img, out, 0.5, 0.6);
		cvShowImage("out", out);
		cvWaitKey(0);
		cvRelease(img);
		cvRelease(out);
		cvDestroyWindow(imgName);
		cvDestroyWindow("out");
		System.out.println("ok");
	}

}
