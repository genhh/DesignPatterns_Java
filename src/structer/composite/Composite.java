package structer.composite;

import java.util.ArrayList;
import java.util.List;
//类似树形的层次形数据结构可以认为是组合模式
//对单个对象和组合对象的使用具有一致性

public class Composite implements Node{
    private String text;

    public Composite(String text) {
        this.text = text;
    }
    private List<Node> list = new ArrayList<>();
    public Node addNode(Node node) {
        list.add(node);
        return this;
    }

    public List<Node> children() {
        return list;
    }

    public String getText(){
        return this.text;
    }

}
