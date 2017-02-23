package org.wowtools.learnopencv.lesson.l5;

import org.bytedeco.javacpp.opencv_core;

import static org.bytedeco.javacpp.opencv_core.CV_8UC3;
import static org.bytedeco.javacpp.opencv_core.cvCreateMat;
import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgproc.*;
/**
 * 重设图片大小
 *
 * @author liuyu
 * @date 2017/2/23
 */
public class L5_4_Resize {
    public static void main(String[] args) {
        opencv_core.IplImage img = Commonality.loadOriginal("road/2.jpg");
        //缩放到一半大小
        org.bytedeco.javacpp.helper.opencv_core.CvArr res = cvCreateMat(img.height()/2, img.width()/2, CV_8UC3);

        /**
         * 可选的插值方式如下：

         INTER_NEAREST - 最近邻插值
         INTER_LINEAR - 线性插值（默认值）
         INTER_AREA - 区域插值（利用像素区域关系的重采样插值）
         INTER_CUBIC –三次样条插值（超过4×4像素邻域内的双三次插值）
         INTER_LANCZOS4 -Lanczos插值（超过8×8像素邻域的Lanczos插值）
         若要缩小图像，一般情况下最好用CV_INTER_AREA来插值，

         而若要放大图像，一般情况下最好用CV_INTER_CUBIC（效率不高，慢，不推荐使用）
         或CV_INTER_LINEAR（效率较高，速度较快，推荐使用）。
         */
        cvResize(img,res);
        Commonality.showImg("resize",res);
        cvWaitKey(0);
    }
}
