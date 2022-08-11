package com.mj.h;

import com.mj.h.objects.Effect;
import com.mj.h.objects.Expression;
import com.mj.h.objects.effect.ExpVariables;
import com.mj.h.ui.MainUI;
import com.mj.h.utils.Scan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HLanguage {


    public final static String PROJECT_PATH = System.getProperty("user.dir");



    public static void main(String[] args){
        MainUI mainUI = new MainUI();
        mainUI.view();
        Scan.run();
        new ExpVariables();

    }

    public static void registerEffect(Effect effect, String pattern){

    }

    public static void registerExpression(Expression<?> expression, Class<?> returnType, String codePattern){
        Pattern pattern = Pattern.compile("%[a-zA-Z0-9]*%"); // %integer% 설정해"줘"
        Matcher matcher = pattern.matcher(codePattern + " %string%");
        while (matcher.find()) {
            System.out.println(matcher.group().replace("%", ""));
        }
    }

}
