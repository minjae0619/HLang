package com.mj.h.objects;

public abstract class Expression<T> extends Node{


    public abstract T get(Event event);


}
