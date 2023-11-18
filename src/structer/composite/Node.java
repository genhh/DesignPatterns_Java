package structer.composite;

import java.util.List;

public interface Node {
    Node addNode(Node node);//添加节点
    List<Node> children();//获取子节点

    String getText();
}
