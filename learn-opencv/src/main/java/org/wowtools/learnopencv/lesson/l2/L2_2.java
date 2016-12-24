package org.wowtools.learnopencv.lesson.l2;

import org.bytedeco.javacpp.opencv_videoio.CvCapture;
import org.bytedeco.javacpp.helper.opencv_core.CvArr;
import org.wowtools.learnopencv.Constant;

import static org.bytedeco.javacpp.opencv_highgui.*;
import static org.bytedeco.javacpp.opencv_videoio.*;

import java.io.File;

/**
 * 视频播放，目测只支持avi格式，可先转换一下
 * </p>
 * 若cvCreateFileCapture为空，先下载安装编码器:http://www.xvidmovies.com/codec/
 * 
 * @author liuyu
 *
 */
public class L2_2 {

	public static void main(String[] args) {
		String videoioName = "mv.avi";
		File f = new File(Constant.filePath + videoioName);
		System.out.println(f.exists());
		CvCapture capture = cvCreateFileCapture(Constant.filePath + videoioName);
		cvNamedWindow(videoioName, CV_WINDOW_AUTOSIZE);
		CvArr frame = null;
		while (true) {
			frame = cvQueryFrame(capture);
			if (null == frame) {
				break;
			}
			cvShowImage(videoioName, frame);
			int c = cvWaitKey(33);// 等待33ms
			if (c == 27) {// 按esc退出
				break;
			}
		}
		cvReleaseCapture(capture);
		cvDestroyWindow(videoioName);
	}

}
