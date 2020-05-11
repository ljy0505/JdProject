package com.example.jd2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.jd2.app.AppManager;
import com.example.jd2.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IMainView {
    private long firstKeyBackTime = 0;
    private TabLayout mMytablayout;
    private ViewPager mViewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }
    @Override
    public void initLinstener() {

    }

    @Override
    public void initData() {
        Toast.makeText(this, "调用P层网络请求", Toast.LENGTH_SHORT).show();
        mPresenter.getRecommendList();
    }

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    /**
     * 双击退出    时间分发    onTouchEvent、  disPatchTouch、onInterc...
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //菜单  home  返回键
        //点击屏幕的时候 按下 抬起 移动
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            //获取当前点击返回键的事件
            long currentTime = System.currentTimeMillis();
            if (currentTime - firstKeyBackTime > 2000) {
                //表示不能退出
                firstKeyBackTime = currentTime;
                Toast.makeText(this, "再点击一次返回键，退出当前应用", Toast.LENGTH_SHORT).show();
            } else {
                //成立  关闭应用
                AppManager.getInstance().appExit();
            }
        }
        return super.onKeyUp(keyCode, event);
    }

}
