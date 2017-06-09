package axoloti.mvc;

import java.util.ArrayList;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 *
 * @author jtaelman
 */
public class AbstractDocumentRoot {

    UndoManager undoManager = new UndoManager();

    public UndoManager getUndoManager() {
        return undoManager;
    }

    private ArrayList<UndoableEditListener> undoListeners = new ArrayList<>();

    public void addUndoListener(UndoableEditListener uel) {
        undoListeners.add(uel);
    }

    public void fireUndoListeners(UndoableEditEvent e) {
        for (UndoableEditListener uel : undoListeners) {
            uel.undoableEditHappened(e);
        }
    }

}