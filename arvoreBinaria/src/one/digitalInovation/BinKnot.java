package one.digitalInovation;

public class BinKnot<T extends Comparable<T>> {
    private T content;
    private BinKnot leftKnot;
    private BinKnot rightKnot;

    public BinKnot(T content) {
        this.content = content;
        this.leftKnot = this.rightKnot = null;
    }

    public BinKnot() {
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public BinKnot getLeftKnot() {
        return leftKnot;
    }

    public void setLeftKnot(BinKnot leftKnot) {
        this.leftKnot = leftKnot;
    }

    public BinKnot getRightKnot() {
        return rightKnot;
    }

    public void setRightKnot(BinKnot rightKnot) {
        this.rightKnot = rightKnot;
    }

    @Override
    public String toString() {
        return "BinKnot{" +
                "content=" + content +
                '}';
    }
}
