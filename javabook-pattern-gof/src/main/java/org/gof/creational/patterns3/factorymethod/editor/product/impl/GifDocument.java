package org.gof.creational.patterns3.factorymethod.editor.product.impl;

import org.gof.creational.patterns3.factorymethod.editor.product.api.Document;

public class GifDocument extends Document {

    public GifDocument(){

    }

    @Override
    public void open() {
        System.out.println("打开Gif档案" + this.getFile());
    }

    @Override
    public void display()  {
        System.out.println("显示Gif档案" + this.getFile());
    }

    @Override
    public void save() {
        System.out.println("存储Gif档案" + this.getFile());
    }

    @Override
    public void close() {
        System.out.println("关闭Gif档案" + this.getFile());
    }
}
