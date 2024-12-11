package org.yj.application.data.design.pattern.chain;

import java.util.ArrayList;
import java.util.List;

public class LoggerChain {
    Logger logger;

    List<Logger> list= new ArrayList<>();
    public List<Logger>  addLogger(Logger logger){
        list.add(logger);
        return this.list;
    }
    public void execute( ) {
       /* while(logger!=null){
            logger.log();
            logger = logger.getNext();
        }*/
        for (Logger curr : list) {
            if(curr!=null){
                curr.log();
            }
        }
    }

    public static void main(String[] args) {
        LoggerDebug debug = new LoggerDebug();
        LoggerInfo info = new LoggerInfo();
        LoggerWarn warn = new LoggerWarn();


        LoggerChain chain = new LoggerChain();
       chain.addLogger(debug);
       chain.addLogger(info);
       chain.addLogger(warn);
        chain.execute();
    }

}
