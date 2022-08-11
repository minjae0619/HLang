package com.mj.h.objects.effect;

import com.mj.h.HLanguage;
import com.mj.h.objects.Effect;
import com.mj.h.objects.Event;

public class EffVariables extends Effect{

    static{
        HLanguage.registerEffect(new EffVariables(), "정수\"줘\" %string%");
        //정수"줘" %string%
    }
    //정수"줘" varName = 줘줘 설정해"줘"

    @Override
    public void execute(Event event) {

    }
}
