package TEST;

import Trees.BST;
import Trees.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BST_Test {
    Tree Bst;
    Tree emptyBst;

    @BeforeEach
    void prepare(){
        Bst = new BST();
        emptyBst = new BST();
        Bst.insert(10);
        Bst.insert(5);
        Bst.insert(90);
        Bst.insert(9);
        Bst.insert(40);
        Bst.insert(20);
        Bst.insert(15);

    }

    @Test
    void insert() {
        assertEquals(true ,emptyBst.insert(20));
        assertEquals(true,emptyBst.insert(10));
        assertEquals(true, emptyBst.insert(5));
        assertEquals(true, emptyBst.insert(100));
        assertEquals(false, emptyBst.insert(10));
    }

    @Test
    void heightAndLeavesAndNodes() {
        emptyBst.insert(12);
        emptyBst.insert(10);
        emptyBst.insert(11);
        emptyBst.insert(9);
        emptyBst.insert(14);
        emptyBst.insert(13);
        emptyBst.insert(15);

        assertEquals(2, emptyBst.getHeight());
        assertEquals(4, emptyBst.leavesNumber());
        assertEquals(3, emptyBst.nodesNumber());

        emptyBst.remove(15);
        emptyBst.remove(12);

        assertEquals(2, emptyBst.getHeight());
        assertEquals(3, emptyBst.leavesNumber());
        assertEquals(2, emptyBst.nodesNumber());

    }

    @Test
    void remove() {
        assertEquals(9, Bst.remove(9).getKey());
        assertEquals(90, Bst.remove(90).getKey());
        assertEquals(10, Bst.remove(10).getKey());
        assertEquals(null, Bst.remove(10));
        assertEquals(4, Bst.getSize());
        assertEquals(false, Bst.search(10));
        assertEquals(false, Bst.search(90));
        assertEquals(false, Bst.search(9));
    }

    @Test
    void size() {
        emptyBst.insert("aa");
        emptyBst.insert("ba");

        assertEquals(2, emptyBst.getSize());
        assertEquals(7, Bst.getSize());
    }

    @Test
    void search() {
        assertEquals(true, Bst.search(20));
        assertEquals(true, Bst.search(10));
        assertEquals(true, Bst.search(5));
        assertEquals(false, Bst.search(100));
        assertEquals(false, emptyBst.search(30));
    }

    @Test
    void maxElement() {
        assertEquals(90, Bst.getMax().getKey());
        assertThrows(NullPointerException.class, () -> emptyBst.getMax());
    }

    @Test
    void minElement() {
        assertEquals(5, Bst.getMin().getKey());
        assertThrows(NullPointerException.class, () -> emptyBst.getMin());
    }
}
