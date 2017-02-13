package org.wowtools.learnopencv.lesson.l3;

import static org.bytedeco.javacpp.opencv_core.*;

/**
 * 矩阵的创建和释放
 *
 * @author liuyu
 * @date 2017/2/13
 */
public class L3_2 {
    public static void main(String[] args) {
        /*
        * 创建一个4行3列的矩阵，
        * 第三个参数：S=signed, U=unsigned, F=float. For
        example, CV _ 8UC1 means the elements are 8-bit unsigned and the there is 1 channel, and CV _
        32SC2 means the elements are 32-bit signed and there are 2 channels.
        CV_32FC1为32位浮点型
        CV_8UC3为8位三元数组整形
        * */
        CvMat mat = cvCreateMat(4, 3, CV_8UC3);
        cvReleaseMat(mat);
    }
}
