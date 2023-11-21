package structer.decorator.impl;

import structer.decorator.TextNode;

//装饰器，装饰SpanNode等一系列从TextNode接口实现得到的核心类
public class BoldDecorator extends NodeDecorator{
    public BoldDecorator(TextNode target) {
        super(target);
    }

    public String getText() {
        return "<b>" + target.getText() + "</b>";
    }
}
