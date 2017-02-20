package org.wowtools.learnopencv.lesson.l5;

import org.bytedeco.javacpp.opencv_core;

import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_imgproc.CV_BLUR_NO_SCALE;
import static org.bytedeco.javacpp.opencv_imgproc.cvSmooth;
/**
 * 平滑处理
 * @author liuyu
 * @date 2017/2/20
 */
public class L5_1_Smooth {
    public static void main(String[] args) {
        opencv_core.IplImage img = Commonality.loadOriginal("road/1.jpg");
        /**
         * src
         输入图像.
         dst
         输出图像.
         smoothtype  平滑方法:
         ·CV_BLUR_NO_SCALE (简单不带尺度变换的模糊) - 对每个象素的 param1×param2 领域求和。
         如果邻域大小是变化的，可以事先利用函数 cvIntegral 计算积分图像。
         ·CV_BLUR (simple blur) - 对每个象素 param1×param2 邻域  求和并做尺度变换 1/(param1•param2).
         ·CV_GAUSSIAN (gaussian blur) - 对图像进行核大小为 param1×param2 的高斯卷积  •
         ·CV_MEDIAN (median blur) - 对图像进行核大小为 param1×param1 的中值滤波 (i.e. 邻域是方的).  •
         ·CV_BILATERAL (双向滤波) - 应用双向 3x3 滤波，彩色 sigma=param1，空间 sigma=param2.
         关于双向滤波，可参考 http://www.dai.ed.ac.uk/CVonline/LOCAL_COPIES/MANDUCHI1/Bilateral_Filtering.ht ml
         param1  平滑操作的第一个参数.
         param2  平滑操作的第二个参数. 对于简单/非尺度变换的高斯模糊的情况，如果 param2 的值 为零， 则表示其被设定为 param1。  param3  对应高斯参数的 Gaussian sigma (标准差). 如果为零，则标准差由下面的核尺寸计算：               sigma = (n/2 - 1)*0.3 + 0.8, 其中 n=param1 对应水平核,                                                 n=param2 对应垂直核.                对小的卷积核 (3×3 to 7×7) 使用如上公式所示的标准 sigma 速度会快。如果 param3 不为 零，而 param1 和 param2 为零，则核大小有 sigma 计算 (以保证足够精确的操作).
         */
        cvSmooth(img,img);
        Commonality.showImg("cvSmooth",img);
        cvWaitKey(0);
    }
}
