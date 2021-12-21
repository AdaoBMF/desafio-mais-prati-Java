package one.digitalInovation;

public class BinTree<T extends Comparable<T>> {
    private BinKnot<T> root;

    public BinTree() {
        this.root = null;
    }

    public void insert(T content){
        BinKnot<T> newKnot = new BinKnot<>(content);
        this.root = insert(this.root, newKnot);
    }

    private BinKnot<T> insert(BinKnot<T> current, BinKnot<T> newKnot){
        if(current == null){
            return newKnot;
        }else if(newKnot.getContent().compareTo(current.getContent()) < 0){
            current.setLeftKnot(insert(current.getLeftKnot(), newKnot));
        }else{
            current.setRightKnot(insert(current.getRightKnot(), newKnot));
        }
        return current;
    }

    public void showSorted(){
        System.out.println("\nExibindo em Ordem");
        showSorted(this.root);
    }

    private void showSorted(BinKnot<T> current){
        if(current != null){
            showSorted(current.getLeftKnot());
            System.out.println(current.getContent() + ", ");
            showSorted(current.getRightKnot());
        }
    }

    public void showAfterSort(){
        System.out.println("\nExibindo Pré Ordem");
        showAfterSort(this.root);
    }

    private void showAfterSort(BinKnot<T> current){
        if(current != null){
            showAfterSort(current.getLeftKnot());
            showAfterSort(current.getRightKnot());
            System.out.println(current.getContent() + ", ");
        }
    }

    public void showBeforeSort(){
        System.out.println("\nExibindo Pós Ordem");
        showBeforeSort(this.root);
    }

    private void showBeforeSort(BinKnot<T> current){
        if(current != null){
            System.out.println(current.getContent() + ", ");
            showBeforeSort(current.getLeftKnot());
            showBeforeSort(current.getRightKnot());
        }
    }


}
