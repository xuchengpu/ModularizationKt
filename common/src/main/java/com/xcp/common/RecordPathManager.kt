package com.xcp.common.utils

import android.util.Log
import com.xcp.common.PathBean

/**
 * Created by 许成谱 on 2020/11/17 18:59.
 * qq:1550540124
 * 热爱生活每一天！
 * 全局路径记录器（根据子模块进行分组）
 * 组名：app，order，personal
 * 详情order=[Order_MainActivity,Order_MainActivity2,Order_MainActivity3]
 */
class RecordPathManager {
    companion object {
        /**
         * 先理解成 仓库
         * group: app,order,personal
         *
         * order:
         *      OrderMainActivity1
         *      OrderMainActivity2
         *      OrderMainActivity3
         */

        val maps = hashMapOf<String, ArrayList<PathBean>>()

        /**
         * 将路径信息加入全局Map
         *
         * [groupName] 组名，如："personal"
         * [pathName]  路劲名，如："Personal_MainActivity"
         * [clazz]     类对象，如：Personal_MainActivity.class
         */
        fun addGroupInfo(groupName: String, pathName: String, clazz: Class<*>) {
            var storage = maps.get(groupName)
            if (storage == null) {
                storage = arrayListOf()
                storage.add(PathBean(pathName, clazz))
                maps.put(groupName, storage)
            } else {
                storage.add(PathBean(pathName, clazz))
            }
        }

        /**
         * 只需要告诉我，组名 ，路径名，  就能返回 "要跳转的Class"
         *  [groupName] 组名 oder
         *  [pathName] 路径名  OrderMainActivity1
         * @return 跳转目标的class类对象
         */

        fun startTargetActivity(
            groupName: String?,
            pathName: String
        ): Class<*>? {
            val list: List<PathBean>? = maps[groupName]
            if (list == null) {
                Log.d(Config.TAG, "startTargetActivity 此组名得到的信息，并没有注册进来哦...")
                return null
            }
            // 遍历 寻找 去匹配 “PathBean”对象
            for (pathBean in list) {
                if (pathName.equals(pathBean.path, ignoreCase = true)) {
                    return pathBean.clazz
                }
            }
            return null
        }
    }


}