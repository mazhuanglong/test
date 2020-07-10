package com.example.todayinformation.main.tool;

import androidx.annotation.IntDef;

import static com.example.todayinformation.main.tool.MainConstantTool.*;

/**
 * on  2020/7/10}
 */

@IntDef({SHANGHAI,HANGZHOU,BEIJING,SHENZHEN})
public @interface MainConstantTool {
    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;

}
