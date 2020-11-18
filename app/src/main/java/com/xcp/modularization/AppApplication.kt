package com.xcp.modularization

import android.app.Application
import com.xcp.common.utils.RecordPathManager
import com.xcp.home.HomeMainActivity
import com.xcp.user.UserMainActivity

/**
 * Created by 许成谱 on 2020/11/17 19:24.
 * qq:1550540124
 * 热爱生活每一天！
 */
class AppApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        // 如果项目有100个Activity，这种加法会不会太那个？  缺点
        RecordPathManager.addGroupInfo("home","HomeMainActivity", HomeMainActivity::class.java)
        RecordPathManager.addGroupInfo("user","UserMainActivity", UserMainActivity::class.java)
    }
}