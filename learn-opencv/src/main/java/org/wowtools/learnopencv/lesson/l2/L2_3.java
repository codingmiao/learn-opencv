package org.wowtools.learnopencv.lesson.l2;

import org.bytedeco.javacpp.opencv_videoio.CvCapture;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.helper.opencv_core.CvArr;
import org.bytedeco.javacpp.indexer.IntBufferIndexer;
import org.wowtools.learnopencv.Constant;

import static org.bytedeco.javacpp.opencv_highgui.*;
import static org.bytedeco.javacpp.opencv_videoio.*;

import java.nio.IntBuffer;


/**
 * 视频播放控制
 * 
 * @author liuyu
 *
 */
public class L2_3 {
	
	private static CvCapture capture;
	
	public static void main(String[] args) {
		String videoioName = "mv.avi";
		capture = cvCreateFileCapture(Constant.filePath + videoioName);
		cvNamedWindow(videoioName, CV_WINDOW_AUTOSIZE);
		int sz = (int) cvGetCaptureProperty(capture, CV_CAP_PROP_FRAME_COUNT);
		if(0!=sz){
			IntBuffer cc = IntBuffer.allocate(1024);
			CvTrackbarCallback2 cb = new CvTrackbarCallback2(capture){
				@Override
				public void call(int pos, Pointer userdata) {
					System.out.println(111111111111L);
					super.call(pos, userdata);
				}
			};//蜜汁报错--
			cvCreateTrackbar2("pos", videoioName,cc, sz, cb);
		}
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
	
	public static void onTrackbarSlide(int pos){
		cvSetCaptureProperty(capture, CV_CAP_PROP_POS_FRAMES, pos);
	}
}
