package com.example.jd2.app;

import android.app.Activity;
import android.os.Process;

import androidx.fragment.app.Fragment;

import java.util.Stack;

public class AppManager {

    // 初始化 Activity和Fragment 管理栈
    // 人为写的一个  集合
    private static Stack<Activity> activityStack = new Stack<>();
    private static Stack<Fragment> fragmentStack = new Stack<>();

    //内存判断
    private static volatile AppManager appManager;
    //添加
    //删除


    private AppManager() {

    }

    public static AppManager getInstance() {
        if (appManager == null) {
            synchronized (AppManager.class) {
                if (appManager == null) {
                    appManager = new AppManager();
                }
            }
        }
        return appManager;
    }

    /**
     * 获取所有Activity
     *
     * @return
     */
    public static Stack<Activity> getActivityStack() {
        return activityStack;
    }

    /**
     * 获取所有fragment
     *
     * @return
     */
    public static Stack<Fragment> getFragmentStack() {
        return fragmentStack;
    }

    /**
     * 栈：先进后出
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    public void addFragment(Fragment fragment) {
        if (fragmentStack == null) {
            fragmentStack = new Stack<>();
        }
        fragmentStack.add(fragment);
    }

    /**
     * 移除指定activity
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            activityStack.remove(activity);
        }
    }

    /*public void removeFragment(Fragment fragment) {
        if (fragment != null) {
            fragment.finish();
            fragmentStack.remove(fragment);
        }
    }*/

    //删除当前Activity
    public void deleteActivity() {
        Activity activity = activityStack.lastElement();
        if (activity != null) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

   /* public void deleteFragment() {
        Fragment fragment = fragmentStack.lastElement();
        if (fragment != null) {
            if (!fragment.isFinishing()) {
                fragment.finish();
            }
        }
    }*/

    //Fragment  和 Activity类似


    public void appExit() {
        for (int i = 0; i < activityStack.size(); i++) {
            if (activityStack.get(i) != null) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
        System.exit(0);
        Process.killProcess(Process.myPid());

        //双击退出
        //1.点击返回键  2.判断返回键时间间隔 3.满足appExit

    }
}
