package com.mj.h.objects.effect;

import com.mj.h.HLanguage;
import com.mj.h.objects.Effect;
import com.mj.h.objects.Event;
import com.mj.h.objects.Expression;

import java.util.regex.Pattern;

public class ExpVariables extends Expression<Integer> {

    static{
        HLanguage.registerExpression(new ExpVariables(), Integer.class, "%integer% 설정해\"줘\"");
    }

    @Override
    public Integer get(Event event) {
        return null;
    }
}
