package behavior.visitor;

import java.io.File;

//访问者模式的核心思想是为了访问比较复杂的数据结构，不去改变数据结构，
// 而是把对数据的操作抽象出来，在“访问”的过程中以回调形式在访问者中处理操作逻辑
public interface Visitor {
    // 访问文件夹:
    void visitDir(File dir);
    // 访问文件:
    void visitFile(File file);
}
