package variable.handles;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class ConcurrentClass {

    private int contador = 0;
    public static final VarHandle CONTADOR_HANDLE = getContadorHandle();

    private static VarHandle getContadorHandle() {
        try {
            return MethodHandles.lookup()
                    .findVarHandle(ConcurrentClass.class, "contador", int.class);
        }catch (Exception e) {
            return null;
        }
    }

    public void incrementarContador() {
        CONTADOR_HANDLE.getAndAdd(this, 1);
    }

    public int getContador() {
        return (int) CONTADOR_HANDLE.get(this);
    }

}
