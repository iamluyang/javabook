package org.gof.creational.patterns3.factorymethod.editor.product.impl;

import org.gof.creational.patterns3.factorymethod.editor.product.api.Document;

public class TxtDocument extends Document {

    public TxtDocument(){

    }

    @Override
    public void open() {
        System.out.println("打开Txt文件" + this.getFile());
    }

    @Override
    public void display()  {
        System.out.println("显示Txt文件" + this.getFile());
    }

    @Override
    public void save() {
        System.out.println("存储Txt文件" + this.getFile());
    }

    @Override
    public void close() {
        System.out.println("关闭Txt文件" + this.getFile());
    }
}
