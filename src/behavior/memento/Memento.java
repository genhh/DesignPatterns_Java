package behavior.memento;

//捕获一个对象的内部状态，以便在将来的某个时候恢复此状态
//example: 保存/打开 图像编辑器 序列化等
public class Memento {
    private StringBuilder buffer = new StringBuilder();

    public void add(String s) {
        buffer.append(s);
    }

    // 获取状态:
    public String getState() {
        return buffer.toString();
    }

    // 恢复状态:
    public void setState(String state) {
        this.buffer.delete(0, this.buffer.length());
        this.buffer.append(state);
    }

    public void show(){
        System.out.println(buffer);
    }
}
