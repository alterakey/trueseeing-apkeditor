package com.reandroid.commons.utils.log;

import java.io.PrintStream;

public class StdLogger extends Logger{
    private static StdLogger sInstance;
    private final Object mLock=new Object();
    private final PrintStream printStream;
    private boolean mSameLine;
    private StdLogger() {
        super();
        this.printStream=System.err;
    }
    @Override
    public void writeLine(String line) {
        synchronized (mLock){
            if(line==null){
                line="null";
            }
            printStream.println(line);
        }
    }
    @Override
    public void writeSameLine(String line) {
        synchronized (mLock){
	    writeLine(line);
        }
    }
    static StdLogger getInstance(){
        if(sInstance!=null){
            return sInstance;
        }
        synchronized (StdLogger.class){
            sInstance=new StdLogger();
            sInstance.setEnable(true);
            return sInstance;
        }
    }
}
