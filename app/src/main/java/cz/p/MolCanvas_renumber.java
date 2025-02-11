package cz.p;

public class MolCanvas_renumber {
    int AtomNumber_old, AtomNumber_new;

    public MolCanvas_renumber(int AtomNumber_old, int AtomNumber_new) {
        this.AtomNumber_old = AtomNumber_old;
        this.AtomNumber_new = AtomNumber_new;
    }

    public int getAtomNumber_old() {
        return AtomNumber_old;
    }

    public void setAtomNumber_old(int AtomNumber_old) {
        this.AtomNumber_old = AtomNumber_old;
    }

    public int getAtomNumber_new() {
        return AtomNumber_new;
    }

    public void setAtomNumber_new(int AtomNumber_new) {
        this.AtomNumber_new = AtomNumber_new;
    }
}
