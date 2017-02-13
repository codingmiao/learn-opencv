package org.wowtools.learnopencv.lesson.l3;
import static org.bytedeco.javacpp.opencv_core.*;
/**
 * 用固定参数创造一个矩阵
 * @author liuyu
 * @date 2017/2/13
 */
public class L3_3 {
    public static void main(String[] args) {
        float[] vals = {0.8f,-0.5f,0.5f,0.8f};
        CvMat rotmat = new CvMat();
        rotmat = cvInitMatHeader(rotmat,2,2,CV_32FC1);//做成一个2*2的矩阵
        System.out.println(cvGetElemType(rotmat));//矩阵中元素类型
        System.out.println(cvGetDims(rotmat));//矩阵维数
        System.out.println(cvGetDimSize(rotmat,0));//用不了..获取第idx个维度的大小
    }
}
