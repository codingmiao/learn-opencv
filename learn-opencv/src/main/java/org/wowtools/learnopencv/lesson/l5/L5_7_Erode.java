package org.wowtools.learnopencv.lesson.l5;

import org.bytedeco.javacpp.opencv_core;

import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgproc.CV_SHAPE_ELLIPSE;
import static org.bytedeco.javacpp.opencv_imgproc.cvCreateStructuringElementEx;
import static org.bytedeco.javacpp.opencv_imgproc.cvErode;

/**
 * 腐蚀
 *
 * @author liuyu
 * @date 2017/2/20
 */
public class L5_7_Erode {
    public static void main(String[] args) {
        opencv_core.IplImage img = Commonality.loadOriginal("road/3.jpg");

        /*
        自定义一个核
        cols  结构元素的列数目
        rows  结构元素的行数目
        anchor_x  锚点的相对水平偏移量
        anchor_y  锚点的相对垂直便宜量
        shape  结构元素的形状，可以是下列值：
            • CV_SHAPE_RECT, 长方形元素;
            • CV_SHAPE_CROSS, 交错元素 a cross-shaped element;
            • CV_SHAPE_ELLIPSE, 椭圆元素;
            • CV_SHAPE_CUSTOM, 用户自定义元素。这种情况下参数 values 定义了 mask,即象素 的那个邻域必须考虑。
         */
        opencv_core.IplConvKernel elementEx =
                cvCreateStructuringElementEx(4, 4, 2, 2, CV_SHAPE_ELLIPSE);
        /**
         * 用自定义的核腐蚀一次
         * 腐蚀会使得亮度高的区域被缩小和隔离
         * 于是缩小掉了田埂等小路，是的识别道路时不会识别它们
         */
        cvErode(img, img, elementEx, 1);
        Commonality.showImg("cvErode", img);
        cvWaitKey(0);
    }
}
