package com.sqq.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * 传感器工具类
 *
 * @author shuaiqiangqiang
 * @version 1.0 2017-01-03
 * @since JDK 1.7
 */
public class SensorUtil implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor accelerometer; // 加速度传感器
    private Sensor magnetic;      // 地磁场传感器
    private float[] accelerometerValues = new float[3];
    private float[] magneticFieldValues = new float[3];
    private OnRotateListener mListener;
    private float mAngleSaved;  // 记录上一次的旋转角度
    private static final int ANGLE_ADJUST = 10;   // 角度更新偏差值

    public SensorUtil(Context context, OnRotateListener listener) {
        // 实例化传感器管理者
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        // 初始化加速度传感器
        accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // 初始化地磁场传感器
        magnetic = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mListener = listener;
    }

    public void onPause() {
        mSensorManager.unregisterListener(this);   // Unregisters a listener for all sensors.
    }

    public void onResume() {
        // 注册监听
        mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, magnetic, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            accelerometerValues = event.values;
        }
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            magneticFieldValues = event.values;
        }
        float[] R = new float[9];
        boolean flag = SensorManager.getRotationMatrix(R, null, accelerometerValues, magneticFieldValues);
        if (flag) {
            float[] values = new float[3];
            SensorManager.getOrientation(R, values);
            float angle = (float) Math.toDegrees(values[0]);
            if (mListener != null) {
                float adjust = Math.abs(Math.abs(angle) - Math.abs(mAngleSaved));  // 角度偏差
                if (adjust > ANGLE_ADJUST) {
                    mAngleSaved = -angle;
                    mListener.getAngle(mAngleSaved);    //  转换成高德地图的旋转角度，从正北开始，逆时针计算
                    // System.out.println("rotate angle is: " + mAngleSaved);
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public interface OnRotateListener {
        void getAngle(float angle);
    }
}
