package org.yj.application.data.design.pattern.chain;

public interface Logger {

   public void setNext(Logger logger);

   public Logger getNext();

   public void log( );
}
