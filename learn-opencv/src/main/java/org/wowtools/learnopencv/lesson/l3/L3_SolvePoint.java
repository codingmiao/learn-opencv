package org.wowtools.learnopencv.lesson.l3;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_imgproc;

import java.util.Random;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_highgui.*;

/**
 * 用最小二乘法拟合一条直线
 *
 * @author liuyu
 * @date 2017/2/17
 */
public class L3_SolvePoint {
    private static int imgSize = 512;

    public static void main(String[] args) {
        CvPoint[] pts = buildPoints();
        double[] v = solve(pts);
        double a = v[0];
        double b = v[1];
        double c = v[2];
        System.out.println(a + "x+" + b + "y+" + c + "=0");
        System.out.println("y=" + (-a / b) + "x+" + c / b);
        //AX+BY+C=0 -> y = -(ax+c)/b
        CvPoint pt1 = cvPoint(0, (int) (-(a * 0 + c) / b));
        CvPoint pt2 = cvPoint(imgSize, (int) (-(a * imgSize + c) / b));

        opencv_core.CvSize size = cvSize(imgSize, imgSize);
        opencv_core.IplImage img = cvCreateImage(size, 8, 3);//三个参数分别是大小，色深，通道数
        opencv_imgproc.cvLine(img, pt1, pt2,
                cvScalar(0, 255, 0, 0));
        CvScalar colorPt = cvScalar(0, 0, 255, 0);
        for (CvPoint pt : pts) {
            opencv_imgproc.cvCircle(img, pt, 3, colorPt);
        }

        cvNamedWindow("L3_SolvePoint", CV_WINDOW_AUTOSIZE);
        cvShowImage("L3_SolvePoint", img);
        cvWaitKey(0);
    }

    private static CvPoint[] buildPoints() {
        Random r = new Random(233);
        int ptNum = 30;
        CvPoint[] pts = new CvPoint[ptNum];
        for (int i = 0; i < ptNum; i++) {
            int x = r.nextInt(imgSize);
            int y = (int) (0.8*x + +60 + r.nextInt(10));//y=0.8x+60 再加上点误差
            pts[i] = cvPoint(x, y);
        }
        return pts;
    }

    //求方程组 AX+BY+C=0 的最小二乘解
    private static double[] solve(CvPoint[] pts) {
        CvArr l = cvCreateMat(pts.length, 3, CV_32F);
        for (int i = 0; i < pts.length; i++) {
            CvPoint p = pts[i];
            System.out.println(p.x() + " " + p.y());
            cvSetReal2D(l, i, 0, p.x());
            cvSetReal2D(l, i, 1, p.y());
            cvSetReal2D(l, i, 2, 1);
        }
        CvArr r = cvCreateMat(3, 1, CV_32F);
        cvZero(r);
        CvArr res = cvCreateMat(3, 1, CV_32F);
        int s = cvSolve(l, r, res);
        System.out.println("结果有效？:"+(1==s));
        if(Double.isInfinite(cvGetReal1D(res, 0)) || Double.isNaN(cvGetReal1D(res, 0))){
            System.out.println("迷之错误--，再试一次");
        }
        return new double[]{cvGetReal1D(res, 0), cvGetReal1D(res, 1), cvGetReal1D(res, 2)};
    }


}
