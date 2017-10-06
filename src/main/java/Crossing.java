import java.util.HashSet;
import java.util.Set;

public interface Crossing {
    Set<Items> leftSide = new HashSet<>();
    Set<Items> rightSide = new HashSet<>();

    void move(Items man, Items item) throws Exception;
    void move(Items man)throws Exception;

    default Set<Items> getLeft(){
        return leftSide;
    }
    default Set<Items> getRight(){
        return rightSide;
    }
}
