package org.gof.creational.patterns3.factorymethod.editor.product.impl;

import org.gof.creational.patterns3.factorymethod.editor.product.api.Document;

public class PngDocument extends Document {

    public PngDocument(){

    }

    @Override
    public void open() {
        System.out.println("打开PNG档案" + this.getFile());
    }

    @Override
    public void display()  {
        System.out.println("显示PNG档案" + this.getFile());
    }

    @Override
    public void save() {
        System.out.println("存储PNG档案" + this.getFile());
    }

    @Override
    public void close() {
        System.out.println("关闭PNG档案" + this.getFile());
    }
}
