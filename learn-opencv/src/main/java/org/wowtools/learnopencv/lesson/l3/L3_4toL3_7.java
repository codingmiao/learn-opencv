package org.wowtools.learnopencv.lesson.l3;

import org.bytedeco.javacpp.opencv_core;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_core.cvPtrND;

/**
 * 存取矩阵
 *
 * @author liuyu
 * @date 2017/2/13
 */
public class L3_4toL3_7 {
    public static void main(String[] args) {
        //3-4 3-5
        opencv_core.CvMat mat = cvCreateMat(5, 5, CV_32FC1);
        //教材中的CV_MAT_ELEM_PTR CV_MAT_ELEM函数在javacv中被set get 方法替代
        cvmSet(mat, 3, 2, 7.7f);//将mat[3,2]设为7.7
        System.out.println(cvmGet(mat, 3, 2));

        //3-6
        //建一个多维矩阵 这里有点问题--
        opencv_core.CvMat matND = cvCreateMat(5, 5, CV_32FC4);
        CvScalar scalar = new CvScalar(255, 120, 133, 200);
        cvSetND(matND, new int[]{3, 2}, scalar);
        System.out.println("cvGetDims(matND)"+cvGetDims(matND));
        //维数不对--
        byte[] bt = cvPtrND(matND, new int[]{3, 2, 0, 0, 0, 0});
        for (byte b : bt) {
            System.out.print(b + ",");
        }
        System.out.println();

        CvScalar sc = cvGetND(matND, new int[]{3, 2});
        System.out.println(sc.val(3));
    }

}
